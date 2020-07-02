package abika.sinau.mahasiswaappabika.ui.login

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.helper.SessionManager
import abika.sinau.mahasiswaappabika.model.user.DataItemUser
import abika.sinau.mahasiswaappabika.model.user.ResponseUserLogin
import abika.sinau.mahasiswaappabika.ui.main.MainActivity
import abika.sinau.mahasiswaappabika.ui.register.RegisterActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        attachObserve()

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            viewModel.getLoginData(email, password)
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }

    private fun attachObserve() {
        viewModel.isError.observe(this, Observer {
            showError(it)
        })

        viewModel.isEmpty.observe(this, Observer {
            showEmpty(it)
        })

        viewModel.isSuccess.observe(this, Observer {
            showSuccess(it)
        })

        viewModel.isLoading.observe(this, Observer {
            showLoading(it)
        })

        viewModel.rLoginUser.observe(this, Observer {
            showSession(it)
        })
    }

    private fun showSession(it: ResponseUserLogin) {
        val session = SessionManager(this)
        session.email = it.data?.get(0)?.userEmail
        session.nama = it.data?.get(0)?.userNama
        session.isLogin = true
    }

    private fun showError(it: String?) {
        showToast(it)
    }

    private fun showEmpty(it: String?) {
        showToast(it)
    }

    private fun showSuccess(it: Boolean) {
        if (it == true) {
            showToast("Login berhasil")
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finishAffinity()
        }
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            pbLogin.visibility = View.VISIBLE
        } else {
            pbLogin.visibility = View.GONE
        }
    }

    private fun showToast(it: String?) {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}