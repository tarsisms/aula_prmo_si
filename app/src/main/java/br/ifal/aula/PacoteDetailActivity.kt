package br.ifal.aula

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PacoteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacote_detail)

        val pacote = intent.getSerializableExtra("pacote") as PacoteTuristico

        val textViewTitle = findViewById<TextView>(R.id.pacote_detail_title)
        textViewTitle.text = pacote.titulo;

        val button = findViewById<Button>(R.id.button_accessar)
        button.setOnClickListener {

            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                data = Uri.parse("sms:8299854854")
                putExtra("sms_body", "TEXT")
                type = "text/plain"
            }

            startActivity(sendIntent)
        }
    }
}