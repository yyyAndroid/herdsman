package com.arcfun.afl.designmode.iterator

/**
 * 书籍迭代器
 */
class Bookcase(val books: List<Book>) : Iterator<Book> {

    private val iterator: Iterator<Book>

    init {
        iterator = books.iterator()
    }

    override fun hasNext(): Boolean = iterator.hasNext()

    override fun next(): Book = iterator.next()

}