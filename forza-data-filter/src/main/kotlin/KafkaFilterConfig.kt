object KafkaFilterConfig {

    const val APPLICATION_NAME: String = "forza-racing-filter"
    const val BOOTSTRAP_SERVERS: String = "localhost:19092;localhost:29092;localhost:39092"
    const val STREAM_SOURCE_TOPIC: String = "forzadata"
    const val STREAM_FILTER_TOPIC: String = "forzadata-racing"
}