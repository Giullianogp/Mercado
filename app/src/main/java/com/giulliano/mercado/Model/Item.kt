package com.giulliano.mercado.Model

/**
 * Created by Giulliano on 28/02/2018.
 */
class Item {
    var descricao: String = ""
    var quantidade: Int = 0
    var valorUnitario: Float = 0F
    var valorTotal: Float = quantidade * valorUnitario
}