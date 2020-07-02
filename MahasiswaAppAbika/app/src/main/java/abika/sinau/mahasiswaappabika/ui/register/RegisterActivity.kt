package abika.sinau.mahasiswaappabika.ui.register

import abika.sinau.mahasiswaappabika.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        attachObserve()

        btnRegister.setOnClickListener {
            val nama = etRegisName.text.toString()
            val email = etRegisEmail.text.toString()
            val password = etRegisPassword.text.toString()
            val cPassword = etRegisConPassword.text.toString()

            viewModel.getRegistData(nama, email, password, cPassword)
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun attachObserve() {
        viewModel.isEmpty.observe(this, Observer {
            showEmpty(it)
        })

        viewModel.isSuccess.observe(this, Observer {
            showSuccess(it)
        })

        viewModel.isError.observe(this, Observer {
            showError(it)
        })

        viewModel.isLoading.observe(this, Observer {
            showLoading(it)
        })
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            pbRegis.visibility = View.VISIBLE
        } else {
            pbRegis.visibility = View.GONE
        }
    }

    private fun showError(it: String?) {
        showToast(it)
    }

    private fun showEmpty(it: String?) {
        showToast(it)
    }

    private fun showSuccess(it: Boolean) {
        if (it == true){
            showToast("Data berhasil ditambahkan")
            finish()
        }
    }

    private fun showToast(it: String?) {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}