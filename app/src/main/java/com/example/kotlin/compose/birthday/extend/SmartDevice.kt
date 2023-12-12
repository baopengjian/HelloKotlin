package com.example.kotlin.compose.birthday.extend

/**
 *  Crate by bao on 2023/12/9
 */
open class SmartDevice(val name: String, val category: String) {

    companion object{

        const val  ON = "on"

        const val  OFF = "on"
    }


    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = ON
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

}