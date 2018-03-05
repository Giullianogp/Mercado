package com.giulliano.mercado.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.giulliano.mercado.model.Item
import android.arch.persistence.room.Room
import android.content.Context


/**
 * Created by giull on 02/03/2018.
 */

@Database(entities = [(Item::class)], version = 1)

abstract class MercadoDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    private var INSTANCE: MercadoDatabase? = null

    fun getDatabase(context: Context): MercadoDatabase? {
        if (INSTANCE == null) {
            synchronized(MercadoDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MercadoDatabase::class.java!!, "word_database")
                            .build()

                }
            }
        }
        return INSTANCE
    }
}
