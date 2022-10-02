package com.kitapl.k.bookservice.dto

data class BookIdDto @JvmOverloads constructor(   val bookId :String ? ="",

                                                  val isbn : String) {
    companion object {
        @JvmStatic
        fun convert(bookId: String?,isbn: String): BookIdDto {
            return BookIdDto(bookId,isbn)
        }
    }
}