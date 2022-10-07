import java.lang.IllegalArgumentException
import java.nio.ByteBuffer
import java.nio.ByteOrder

object ForzaDataFactory {

    fun create(data: ByteArray): ForzaData? {
        val buffer = ByteBuffer.wrap(data)
        buffer.order(ByteOrder.LITTLE_ENDIAN)

        try {
            return ForzaData(
                raceOn = getFromBuffer(buffer, Int::class.java),
                timeStampMs = getFromBuffer(buffer, UInt::class.java).toLong(),

                engineMaxRpm = getFromBuffer(buffer, Float::class.java),
                engineIdleRpm = getFromBuffer(buffer, Float::class.java),
                currentEngineRpm = getFromBuffer(buffer, Float::class.java),

                accelerationX = getFromBuffer(buffer, Float::class.java),
                accelerationY = getFromBuffer(buffer, Float::class.java),
                accelerationZ = getFromBuffer(buffer, Float::class.java),

                velocityX = getFromBuffer(buffer, Float::class.java),
                velocityY = getFromBuffer(buffer, Float::class.java),
                velocityZ = getFromBuffer(buffer, Float::class.java),

                angularVelocityX = getFromBuffer(buffer, Float::class.java),
                angularVelocityY = getFromBuffer(buffer, Float::class.java),
                angularVelocityZ = getFromBuffer(buffer, Float::class.java),

                yaw = getFromBuffer(buffer, Float::class.java),
                pitch = getFromBuffer(buffer, Float::class.java),
                roll = getFromBuffer(buffer, Float::class.java),

                normalizedSuspensionTravelFrontLeft = getFromBuffer(buffer, Float::class.java),
                normalizedSuspensionTravelFrontRight = getFromBuffer(buffer, Float::class.java),
                normalizedSuspensionTravelRearLeft = getFromBuffer(buffer, Float::class.java),
                normalizedSuspensionTravelRearRight = getFromBuffer(buffer, Float::class.java),

                tireSlipRatioFrontLeft = getFromBuffer(buffer, Float::class.java),
                tireSlipRatioFrontRight = getFromBuffer(buffer, Float::class.java),
                tireSlipRatioRearLeft = getFromBuffer(buffer, Float::class.java),
                tireSlipRatioRearRight = getFromBuffer(buffer, Float::class.java),

                wheelRotationSpeedFrontLeft = getFromBuffer(buffer, Float::class.java),
                wheelRotationSpeedFrontRight = getFromBuffer(buffer, Float::class.java),
                wheelRotationSpeedRearLeft = getFromBuffer(buffer, Float::class.java),
                wheelRotationSpeedRearRight = getFromBuffer(buffer, Float::class.java),
                wheelOnRumbleStripFrontLeft = getFromBuffer(buffer, Int::class.java),
                wheelOnRumbleStripFrontRight = getFromBuffer(buffer, Int::class.java),
                wheelOnRumbleStripRearLeft = getFromBuffer(buffer, Int::class.java),
                wheelOnRumbleStripRearRight = getFromBuffer(buffer, Int::class.java),
                wheelInPuddleDepthFrontLeft = getFromBuffer(buffer, Float::class.java),
                wheelInPuddleDepthFrontRight = getFromBuffer(buffer, Float::class.java),
                wheelInPuddleDepthRearLeft = getFromBuffer(buffer, Float::class.java),
                wheelInPuddleDepthRearRight = getFromBuffer(buffer, Float::class.java),

                surfaceRumbleFrontLeft = getFromBuffer(buffer, Float::class.java),
                surfaceRumbleFrontRight = getFromBuffer(buffer, Float::class.java),
                surfaceRumbleRearLeft = getFromBuffer(buffer, Float::class.java),
                surfaceRumbleRearRight = getFromBuffer(buffer, Float::class.java),

                tireSlipAngleFrontLeft = getFromBuffer(buffer, Float::class.java),
                tireSlipAngleFrontRight = getFromBuffer(buffer, Float::class.java),
                tireSlipAngleRearLeft = getFromBuffer(buffer, Float::class.java),
                tireSlipAngleRearRight = getFromBuffer(buffer, Float::class.java),
                tireCombinedSlipFrontLeft = getFromBuffer(buffer, Float::class.java),
                tireCombinedSlipFrontRight = getFromBuffer(buffer, Float::class.java),
                tireCombinedSlipRearLeft = getFromBuffer(buffer, Float::class.java),
                tireCombinedSlipRearRight = getFromBuffer(buffer, Float::class.java),

                suspensionTravelMetersFrontLeft = getFromBuffer(buffer, Float::class.java),
                suspensionTravelMetersFrontRight = getFromBuffer(buffer, Float::class.java),
                suspensionTravelMetersRearLeft = getFromBuffer(buffer, Float::class.java),
                suspensionTravelMetersRearRight = getFromBuffer(buffer, Float::class.java),

                carOrdinal = getFromBuffer(buffer, Int::class.java),
                carClass = getFromBuffer(buffer, Int::class.java),
                carPerformanceIndex = getFromBuffer(buffer, Int::class.java),
                drivetrainType = getFromBuffer(buffer, Int::class.java),
                numCylinders = getFromBuffer(buffer, Int::class.java),
                horizonPlaceholder1 = getFromBuffer(buffer, Int::class.java),
                horizonPlaceholder2 = getFromBuffer(buffer, UInt::class.java).toLong(),
                horizonPlaceholder3 = getFromBuffer(buffer, UInt::class.java).toLong(),

                positionX = getFromBuffer(buffer, Float::class.java),
                positionY = getFromBuffer(buffer, Float::class.java),
                positionZ = getFromBuffer(buffer, Float::class.java),

                // https://en.wikipedia.org/wiki/Kilometres_per_hour
                speedMPS = getFromBuffer(buffer, Float::class.java),
                power = getFromBuffer(buffer, Float::class.java),
                torque = getFromBuffer(buffer, Float::class.java),

                tireTempFrontLeft = getFromBuffer(buffer, Float::class.java),
                tireTempFrontRight = getFromBuffer(buffer, Float::class.java),
                tireTempRearLeft = getFromBuffer(buffer, Float::class.java),
                tireTempRearRight = getFromBuffer(buffer, Float::class.java),

                boost = getFromBuffer(buffer, Float::class.java),
                fuel = getFromBuffer(buffer, Float::class.java),
                distanceTraveled = getFromBuffer(buffer, Float::class.java),
                bestLap = getFromBuffer(buffer, Float::class.java),
                lastLap = getFromBuffer(buffer, Float::class.java),
                currentLap = getFromBuffer(buffer, Float::class.java),
                currentRaceTime = getFromBuffer(buffer, Float::class.java),

                lapNumber = getFromBuffer(buffer, UShort::class.java).toInt(),
                racePosition = getFromBuffer(buffer, UByte::class.java).toShort(),
                accel = getFromBuffer(buffer, UByte::class.java).toShort(),
                brake = getFromBuffer(buffer, UByte::class.java).toShort(),
                clutch = getFromBuffer(buffer, UByte::class.java).toShort(),
                handBrake = getFromBuffer(buffer, UByte::class.java).toShort(),
                gear = getFromBuffer(buffer, UByte::class.java).toShort(),
                steer = getFromBuffer(buffer, Byte::class.java),
                normalizedDrivingLine = getFromBuffer(buffer, Byte::class.java),
                normalizedAIBrakeDifference = getFromBuffer(buffer, Byte::class.java),
            )
        } catch (ex: Exception) {
            println(ex.message)
            return null
        }
    }

