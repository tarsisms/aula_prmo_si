package br.ifal.aula.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.ifal.aula.R
import br.ifal.aula.domain.Pacote
import coil.load

class PacoteAdapter(
    val context: Context,
    pacotes: List<Pacote> = emptyList(),
) : BaseAdapter() {

    private var listPacotes = pacotes.toMutableList()

    override fun getCount(): Int {
        return listPacotes.size
    }

    override fun getItem(index: Int): Any {
        return listPacotes[index]
    }

    override fun getItemId(index: Int): Long {
        return index.toLong()
    }

    override fun getView(index: Int, viewLayout: View?, viewGroup: ViewGroup?): View {
        var layout: View? = viewLayout
        val inflater = LayoutInflater.from(context)

        if (layout == null) {
            layout = inflater.inflate(R.layout.item_listview_pacote, viewGroup, false)
        }

        // Recuperar o Objeto
        val pacote = getItem(index) as Pacote

        // Recuperar o Layout
        val image = layout!!.findViewById<ImageView>(R.id.image_item)
        val titulo = layout.findViewById<TextView>(R.id.item_pacote_titulo)
        val descricao = layout.findViewById<TextView>(R.id.item_pacote_descricao)
        val diarias = layout.findViewById<TextView>(R.id.item_pacote_diarias)
        val pessoas = layout.findViewById<TextView>(R.id.item_pacote_num_pessoas)
        val precoAntigo = layout.findViewById<TextView>(R.id.item_pacote_preco_antigo)
        val precoAtual = layout.findViewById<TextView>(R.id.item_pacote_preco_atual)


        // Alterar Layout
        image.load("https://viagemeturismo.abril.com.br/wp-content/uploads/2016/10/01241975-4f8a5b1f0f.jpeg?quality=70&strip=info&w=920&w=636")
        titulo.text = pacote.titulo
        descricao.text = pacote.descricao
        diarias.text = pacote.diarias
        pessoas.text = pacote.pessoas
        precoAntigo.text = "A partir de ${pacote.precoAntigo}"
        precoAtual.text = "R$ ${pacote.precoAtual}"


        return layout

    }

    fun atualiza(pacotes: List<Pacote>) {
        listPacotes.clear()
        listPacotes.addAll(pacotes)
        notifyDataSetChanged()
    }
}