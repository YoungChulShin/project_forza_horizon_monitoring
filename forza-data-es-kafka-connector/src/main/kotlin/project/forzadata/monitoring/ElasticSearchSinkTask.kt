package project.forzadata.monitoring

import com.google.gson.Gson
import org.apache.http.HttpHost
import org.apache.kafka.common.config.ConfigException
import org.apache.kafka.connect.errors.ConnectException
import org.apache.kafka.connect.sink.SinkRecord
import org.apache.kafka.connect.sink.SinkTask
import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.bulk.BulkRequest
import org.elasticsearch.action.bulk.BulkResponse
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.xcontent.XContentType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException
import java.lang.Exception

class ElasticSearchSinkTask : SinkTask() {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(ElasticSearchSinkTask::class.java)
    }

    private lateinit var config: ElasticSearchSinkConnectorConfig
    private lateinit var esClient: RestHighLevelClient
    private val gson = Gson()

    override fun version(): String {
        return "1.0"
    }

    override fun start(props: MutableMap<String, String>) {
        try {
            this.config = ElasticSearchSinkConnectorConfig(props)
        } catch (e: ConfigException) {
            throw ConnectException(e.message, e)
        }

        this.esClient = RestHighLevelClient(
            RestClient.builder(
                HttpHost(
                    this.config.getString(ElasticSearchSinkConnectorConfig.ES_CLUSTER_HOST),
                    this.config.getInt(ElasticSearchSinkConnectorConfig.ES_CLUSTER_PORT),
                )
            )
        )
    }

    override fun put(records: MutableCollection<SinkRecord>) {
        if (records.isEmpty()) return

        val bulkRequest = BulkRequest()
        for (record in records) {
            val map = gson.fromJson(record.value().toString(), Map::class.java)
            bulkRequest.add(
                IndexRequest(this.config.getString(ElasticSearchSinkConnectorConfig.ES_INDEX))
                    .source(map, XContentType.JSON)
            )
        }

        esClient.bulkAsync(
            bulkRequest,
            RequestOptions.DEFAULT,
            object: ActionListener<BulkResponse> {

                override fun onResponse(response: BulkResponse) {
                    if (response.hasFailures()) {
                        logger.error(response.buildFailureMessage())
                    } else {
                        logger.info("saved")
                    }
                }

                override fun onFailure(e: Exception) {
                    logger.error(e.message, e)
                }

            }
        )
    }

    override fun stop() {
        try {
            esClient.close()
        } catch (e: IOException) {
            logger.error(e.message, e)
        }
    }
}