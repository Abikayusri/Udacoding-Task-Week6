package abika.sinau.mahasiswaappabika.ui.main

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.adapter.MahasiswaAdapter
import abika.sinau.mahasiswaappabika.helper.SessionManager
import abika.sinau.mahasiswaappabika.model.mahasiswa.DataItemMahasiswa
import abika.sinau.mahasiswaappabika.model.mahasiswa.ResponseMahasiswaData
import abika.sinau.mahasiswaappabika.ui.action.ActionActivity
import abika.sinau.mahasiswaappabika.ui.login.LoginActivity
import abika.sinau.mahasiswaappabika.ui.menu.ProfileActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var session: SessionManager
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        session = SessionManager(this)
        tvMainUser.text = session.nama ?: "Datanya"

        initToolbar()
        initViewModel()
        attachObserve()

        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, ActionActivity::class.java))
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getListDataMhs()
    }

    private fun initToolbar() {
        session = SessionManager(this)
        tvMainUser.text = session.nama ?: "Datanya"

        val toolbar: Toolbar = findViewById<View>(R.id.tbMain) as Toolbar
        setSupportActionBar(toolbar)
        title = "Home"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.actionProfile -> {
                startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
                true
            }
            R.id.actionLogout -> {
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                showToast("Logout sukses")
                finish()
                true
            }
            else -> true
        }
    }

    private fun attachObserve() {
        viewModel.rDataMhs.observe(this, Observer {
            showData(it)
        })

        viewModel.isError.observe(this, Observer {
            showError(it)
        })

        viewModel.isLoading.observe(this, Observer {
            showLoading(it)
        })

        viewModel.isStatus.observe(this, Observer {
            showToast(it)
        })
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            pbMain.visibility = View.VISIBLE
        } else {
            pbMain.visibility = View.GONE
        }
    }

    private fun showError(it: String) {
        showToast(it)
    }

    private fun showData(it: ResponseMahasiswaData?) {
        val adapter = MahasiswaAdapter(it?.data, object : MahasiswaAdapter.OnClickListener {
            override fun hapus(item: DataItemMahasiswa?) {
                AlertDialog.Builder(this@MainActivity).apply {
                    setTitle("Hapus Data")
                    setMessage("Yakin menghapus data?")
                    setPositiveButton("Hapus") { dialog, which ->
                        showHapusData(item?.idMahasiswa)
                        dialog.dismiss()
                        viewModel.getListDataMhs()
                    }
                    setNegativeButton("Cancel") { dialog, which ->
                        dialog.dismiss()
                    }
                }.show()
            }
        })
        rvMain.adapter = adapter
    }

    private fun showHapusData(id: String?) {
        viewModel.getHapusDataMhs(id ?: "")
    }

    private fun showToast(it: String?) {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getListDataMhs()
    }
}