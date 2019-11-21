package com.example.esmecalendar.interfaces

import android.net.wifi.WifiInfo

interface ILocalisation {

    fun getWifiList() : ArrayList<WifiInfo>?
    fun getPositionFromWifiList(wifiList : ArrayList<WifiInfo>?) : String?

}