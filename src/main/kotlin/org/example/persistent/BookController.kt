package org.example.persistent

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController(
    private val bookService: BookService
) {
    @GetMapping
    fun getAll(pageable: Pageable): Page<Book> = bookService.getAll(pageable)

    @PostMapping
    fun create(@RequestBody book: Book) {
        bookService.create(book)
    }

    @PutMapping("/{isbn}")
    fun update(@PathVariable isbn: String, @RequestBody book: Book) {
        bookService.update(isbn, book)
    }
}