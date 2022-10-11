package project.forzadata.monitoring

import org.apache.kafka.common.config.ConfigDef
import org.apache.kafka.common.config.ConfigException
import org.apache.kafka.connect.connector.Task
import org.apache.kafka.connect.sink.SinkConnector

class ElasticSearchSinkConnector : SinkConnector() {

    private lateinit var configProperties: MutableMap<String, String>

    override fun version(): String {
        return "1.0"
    }

    // 사용자가 입력한 설정값이 들어온다
    override fun start(props: MutableMap<String, String>) {
        this.configProperties = props
        try {
            // 입력 값을 기준으로 config를 생성
            ElasticSearchSinkConnectorConfig(props)
        } catch (e: ConfigException) {
            throw ConfigException(e.message, e)
        }
    }

    override fun taskClass(): Class<out Task> {
        return ElasticSearchSinkTask::class.java
    }

    override fun taskConfigs(maxTasks: Int): MutableList<Map<String, String>> {
        val taskConfigs: MutableList<Map<String, String>> = mutableListOf()
        val taskProps: MutableMap<String, String> = mutableMapOf()
        taskProps.putAll(this.configProperties)

        for (i in 0 until maxTasks) {
            taskConfigs.add(taskProps)
        }

        return taskConfigs
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun config(): ConfigDef {
        return ElasticSearchSinkConnectorConfig.CONFIG
    }
}