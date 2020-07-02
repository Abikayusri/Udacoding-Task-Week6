package abika.sinau.mahasiswaappabika.adapter

import abika.sinau.mahasiswaappabika.R
import abika.sinau.mahasiswaappabika.model.mahasiswa.DataItemMahasiswa
import abika.sinau.mahasiswaappabika.ui.action.ActionActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 18 June 2020
 * Bismillahirrahmanirrahim
 */
class MahasiswaAdapter(val data: List<DataItemMahasiswa?>?, val itemClick: OnClickListener) :
    RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MahasiswaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val context = holder.itemView.context
        val item = data?.get(position)

        holder.nim.text = item?.mahasiswaNim
        holder.nama.text = item?.mahasiswaNama
        holder.jurusan.text = item?.mahasiswaJurusan

        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                "Anda menekan ${data?.get(position)?.mahasiswaNama}",
                Toast.LENGTH_SHORT
            ).show()

            val detail = Intent(context, ActionActivity::class.java)
            detail.putExtra("Data", item)
            context.startActivity(detail)
        }

        holder.hapus.setOnClickListener {
            itemClick.hapus(item)
        }
    }

    class MahasiswaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nim = view.tvItemNIM
        val nama = view.tvItemNama
        val jurusan = view.tvItemJurusan
        val hapus = view.btnHapus
    }

    interface OnClickListener{
        fun hapus(item: DataItemMahasiswa?)
    }
}
