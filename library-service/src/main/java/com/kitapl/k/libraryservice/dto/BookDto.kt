package com.kitapl.k.libraryservice.dto

data class BookDto @JvmOverloads constructor(
    val bookId :BookIdDto? =null,
    val title : String,
    val bookYear : Int ,
    val author : String ,
    val pressName :String)

