package com.giulliano.mercado.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.giulliano.mercado.model.Item
import com.giulliano.mercado.repository.ItemRepository
import javax.inject.Inject




/**
 * Created by Giulliano on 28/02/2018.
 */
class MainViewModel : ViewModel() {

    private var itens: LiveData<List<Item>>? = null
    private var itemRepo: ItemRepository? = null

    fun init() {
        if (this.itens != null) {
            return
        }
        itens = itemRepo?.items
    }


    @Inject
    fun MainViewModel(userRepo: ItemRepository) {
        this.itemRepo = userRepo
    }

    fun getItens(): LiveData<List<Item>>? {
        return this.itens
    }


}