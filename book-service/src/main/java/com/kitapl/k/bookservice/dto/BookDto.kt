package com.kitapl.k.bookservice.dto;

import com.kitapl.k.bookservice.model.Book

data class BookDto constructor(
    val bookId :BookIdDto? =null,
    val title : String,
    val bookYear : Int ,
    val author : String ,
    val pressName :String ,

){
    companion object {
        @JvmStatic
        fun convert(from:Book):BookDto{
            return  BookDto(
                from.bookId.let { BookIdDto.convert(it,from.isbn) },
                from.title,
                from.bookYear,
                from.author,
                from.pressName)


        }
    }
}