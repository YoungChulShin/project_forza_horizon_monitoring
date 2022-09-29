import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Data Size: 337 byte
 */
data class ForzaData(
    val raceOn: UInt,
    val timeStampMs: UInt,
    val engineMaxRpm: Float,
    val engineIdleRpm: Float,
    val currentEngineRpm: Float,
    val accelerationX: Float,
    val accelerationY: Float,
    val accelerationZ: Float,
    val velocityX: Float,
    val velocityY: Float,
    val angularVelocityX: Float,
    val angularVelocityY: Float,
    val angularVelocityZ: Float,
    val yaw: Float,
    val pitch: Float,
    val roll: Float,
    val normalizedSuspensionTravelFrontLeft: Float,
    val normalizedSuspensionTravelFrontRight: Float,
    val normalizedSuspensionTravelRearLeft: Float,
    val normalizedSuspensionTravelRearRight: Float,
    val tireSlipRatioFrontLeft: Float,
    val tireSlipRatioFrontRight: Float,
    val tireSlipRatioRearLeft: Float,
    val tireSlipRatioRearRight: Float,
    val wheelRotationSpeedFrontLeft: Float,
    val wheelRotationSpeedFrontRight: Float,
    val wheelRotationSpeedRearLeft: Float,
    val wheelRotationSpeedRearRight: Float,
    val wheelOnRumbleStripFrontLeft: Int,
    val wheelOnRumbleStripFrontRight: Int,
    val wheelOnRumbleStripRearLeft: Int,
    val wheelOnRumbleStripRearRight: Int,
    val wheelInPuddleDepthFrontLeft: Float,
    val wheelInPuddleDepthFrontRight: Float,
    val wheelInPuddleDepthRearLeft: Float,
    val wheelInPuddleDepthRearRight: Float,
    val surfaceRumbleFrontLeft: Float,
    val surfaceRumbleFrontRight: Float,
    val surfaceRumbleRearLeft: Float,
    val surfaceRumbleRearRight: Float,
    val tireSlipAngleFrontLeft: Float,
    val tireSlipAngleFrontRight: Float,
    val tireSlipAngleRearLeft: Float,
    val tireSlipAngleRearRight: Float,
    val tireCombinedSlipFrontLeft: Float,
    val tireCombinedSlipFrontRight: Float,
    val tireCombinedSlipRearLeft: Float,
    val tireCombinedSlipRearRight: Float,
    val suspensionTravelMetersFrontLeft: Float,
    val suspensionTravelMetersFrontRight: Float,
    val suspensionTravelMetersRearLeft: Float,
    val suspensionTravelMetersRearRight: Float,
    val carOrdinal: Int,
    val carClass: Int,
    val carPerformanceIndex: Int,
    val drivetrainType: Int,
    val numCylinders: Int,
    val horizonPlaceholder1: Int,
    val horizonPlaceholder2: UInt,
    val horizonPlaceholder3: UInt,
    val positionX: Float,
    val positionY: Float,
    val positionZ: Float,
    val speed: Float,
    val power: Float,
    val torque: Float,
    val tireTempFrontLeft: Float,
    val tireTempFrontRight: Float,
    val tireTempRearLeft: Float,
    val tireTempRearRight: Float,
    val boost: Float,
    val fuel: Float,
    val distanceTraveled: Float,
    val bestLap: Float,
    val lastLap: Float,
    val currentLap: Float,
    val currentRaceTime: Float,
    val lapNumber: UShort,
    val racePosition: UByte,
    val accel: UByte,
    val brake: UByte,
    val clutch: UByte,
    val handBrake: UByte,
    val gear: UByte,
    val steer: Byte,
    val normalizedDrivingLine: Byte,
    val normalizedAIBrakeDifference: Byte,
) {
    companion object {
        const val PACKET_SIZE = 323

//        fun from(data: ByteArray) : ForzaData {
//
//            val byteBuffer = ByteBuffer.wrap(data)
//            byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
//
//            try {
//
//            } catch (ex: Exception) {
//
//            }
//
//
//        }



    }
}