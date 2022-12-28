package br.ifal.aula.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ifal.aula.databinding.ActivityPacoteDetailBinding
import br.ifal.aula.domain.Pacote

class PacoteDetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPacoteDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            val pacote = intent.getSerializableExtra("pacote") as Pacote
            val textViewTitle = pacoteDetailTitle //findViewById<TextView>(R.id.pacote_detail_title)
            textViewTitle.text = pacote.titulo

            configButton()
        }

    }

    private fun configButton() {
        val button = binding.buttonAccessar // findViewById<Button>(R.id.button_accessar)
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