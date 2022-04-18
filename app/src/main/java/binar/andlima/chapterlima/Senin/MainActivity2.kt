package binar.andlima.chapterlima.Senin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.andlima.chapterlima.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        withoutVm.setOnClickListener {
            startActivity(Intent(this, WihoutVm::class.java))
        }
        usingVm.setOnClickListener {
            startActivity(Intent(this, UsingVm::class.java))
        }
        VmLd.setOnClickListener {
            startActivity(Intent(this, VmLiveData::class.java))

        }
    }
}