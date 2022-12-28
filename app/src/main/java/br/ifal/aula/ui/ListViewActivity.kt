package br.ifal.aula.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.ifal.aula.R
import br.ifal.aula.api.RetrofitHelper
import br.ifal.aula.api.model.AddressDTO
import br.ifal.aula.data.DatabaseHelper
import br.ifal.aula.databinding.ActivityPacotesDestaquesBinding
import br.ifal.aula.domain.Address
import br.ifal.aula.domain.Pacote
import br.ifal.aula.ui.adapters.PacoteAdapter
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPacotesDestaquesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lista: ArrayList<Pacote> = arrayListOf(
            Pacote(
                image = R.drawable.cancun,
                titulo = "Pacote Cancún 2023",
                descricao = "Aéreo + Aluguel de Carros",
                diarias = "03 Diárias",
                pessoas = "02 Pessoas",
                precoAntigo = 5600.0,
                precoAtual = 3260.0
            ),
            Pacote(
                image = R.drawable.cancun,
                titulo = "Pacote Fortaleza 2022",
                descricao = "Aéreo + Aluguel de Carros",
                diarias = "03 Diárias",
                pessoas = "02 Pessoas",
                precoAntigo = 5600.0,
                precoAtual = 3260.0
            ),
            Pacote(
                image = R.drawable.cancun,
                titulo = "Pacote Maceió 2021",
                descricao = "Aéreo + Aluguel de Carros",
                diarias = "03 Diárias",
                pessoas = "02 Pessoas",
                precoAntigo = 5600.0,
                precoAtual = 3260.0
            ),
            Pacote(
                image = R.drawable.cancun,
                titulo = "Pacote Maragogi 2023",
                descricao = "Aéreo + Aluguel de Carros",
                diarias = "03 Diárias",
                pessoas = "02 Pessoas",
                precoAntigo = 5600.0,
                precoAtual = 3260.0
            ),
        )

        val dao = DatabaseHelper.getInstance(this).pacoteDao()
        val listView = binding.listviewMain // findViewById<ListView>(R.id.listview_main)

        val adapter: PacoteAdapter = PacoteAdapter(this)

        val scope = MainScope()
        scope.launch {
            val listPacotes = withContext(Dispatchers.IO) {
                dao.findAll()
            }

            adapter.atualiza(listPacotes)
        }

        val TAG = "ListViewActivity"
        val scopeIO = CoroutineScope(Dispatchers.IO)
        scopeIO.launch {
            Log.i(TAG, "onCreate: Fazendo a requisicao")

            val call: Call<AddressDTO> = RetrofitHelper().addressService.findAddressByCep("57300190")
            val response: Response<AddressDTO> = call.execute()

            Log.i(TAG, "onCreate: ${response.code()}")

            response.body()?.let { addressDTO ->
                Log.i(TAG, "onCreate: ${addressDTO.address.bairro}")
            }

            Log.i(TAG, "onCreate: Finalizando a requisicao")
        }


        listView.adapter = adapter
        listView.setOnItemClickListener { adapterView, view, position, id ->
            var intent = Intent(this, PacoteDetailActivity::class.java)

            val pacote = adapter.getItem(position) as Pacote
            intent.putExtra("pacote", pacote)

            startActivity(intent)
        }


    }
}