class ForzaDataFilterApplication

fun main() {
    val kafkaFilter = KafkaFilter()

    printStartLog()
    kafkaFilter.start()
}

fun printStartLog() {
    println("""
        ===============================
        Forza 데이터 필터를 시작합니다
        ===============================
    """.trimIndent())
}