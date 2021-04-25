package com.arcfun.afl.designmode.iterator

class Bookcase2(val books: List<Book>) {
    operator fun Bookcase2.iterator(): Iterator<Book> = books.iterator()
}