package br.ifal.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        val lista = arrayListOf<Contato>(
            Contato(

                "Chatinho do IFAL",
                "Oi Sumida.. rsrs",
                status = "Agora"
            ),
            Contato(
                "Carinha de logistica",
                "Oi Moça.. vamo tomar um açai?",
                status = "Hoje"
            ),
            Contato(
                "Varao da igreja",
                "Oi varoa.. vamos pra oração hoje?",
                "Ontem"
            )
        )

        val listView = findViewById<ListView>(R.id.listview_main)
        listView.adapter = ContatoAdapter(this, lista)
    }
}