import com.google.gson.Gson
import java.net.DatagramPacket
import java.net.DatagramSocket

class ForzaDataCollectApplication {


}

fun main() {
    println("Started")


    val dataSocket = DatagramSocket(6666)
    val gson = Gson()
    while (true) {
        val data = ByteArray(337)
        val packet = DatagramPacket(data, 0, data.size)

        dataSocket.receive(packet)

        println(gson.toJson(packet.data))
    }
}