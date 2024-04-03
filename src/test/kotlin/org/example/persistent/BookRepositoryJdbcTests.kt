package org.example.persistent

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.context.annotation.Import
import org.springframework.data.jdbc.core.JdbcAggregateTemplate
import org.springframework.test.context.ActiveProfiles

@DataJdbcTest
@Import(value = [DataConfig::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
class BookRepositoryJdbcTests {

    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var jdbcAggregateTemplate: JdbcAggregateTemplate

    @Test
    fun findBookByIsbnWhenExisting() {
        val bookIsbn = "1234561237"
        val book = Book.of(bookIsbn, "Title", "Author", 12.90)
        jdbcAggregateTemplate.insert(book)
        val actualBook: Book? = bookRepository.findByIsbn(bookIsbn)

        assertThat(actualBook).isNotNull
        assertThat(actualBook?.isbn).isEqualTo(book.isbn)
    }
}
