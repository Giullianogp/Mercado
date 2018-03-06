package com.giulliano.mercado.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.giulliano.mercado.data.ItemDao
import com.giulliano.mercado.data.MDatabase
import com.giulliano.mercado.model.Item

/**
 * Created by giull on 02/03/2018.
 */

class ItemRepository internal constructor(application: Application) {

    private val itemDao: ItemDao
    internal val allItens: LiveData<List<Item>>

    init {
        val db = MDatabase.INSTANCE
        itemDao = db.itemDao()
        allItens = itemDao.getItens()
    }

    fun getAllItens(): LiveData<List<Item>> {
        return allItens
    }


    fun insert(item: Item) {
        insertAsyncTask(itemDao).execute(item)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: ItemDao) : AsyncTask<Item, Void, Void>() {

        override fun doInBackground(vararg params: Item): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}
