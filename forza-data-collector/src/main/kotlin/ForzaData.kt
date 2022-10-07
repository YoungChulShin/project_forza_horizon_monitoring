import kotlin.math.roundToInt

/**
 * Data Size: 337 byte
 */
data class ForzaData(
    val raceOn: Int,
    val timeStampMs: Long,

    val engineMaxRpm: Float,
    val engineIdleRpm: Float,
    val currentEngineRpm: Float,

    val accelerationX: Float,
    val accelerationY: Float,
    val accelerationZ: Float,

    val velocityX: Float,
    val velocityY: Float,
    val velocityZ: Float,

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

    // Unique ID of the car make/model
    val carOrdinal: Int,
    // Between 0 (D -- worst cars) and 7 (X class -- best cars) inclusive
    val carClass: Int,
    // Between 100 (slowest car) and 999 (fastest car) inclusive
    val carPerformanceIndex: Int,
    // 0 = FWD, 1 = RWD, 2 = AWD
    val drivetrainType: Int,
    val numCylinders: Int,
    val horizonPlaceholder1: Int,
    val horizonPlaceholder2: Long,
    val horizonPlaceholder3: Long,

    val positionX: Float,
    val positionY: Float,
    val positionZ: Float,

    val speedMPS: Float,
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

    val lapNumber: Int,
    val racePosition: Short,
    val accel: Short,
    val brake: Short,
    val clutch: Short,
    val handBrake: Short,
    val gear: Short,
    val steer: Byte,
    val normalizedDrivingLine: Byte,
    val normalizedAIBrakeDifference: Byte,
) {
    // https://en.wikipedia.org/wiki/Kilometres_per_hour
    val speedKPH: Int = (speedMPS * 3.6f).roundToInt()
    val speedMPH: Int = (speedMPS * 2.236936f).roundToInt()
    val powerHP: Float = (power * 0.00134102f)

    val carType: String = when(drivetrainType) {
        0 -> "FWD"
        1 -> "RWD"
        2 -> "AWD"
        else -> "UNKOWN"
    }

    fun printCoreData() {
        println("raceOn: ${raceOn}, carType: ${carType}, engineRPM: ${currentEngineRpm}, idleRPM: ${engineIdleRpm}, speed: ${speedKPH}, power: ${powerHP}, accel: ${accel}, brake: ${brake}, handbrake: ${handBrake}, lapNubmer: ${lapNumber}, position: ${racePosition}, bestlap: ${bestLap} ")
    }
}