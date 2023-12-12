package com.example.kotlin.compose.birthday.extend

/**
 *  Crate by bao on 2023/12/9
 */
class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv(){
        if(smartTvDevice.deviceStatus == SmartDevice.ON){
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }

    }

    fun turnOffTv(): ()->Unit {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
        return ::increaseTvVolume
    }

    fun increaseTvVolume(){
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext(){
        smartTvDevice.nextChannel()
    }

    fun tunOnLight(){
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight(){
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices(){
        turnOffTv()
        turnOffLight()
    }
}
