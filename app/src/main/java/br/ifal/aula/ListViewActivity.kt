package br.ifal.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacotes_destaques)

        val lista: ArrayList<PacoteTuristico> = arrayListOf(
            PacoteTuristico(
                R.drawable.cancun,
                "Pacote Cancún 2023",
                "Aéreo + Aluguel de Carros",
                "03 Diárias",
                "02 Pessoas",
                5600.0,
                3260.0
            ),
            PacoteTuristico(
                R.drawable.cancun,
                "Pacote Cancún 2023",
                "Aéreo + Aluguel de Carros",
                "03 Diárias",
                "02 Pessoas",
                5600.0,
                3260.0
            ),PacoteTuristico(
                R.drawable.cancun,
                "Pacote Cancún 2023",
                "Aéreo + Aluguel de Carros",
                "03 Diárias",
                "02 Pessoas",
                5600.0,
                3260.0
            ),PacoteTuristico(
                R.drawable.cancun,
                "Pacote Cancún 2023",
                "Aéreo + Aluguel de Carros",
                "03 Diárias",
                "02 Pessoas",
                5600.0,
                3260.0
            ),
        )

        val listView = findViewById<ListView>(R.id.listview_main)
        listView.adapter = PacoteAdapter(this, lista)
    }
}