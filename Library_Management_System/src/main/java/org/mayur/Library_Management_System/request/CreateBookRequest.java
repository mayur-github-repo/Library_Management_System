package org.mayur.Library_Management_System.request;

import lombok.*;
import org.mayur.Library_Management_System.models.Author;
import org.mayur.Library_Management_System.models.Book;
import org.mayur.Library_Management_System.models.BookType;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateBookRequest {

    private String bookName;
    private int cost;
    private BookType type;

    private String bookNo;

    private String authorName;

    private String authorEmail;

    public Book to() {

        Author authorData = Author.builder().
                name(this.authorName).
                email(this.authorEmail).
                build();

        return Book.builder().
                bookNo(this.bookNo).
                name(this.bookName).
                type(this.type).
                cost(this.cost).
                author(authorData)
                .build();
    }
}
