import com.google.gson.Gson
import org.apache.kafka.clients.producer.*
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class KafkaSender {

    private val kafkaProducer: KafkaProducer<String, String>
    private val gson = Gson()

    init {
        val config = Properties()
        config[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = Configuration.KafkaSender.BOOTSTRAP_SERVERS
        config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name

        kafkaProducer = KafkaProducer(config)
    }

    fun send(data: ForzaData) {
        val message = gson.toJson(data)
        val record = ProducerRecord<String, String>(Configuration.KafkaSender.TOPIC_NAME, message)

        kafkaProducer.send(record) { metadata, exception ->
            run {
                if (exception != null) {
                    println("Error: ${exception.message}")
                }
            }
        }
    }
}