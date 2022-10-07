import java.lang.IllegalArgumentException
import java.nio.ByteBuffer
import java.nio.ByteOrder

object ForzaDataFactory {

    const val PACKET_SIZE = 327

    fun create(data: ByteArray): ForzaData? {
        val buffer = ByteBuffer.wrap(data)
        buffer.order(ByteOrder.LITTLE_ENDIAN)

        try {
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, UInt::class.java))

            println("===========Engine RPM")

            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))

            println("===========Acceleration")

            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))

            println("===========Velocity")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))

            println("===========VelocityAngular")

            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))

            println("===========YawPitchRoll")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))

            println("===========NormalizedSuspension")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))

            println("===========TireSlipRatio")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))

            println("===========Wheel")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println("===========Surface")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println("===========Tire")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println("===========Suspension")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println("===========Car")
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println(getFromBuffer(buffer, Int::class.java))
            println("===========Position")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println("===========Speed")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println("===========Tire Temp")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))

            println("===========Lap")
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))
            println(getFromBuffer(buffer, Float::class.java))

            println("===========Last")
            println(getFromBuffer(buffer, Short::class.java))
            println(getFromBuffer(buffer, Byte::class.java))
            println(getFromBuffer(buffer, Byte::class.java))
            println(getFromBuffer(buffer, Byte::class.java))
            println(getFromBuffer(buffer, Byte::class.java))
            println(getFromBuffer(buffer, Byte::class.java))
            println(getFromBuffer(buffer, Byte::class.java))
            println(getFromBuffer(buffer, Byte::class.java))
            println(getFromBuffer(buffer, Byte::class.java))
            println(getFromBuffer(buffer, Byte::class.java))



        } catch (ex: Exception) {
            println(ex.message)
        }

        return null
    }

    fun <T> getFromBuffer(buffer: ByteBuffer, clazz: Class<T>): T {
        return when(clazz) {
            UInt::class.java -> (if (checkBufferSize(buffer, 4)) buffer.int.toUInt() else 0L) as T
            Float::class.java -> (if (checkBufferSize(buffer, 4)) buffer.float else 0f) as T
            Int::class.java -> (if (checkBufferSize(buffer, 4)) buffer.int else 0) as T
            Short::class.java -> (if (checkBufferSize(buffer, 2)) buffer.short else 0) as T
            Byte::class.java -> (if (checkBufferSize(buffer, 1)) buffer.get() else 0) as T
            else -> throw IllegalArgumentException("정의되지 않은 데이터 타입입니다. ${clazz.name}")
        }
    }

    private fun checkBufferSize(buffer: ByteBuffer, size: Int) =
        buffer.hasRemaining() && buffer.remaining() >= size
}