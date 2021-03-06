package soli.rxpermissions

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.soli.permissions.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val rxPermissions by lazy { RxPermissions(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRxpermissions.setOnClickListener { requestPermissions() }
    }


    private fun requestPermissions() {
        rxPermissions.request(
                Manifest.permission.CAMERA,
                Manifest.permission.SYSTEM_ALERT_WINDOW,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.BODY_SENSORS,
                Manifest.permission.WRITE_CALENDAR,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.SEND_SMS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.WRITE_SETTINGS)
                .subscribe { pass ->
                    Toast.makeText(this@MainActivity, if (pass) "所有申请成功" else "没有都通过", Toast.LENGTH_LONG).show()
                }

    }


}
