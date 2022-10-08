
class Configuration {

    object UDPReceiver {

        const val PORT = 6666
        const val DATA_SIZE = 337
    }

    object KafkaSender {

        const val BOOTSTRAP_SERVERS = "localhost:19092,localhost:29092,localhost:39092"
        const val TOPIC_NAME = "forzadata"
    }
}