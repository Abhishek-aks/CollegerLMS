package com.learning.CollegeLMS.Service;



import com.learning.CollegeLMS.DTO.BookRequestDto;
import com.learning.CollegeLMS.Model.Author;
import com.learning.CollegeLMS.Model.Book;
import com.learning.CollegeLMS.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){

        //I want to get the AuthorEntity ???
        int authorId  = bookRequestDto.getAuthorId();

        //Now I will be fetching the authorEntity

        Author author = authorRepository.findById(authorId).get();

        //convertor
        //we have created this Entity so  that we can save it into the database
        Book book=new Book();


        //Basic attributes are being from Dto to the Entity Layer
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());

        //setting the foreign key attribute in the child class:
        book.setAuthor(author);


        //we need to update the list of Book written in the parent class

        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);


        //Now the book is to be saved, but also author is alsoooo to be saved.

        //Why do we need to again save (updating) the author ?? bcz
        //bcz the author Entity has been updated....we need to resave/update it.


        authorRepository.save(author); //Date was modified

        //.save function works both as save function and as update function


        //bookRepo.save is not required : bcz it will be autocalled by cascading
        //effect

        return "Book Added successfully";
    }
}