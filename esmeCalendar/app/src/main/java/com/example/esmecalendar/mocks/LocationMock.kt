package com.example.esmecalendar.mocks

import android.net.wifi.WifiInfo
import com.example.esmecalendar.interfaces.ILocalisation
import java.util.*

class LocationMock : ILocalisation {
    override fun getWifiList(): ArrayList<WifiInfo>? {
        return null //TODO wifimanager
    }

    override fun getPositionFromWifiList(wifiList: ArrayList<WifiInfo>?) : String {
        return convertisseur(null)
    }


    fun convertisseur(wifi : WifiInfo?) : String {

        if( Random().nextBoolean()){ //wifi.macAddress == "mymc" && wifi?.rssi > 0 && wifi.rssi < 200){
            return "M17"
        } else {
            return "M15"
        }
    }
}