    @SuppressWarnings(value = ["unchecked"])
    private fun <T> getFromBuffer(buffer: ByteBuffer, clazz: Class<T>): T {
        return when(clazz) {
            Float::class.java -> (if (checkBufferSize(buffer, 4)) buffer.float else 0f) as T
            UInt::class.java -> (if (checkBufferSize(buffer, 4)) buffer.int.toUInt() else 0L) as T
            Int::class.java -> (if (checkBufferSize(buffer, 4)) buffer.int else 0) as T
            Short::class.java -> (if (checkBufferSize(buffer, 2)) buffer.short else 0) as T
            UShort::class.java -> (if (checkBufferSize(buffer, 2)) buffer.short.toUShort() else 0) as T
            Byte::class.java -> (if (checkBufferSize(buffer, 1)) buffer.get() else 0) as T
            UByte::class.java -> (if (checkBufferSize(buffer, 1)) buffer.get().toUByte() else 0) as T
            else -> throw IllegalArgumentException("정의되지 않은 데이터 타입입니다. ${clazz.name}")
        }
    }

    private fun checkBufferSize(buffer: ByteBuffer, size: Int): Boolean {
        if (buffer.hasRemaining() && buffer.remaining() >= size) {
            return true
        } else {
            println("no data")
            return false
        }
    }
}