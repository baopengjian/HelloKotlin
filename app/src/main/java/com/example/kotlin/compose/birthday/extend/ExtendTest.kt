package com.example.kotlin.compose.birthday.extend

/**
 *  Crate by bao on 2023/12/9
 */
class ExtendTest {

    fun test(){
        val smartHome = SmartHome(
            SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
            SmartLightDevice(deviceName = "Google Light", deviceCategory = "Utility")
        )

        smartHome.turnOffTv()
        smartHome.tunOnLight()
        println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
        println()

        smartHome.increaseTvVolume()
        smartHome.changeTvChannelToNext()
        smartHome.increaseLightBrightness()
        println()

        smartHome.turnOffAllDevices()
        println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")
    }
}