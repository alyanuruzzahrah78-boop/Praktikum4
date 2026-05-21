package com.example.projectkesekian

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// Titik dua (:) untuk inheritance harus ada di tingkat class
class MataKuliahAdapter(private val daftarMataKuliah: List<MataKuliah>) :
    RecyclerView.Adapter<MataKuliahAdapter.MataKuliahViewHolder>() {

    // Anda perlu mengimplementasikan method wajib (onCreateViewHolder, onBindViewHolder, getItemCount)
    // Dan mendefinisikan ViewHolder-nya
    class MataKuliahViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvKodeMK: TextView = view.findViewById(R.id.tvKodeMK)
        val tvSksMK: TextView = view.findViewById(R.id.tvSksMK)
        val tvNamaMK: TextView = view.findViewById(R.id.tvNamaMK)
        val tvDosenMK: TextView = view.findViewById(R.id.tvDosenMK)
        val tvJadwalMK: TextView = view.findViewById(R.id.tvJadwalMK)
        val tvRuanganMK: TextView = view.findViewById(R.id.tvRuanganMK)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MataKuliahViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_matakuliah, parent, false)
            return MataKuliahViewHolder(view)
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MataKuliahViewHolder, position: Int) {
        val item = daftarMataKuliah[position]

        holder.tvKodeMK.text = item.id_matakuliah
        holder.tvSksMK.text = "${item.sks_matakuliah} SKS"
        holder.tvNamaMK.text = item.nama_matakuliah
        holder.tvDosenMK.text = "Dosen: ${item.nama_dosen_matakuliah}"
        holder.tvJadwalMK.text = "Jadwal: ${item.jadwal_matakuliah}"
        holder.tvRuanganMK.text = "Ruangan: ${item.ruangan_matakuliah}"

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Matakuliah dipilih: ${item.nama_matakuliah}",
                Toast.LENGTH_SHORT).show()
        }

        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = daftarMataKuliah.size
}