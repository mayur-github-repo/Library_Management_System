package org.mayur.Library_Management_System.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String address;
    @Column(nullable = false, unique = true)
    private String contact;
    @Column(length = 30,unique = true)
    private String email;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
    @OneToMany(mappedBy = "student")
    private List<Book> booksList;
    @Enumerated
    private StudentType studentType;

    @OneToOne
    @JoinColumn
    private User user;

}
