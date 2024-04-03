package org.example.persistent

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository,
) {
    fun getAll(pageable: Pageable): Iterable<Book> = bookRepository.findAll(pageable)

    fun create(book: Book): Book = bookRepository.save(book)

    @Transactional
    fun update(isbn: String, book: Book): Book =
        bookRepository.findByIsbn(isbn)
            ?.let {
                val toUpdate = it.copy(
                    title = book.title,
                    bookAuthor = book.bookAuthor,
                    price = book.price
                )
                bookRepository.save(toUpdate)
            }
            ?: create(book)
}
