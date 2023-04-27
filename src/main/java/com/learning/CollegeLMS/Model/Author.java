package com.learning.CollegeLMS.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter                 // part of lombok-Dependency
@Setter                 // part of lombok-Dependency
@Table(name = "author")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String name;
     int age;
     String country;
     double rating;

    //This annotation I am writing in the parent class :
    //Part of bidirectional mapping

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> booksWritten;


    public Author(){
        booksWritten = new ArrayList<>();
    }


}