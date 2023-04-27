package com.learning.CollegeLMS.Model;

import com.learning.CollegeLMS.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int pages;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    //Book is child with respect to author
    //Setting here the foreign key : Standard 3 steps


    @ManyToOne
    @JoinColumn //Add an extra attribute of authorId (parent table PK) for the foreign key of child table
    private Author author; //This is the parent entity we are connecting with


    //Book is also child wrt Card...
    @ManyToOne
    @JoinColumn
    private Card card;

    private boolean issued;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions> listOfTransactions = new ArrayList<>();

}