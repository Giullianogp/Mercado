package com.giulliano.mercado.data

import android.arch.persistence.room.OnConflictStrategy.REPLACE

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.giulliano.mercado.model.Item

/**
 * Created by giull on 02/03/2018.
 */

@Dao
interface ItemDao {

    @Insert(onConflict = REPLACE)
    fun insert(item: Item)

    @Query("SELECT * FROM item")
    fun getItens(): LiveData<List<Item>>

    @Query("Delete FROM item where Id = :itemId")
    fun deleteItem(itemId: Int)

    @Query("Delete FROM item")
    fun deleteAll()



}
