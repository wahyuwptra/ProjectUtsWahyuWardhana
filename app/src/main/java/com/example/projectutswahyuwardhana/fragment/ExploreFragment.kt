package com.example.projectutswahyuwardhana.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectutswahyuwardhana.DetailMovieActivity
import com.example.projectutswahyuwardhana.Movie
import com.example.projectutswahyuwardhana.MovieAdapter
import com.example.projectutswahyuwardhana.R

class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter : MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList : ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            MovieAdapter(it, movieArrayList){
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.mrs,
            R.drawable.inang,
            R.drawable.incatation,
            R.drawable.days,
            R.drawable.big4,
            R.drawable.chupa,
            R.drawable.school,
            R.drawable.western,
            R.drawable.after,
            R.drawable.qorin,


            )

        title = arrayOf(
            "Mrs. Chatterjee vs. Norway",
            "Inang",
            "Incantation",
            "365 Days",
            "The Big 4",
            "Chupa",
            "The School for Good and Evil",
            "All Quiet on the Western Front",
            "After Ever Happy",
            "Qorin",



            )

        descriptions = arrayOf(
            "Sebuah kisah tentang perjuangan seorang ibu imigran asal India melawan sistem hukum pengasuhan di Norwegia untuk memenangkan hak asuh anak-anaknya.",
            "Wulan, seorang kasir supermarket ditinggalkan oleh pacarnya setelah mengetahui soal kehamilannya yang di luar rencana.Wulan yang enggan mengambil jalur aborsi, membuatnya harus bertanggung jawab atas kandungannya sendirian. Kurangnya wawasan yang dimiliki Wulan membuat pencarian solusi dimulai secara online.",
            "Incantation adalah film horor supernatural yang ditemukan di Taiwan tahun 2022 yang disutradarai oleh Kevin Ko, yang juga ikut menulis skenario dengan Chang Che-wei. Film ini dirilis di Taiwan pada 18 Maret 2022, dan menjadi film horor Taiwan terlaris.",
            "365 Days adalah sebuah film drama romansa erotis Polandia tahun 2020 garapan Barbara Białowąs dan Tomasz Mandes. Film tersebut berdasarkan pada novel pertama dari sebuah trilogi yang ditulis oleh Blanka Lipińska.",
            "The Big 4 adalah sebuah film laga komedi Indonesia tahun 2022 yang disutradarai oleh Timo Tjahjanto. Film ini dibintangi oleh Abimana Aryasatya, Putri Marino, Lutesha, Arie Kriting, dan Kristo Immanuel. Film ini tayang secara global di Netflix sejak 15 Desember 2022.",
            "Chupa adalah film fantasi petualangan Amerika Serikat tahun 2023 yang disutradarai oleh Jonás Cuarón, dan dibintangi oleh Demián Bichir dan Christian Slater. Film ini diproduksi oleh 26th Street Pictures, film ini dirilis pada tanggal 7 April 2023, di Netflix",
            "The School for Good and Evil adalah film fantasi Amerika tahun 2022 yang disutradarai oleh Paul Feig, yang ikut menulis skenario bersama David Magee, berdasarkan novel tahun 2013 berjudul sama karya Soman Chainani.",
            "All Quiet on the Western Front adalah sebuah film epik asal Jerman yang diproduksi pada tahun 2022 berdasarkan novel dngan nama yang sama karangan Erich Maria Remarque",
            "After Ever Happy adalah sebuah film drama romantis Amerika Serikat tahun 2022 yang disutradarai oleh Castille Landon, dari sebuah skenario oleh Sharon Soboil. Berdasarkan novel 2015 dengan nama yang sama oleh Anna Todd, itu adalah sekuel After We Fell, dan angsuran keseluruhan keempat dalam seri film After.",
            "Satu persatu penghuni asrama putri kerasukan. Zahra dan Yolanda berusaha mengungkap keganjilan yang terjadi pada teman-teman mereka, sampai pada satu malam, semua Jin Qorin penghuni asrama putri bangkit mengancam nyawa.",


            )

        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }

    }

}