package com.giulliano.mercado.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.giulliano.mercado.R
import com.giulliano.mercado.model.Item

/**
 * Created by Giulliano on 06/03/2018.
 */

class ListItensAdapter internal constructor(context: Context) : RecyclerView.Adapter<ListItensAdapter.ItemViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mItens: List<Item>? = null // Cached copy of words

    class ItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val descricao: TextView = itemView.findViewById(R.id.txtItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = mInflater.inflate(R.layout.recycler_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if (mItens != null) {
            val current = mItens!![position]
            holder.descricao.text = current.descricao
        }
    }

    internal fun setItem(words: List<Item>) {
        mItens = words
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (mItens != null)
            mItens!!.size
        else
            0
    }

}
