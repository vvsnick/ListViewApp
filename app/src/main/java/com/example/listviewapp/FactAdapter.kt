package com.example.listviewapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class FactAdapter(context:Context,facts: List<FactModel>):ArrayAdapter<FactModel>(context,0,facts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val fact = getItem(position)

        if (view == null){

            view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item,parent,false)
        }

        val logo = view?.findViewById<ImageView>(R.id.image_logo)
        val name = view?.findViewById<TextView>(R.id.name_tv)

        fact?.logo?.let { logo?.setImageResource(fact.logo) }
        name?.text = fact?.name

        view?.setOnClickListener {
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRA, fact?.logo)
            intent.putExtra(NAME_EXTRA, fact?.name)
            intent.putExtra(FACT_EXTRA, fact?.fact)

            parent.context.startActivity(intent)
        }

        return view!!
    }

    companion object{
        val LOGO_EXTRA = "logo_extras"
        val NAME_EXTRA = "name_extras"
        val FACT_EXTRA = "fact_extras"
    }
}