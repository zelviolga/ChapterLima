package binar.andlima.chapterlima.Senin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import binar.andlima.chapterlima.R
import binar.andlima.chapterlima.Senin.viewmodel.ViewModelDua
import kotlinx.android.synthetic.main.activity_vm_live_data.*

class VmLiveData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vm_live_data)

        val viewModel = ViewModelProvider(this).get(ViewModelDua::class.java)

        viewModel.addNumber.observe(this, Observer {
            tvNumberrr.text = it.toString()
        })

        viewModel.lessNumber.observe(this, Observer {
            tvNumberrr.text = it.toString()
        })

        btnPlusss.setOnClickListener {
            viewModel.addNumber.observe(this, Observer {
                viewModel.addNumber.value = ++viewModel.angka
                tvNumberrr.text = viewModel.angka.toString()
            })
        }

        btnMinusss.setOnClickListener {
            viewModel.lessNumber.observe(this, Observer {
                viewModel.lessNumber.value = --viewModel.angka
                tvNumberrr.text = viewModel.angka.toString()
            })

        }
    }
}