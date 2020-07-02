package abika.sinau.mahasiswaappabika.ui.input

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.model.mahasiswa.DataItemMahasiswa
import abika.sinau.mahasiswaappabika.ui.main.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_action.*

class ActionActivity : AppCompatActivity() {

    var nim: String? = null
    var nama: String? = null
    var nohp: String? = null
    var jurusan: String? = null
    var semester: String? = null
    var alamat: String? = null

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        initToolbar()

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
                }
                else -> {
                }
            }
        }

        btnBatal.setOnClickListener {
            finish()
        }
    }

    private fun initToolbar() {
        tbInput.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}