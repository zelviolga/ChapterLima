package binar.andlima.chapterlima.Senin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.andlima.chapterlima.R
import kotlinx.android.synthetic.main.activity_wihout_vm.*

class WihoutVm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wihout_vm)

        var angka = 0

        btnPlus.setOnClickListener {
            angka++
            tvNumber.text = angka.toString()
        }
        btnMinus.setOnClickListener {
            angka--
            tvNumber.text = angka.toString()
        }

    }
}