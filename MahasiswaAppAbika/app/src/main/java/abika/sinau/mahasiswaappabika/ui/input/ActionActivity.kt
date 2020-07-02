package abika.sinau.mahasiswaappabika.ui.input

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.model.mahasiswa.DataItemMahasiswa
import abika.sinau.mahasiswaappabika.ui.register.RegisterViewModel
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.reactivex.rxjava3.internal.operators.observable.ObservableError
import kotlinx.android.synthetic.main.activity_action.*

class ActionActivity : AppCompatActivity() {

    var nim: String? = null
    var nama: String? = null
    var nohp: String? = null
    var jurusan: String? = null
    var semester: String? = null
    var alamat: String? = null

    lateinit var viewModel: ActionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        initToolbar()
        attachObserve()

        val getData = intent.getParcelableExtra<DataItemMahasiswa>("Data")

        if (getData != null) {
            etNIM.setText(getData.mahasiswaNim)
            etNama.setText(getData.mahasiswaNama)
            etNoHp.setText(getData.mahasiswaNohp)
            etJurusan.setText(getData.mahasiswaJurusan)
            etSemester.setText(getData.mahasiswaSemester)
            etAlamat.setText(getData.mahasiswaAlamat)

            btnSave.text = "Update"
            btnSave.setBackgroundResource(R.drawable.bg_button_update)

            tbInput.title = "Update Data"
        }

        btnSave.setOnClickListener {
            nim = etNIM.text.toString()
            nama = etNama.text.toString()
            nohp = etNoHp.text.toString()
            jurusan = etJurusan.text.toString()
            semester = etSemester.text.toString()
            alamat = etAlamat.text.toString()

            when (btnSave.text) {
                "Update" -> {
                    viewModel.getUpdateDataMhs(
                        getData?.idMahasiswa,
                        nim ?: "",
                        nama ?: "",
                        nohp ?: "",
                        jurusan ?: "",
                        semester ?: "",
                        alamat ?: ""
                    )
                }
                else -> {
                    viewModel.getAddDataMhs(
                        nim ?: "",
                        nama ?: "",
                        nohp ?: "",
                        jurusan ?: "",
                        semester ?: "",
                        alamat ?: ""
                    )
                }
            }
        }

        btnBatal.setOnClickListener {
            finish()
        }
    }

    private fun attachObserve() {
        viewModel.isError.observe(this, Observer {
            showError(it)
        })

        viewModel.isLoading.observe(this, Observer {
            showLoading(it)
        })

        viewModel.isSuccess.observe(this, Observer {
            showSuccess(it)
        })
    }

    private fun showSuccess(it: Boolean?) {
        if (it == true) {
            finish()
        }
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            pbAction.visibility = View.VISIBLE
        } else {
            pbAction.visibility = View.GONE
        }
    }

    private fun showError(it: String?) {
        Toast.makeText(this@ActionActivity, it, Toast.LENGTH_SHORT).show()
    }

    private fun initToolbar() {
        viewModel = ViewModelProviders.of(this).get(ActionViewModel::class.java)
        tbInput.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}