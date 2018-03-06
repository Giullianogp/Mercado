package com.giulliano.mercado.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

import com.giulliano.mercado.model.Item

/**
 * Created by Giulliano on 06/03/2018.
 */

@Database(entities = arrayOf(Item::class), version = 1)
abstract class MDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {

        lateinit var INSTANCE: MDatabase


        internal fun getDatabase(context: Context): MDatabase {
            if (INSTANCE == null) {
                synchronized(MDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                MDatabase::class.java, "mercado_database")
                                .build()

                    }
                }
            }
            return INSTANCE
        }
    }

}
