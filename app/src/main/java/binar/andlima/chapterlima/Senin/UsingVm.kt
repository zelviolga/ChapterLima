package binar.andlima.chapterlima.Senin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import binar.andlima.chapterlima.R
import binar.andlima.chapterlima.Senin.viewmodel.ViewModelSatu
import kotlinx.android.synthetic.main.activity_using_vm.*

class UsingVm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_using_vm)


        val viewModel = ViewModelProvider(this).get(ViewModelSatu::class.java)

        tvNumberr.text = viewModel.angka.toString()

        btnPluss.setOnClickListener {
            ++viewModel.angka
            tvNumberr.text = viewModel.angka.toString()
        }

        btnMinuss.setOnClickListener {
            --viewModel.angka
            tvNumberr.text = viewModel.angka.toString()
        }


    }
}