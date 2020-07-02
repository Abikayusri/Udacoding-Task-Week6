package abika.sinau.mahasiswaappabika.ui.menu

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.helper.SessionManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initToolbar()
        initSession()
    }

    private fun initToolbar() {
        tbProfile.setNavigationOnClickListener {
            onBackPressed()
        }
        tbProfile.title = "Pofile"
    }

    private fun initSession() {
        val session = SessionManager(this)

        tvProfileNama.text = session.nama
        tvProfileEmail.text = session.email
    }
}