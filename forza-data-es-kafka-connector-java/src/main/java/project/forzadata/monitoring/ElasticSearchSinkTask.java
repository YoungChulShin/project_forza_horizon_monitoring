package project.forzadata.monitoring;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ElasticSearchSinkTask extends SinkTask {

  private ElasticSearchSinkConnectorConfig config;
  private RestHighLevelClient esClient;
  private Gson gson = new Gson();

  @Override
  public String version() {
    return "1.0";
  }

  @Override
  public void start(Map<String, String> props) {
    try {
      this.config = new ElasticSearchSinkConnectorConfig(props);
    } catch (ConfigException e) {
      throw new ConnectException(e.getMessage(), e);
    }

    this.esClient = new RestHighLevelClient(
        RestClient.builder(
            new HttpHost(
                this.config.getString(ElasticSearchSinkConnectorConfig.ES_CLUSTER_HOST),
                this.config.getInt(ElasticSearchSinkConnectorConfig.ES_CLUSTER_PORT))));
  }

  @Override
  public void put(Collection<SinkRecord> records) {
    if (records.isEmpty()) {
      return;
    }

    BulkRequest bulkRequest = new BulkRequest();
    for (SinkRecord record : records) {
      Map<String, String> map = gson.fromJson(record.value().toString(), Map.class);
      bulkRequest.add(
          new IndexRequest(this.config.getString(ElasticSearchSinkConnectorConfig.ES_INDEX))
              .source(map, XContentType.JSON));
    }

    esClient.bulkAsync(
        bulkRequest,
        RequestOptions.DEFAULT,
        new ActionListener<BulkResponse>() {
          @Override
          public void onResponse(BulkResponse bulkItemResponses) {
            System.out.println("ok");
          }

          @Override
          public void onFailure(Exception e) {
            System.out.println("error");
          }
        }
    );
  }

  @Override
  public void stop() {
    try {
      esClient.close();
    } catch (IOException ignored) {

    }
  }
}
