package org.mayur.Library_Management_System.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;
    private int cost;
    @ManyToOne
    @JoinColumn
//    @JsonIgnoreProperties("bookList")
    @JsonIgnore
    private Author author;

    private String bookNo; // just to keep a track which student took which book
    @Enumerated(value = EnumType.STRING)
    private BookType type;
    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties("booksList")
    private Student student;

    //composite key


}
