package com.giulliano.mercado

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.giulliano.mercado.Model.Item
import com.google.firebase.database.FirebaseDatabase


/**
 * Created by Giulliano on 28/02/2018.
 */
class MainViewModel : ViewModel() {

    private val dataRef = FirebaseDatabase.getInstance().getReference().child("itens")

    private var itens: MutableLiveData<List<Item>>? = null

    fun getItens(): LiveData<List<Item>> {
        if (itens == null) {
            itens = MutableLiveData()
            loadItens()
        }
        return itens as MutableLiveData<List<Item>>
    }

    private fun loadItens() {



    }
}