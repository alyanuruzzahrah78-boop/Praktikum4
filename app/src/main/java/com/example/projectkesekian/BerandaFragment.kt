package com.example.projectkesekian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class BerandaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)
        
        val btnMulaiBeranda = view.findViewById<Button>(R.id.btnMulaiBeranda)

        btnMulaiBeranda.setOnClickListener {
            (activity as Latihan3).bukaLatihan4()
        }
        
        return view
    }
}
