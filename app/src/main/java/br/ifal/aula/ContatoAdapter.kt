package br.ifal.aula

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ContatoAdapter (val context: Context, val list: ArrayList<Contato>) : BaseAdapter() {
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
            layout = inflater.inflate(R.layout.item_listview, viewGroup, false)
        }

        val name = layout!!.findViewById<TextView>(R.id.contactName)
        val msg = layout.findViewById<TextView>(R.id.contactMsg)

        val contato = getItem(index) as Contato

        name.text = contato.nome
        msg.text = contato.msg

        return layout

    }
}