package com.giulliano.mercado.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Giulliano on 28/02/2018.
 */
@Entity
class Item {

    @PrimaryKey
    val id: Int =0

    val descricao: String = ""
    val quantidade: Int = 0
    val valorUnitario: Float = 0F
    val valorTotal: Float = quantidade * valorUnitario
}