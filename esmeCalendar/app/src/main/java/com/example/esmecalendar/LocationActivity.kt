package com.example.esmecalendar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.esmecalendar.interfaces.ILocalisation
import com.example.esmecalendar.mocks.LocationMock3
import kotlinx.android.synthetic.main.activity_location.*

class LocationActivity : AppCompatActivity() {

    var locationIterface: ILocalisation = LocationMock3()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        startLocalisation()
    }


    fun startLocalisation() {

        Thread {

            var classroom: String? = ""

            while (true) {
                classroom = locationIterface
                    .getPositionFromWifiList(locationIterface.getWifiList())

                Thread.sleep(1000)

                runOnUiThread {
                    textView.text = classroom
                }

            }


        }.start()


    }


}
