import com.google.gson.Gson
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import java.util.*

class KafkaFilter {

    private val gson = Gson()

    fun start() {
        val streams = KafkaStreams(buildStream().build(), makeProperties())
        streams.start()
    }

    private fun buildStream() : StreamsBuilder {
        val streamsBuilder = StreamsBuilder()
        val streamForzaData = streamsBuilder.stream<String, String>(KafkaFilterConfig.STREAM_SOURCE_TOPIC)
        val streamRacingForzaData = streamForzaData.filter { key, value ->
            gson.fromJson(value, ForzaData::class.java).onTrackRacing()
        }
        streamRacingForzaData.to(KafkaFilterConfig.STREAM_FILTER_TOPIC)

        return streamsBuilder
    }

    private fun makeProperties() : Properties {
        val properties = Properties()
        properties[StreamsConfig.APPLICATION_ID_CONFIG] = KafkaFilterConfig.APPLICATION_NAME
        properties[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = KafkaFilterConfig.BOOTSTRAP_SERVERS
        properties[StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG] = Serdes.String()::class.java
        properties[StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG] = Serdes.String()::class.java

        return properties
    }
}