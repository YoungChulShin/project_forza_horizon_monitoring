import java.net.DatagramPacket
import java.net.DatagramSocket

class ForzaDataCollectApplication

fun main() {
    val dataSocket = DatagramSocket(Configuration.UDPReceiver.PORT)
    val kafkaSender = KafkaSender()

    printStartLog()
    while (true) {
        val data = ByteArray(Configuration.UDPReceiver.DATA_SIZE)
        val packet = DatagramPacket(data, 0, data.size)
        dataSocket.receive(packet)

        ForzaDataFactory.create(packet.data)?.let {
            kafkaSender.send(it)
        }
    }
}

fun printStartLog() {
    println("""
        ===============================
        Forza 데이터 전송을 시작합니다
        ===============================
    """.trimIndent())
}