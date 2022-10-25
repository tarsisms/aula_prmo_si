package br.ifal.aula

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PacoteAdapter (val context: Context, val list: ArrayList<PacoteTuristico>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(index: Int): Any {
       return list[index]
    }

    override fun getItemId(index: Int): Long {
        return index.toLong()
    }

    override fun getView(index: Int, viewLayout: View?, viewGroup: ViewGroup?): View {
        var layout : View? = viewLayout
        val inflater = LayoutInflater.from(context)

        if(layout == null){
            layout = inflater.inflate(R.layout.item_listview_pacote, viewGroup, false)
        }

        // Recuperar o Objeto
        val pacote = getItem(index) as PacoteTuristico

        // Recuperar o Layout
        val titulo = layout!!.findViewById<TextView>(R.id.item_pacote_titulo)
        val descricao = layout.findViewById<TextView>(R.id.item_pacote_descricao)
        val diarias = layout.findViewById<TextView>(R.id.item_pacote_diarias)
        val pessoas = layout.findViewById<TextView>(R.id.item_pacote_num_pessoas)
        val precoAntigo = layout.findViewById<TextView>(R.id.item_pacote_preco_antigo)
        val precoAtual = layout.findViewById<TextView>(R.id.item_pacote_preco_atual)


        // Alterar Layout
        titulo.text = pacote.titulo
        descricao.text = pacote.descricao
        diarias.text = pacote.diarias
        pessoas.text = pacote.pessoas
        precoAntigo.text = "A partir de ${pacote.precoAntigo}"
        precoAtual.text = "R$ ${pacote.precoAtual}"


        return layout

    }
}