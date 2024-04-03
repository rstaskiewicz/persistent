package org.example.persistent

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.transaction.annotation.Transactional

interface BookRepository : CrudRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {
    fun findByIsbn(isbn: String): Book?

    @Modifying
    @Transactional
    @Query("delete from Book where isbn = :isbn")
    fun deleteByIsbn(isbn: String)
}
