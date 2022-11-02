package br.ifal.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PacoteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacote_detail)

        val pacote = intent.getSerializableExtra("pacote") as PacoteTuristico

        val textViewTitle = findViewById<TextView>(R.id.pacote_detail_title)
        textViewTitle.text = pacote.titulo;
    }
}