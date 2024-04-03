package org.example.persistent

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import java.time.Instant

data class Book(
    @Id
    val id: Long?,

    @NotBlank(message = "The book ISBN must be defined.")
    @Pattern(
        regexp = "^([0-9]{10}|[0-9]{13})$",
        message = "The ISBN format must be valid."
    )
    val isbn: String,

    @NotBlank(message = "The book title must be defined.")
    val title: String,

    @NotBlank(message = "The book author must be defined.")
    val bookAuthor: String,

    @NotNull(message = "The book price must be defined.")
    @Positive(message = "The book price must be greater than zero.")
    val price: Double,

    @Version
    val version: Int,

    @CreatedDate
    val createdDate: Instant?,

    @LastModifiedDate
    val lastModifiedDate: Instant?,
) {
    companion object {
        fun of(isbn: String, title: String, author: String, price: Double) =
            Book(
                id = null,
                isbn = isbn,
                title = title,
                bookAuthor = author,
                price = price,
                version = 0,
                createdDate = null,
                lastModifiedDate = null,
            )
    }
}
