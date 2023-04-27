package com.learning.CollegeLMS.Service;


import com.learning.CollegeLMS.DTO.AuthorEntryDto;
import com.learning.CollegeLMS.DTO.AuthorResponseDto;
import com.learning.CollegeLMS.DTO.BookResponseDto;
import com.learning.CollegeLMS.Model.Author;
import com.learning.CollegeLMS.Model.Book;
import com.learning.CollegeLMS.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    public String createAuthor(AuthorEntryDto authorEntryDto){

        //Important step is : in the params : the object i
        //of type DTO but the repository interacts only with entities

        //Solution : Convert authorEntryDto ---> Author

        //Created an object of type Author
        Author author = new Author();

        //we are setting its attribute so that we can save
        //correct values in the db.
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());

        authorRepository.save(author);

        return "Author added successfully";
    }

    public AuthorResponseDto getAuthor(Integer authorId){

        Author author =  authorRepository.findById(authorId).get();
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        //Set its attributes.
        //List<Book> --> List<BookResponseDto>
        List<Book> bookList = author.getBooksWritten();

        List<BookResponseDto> booksWrittenDto = new ArrayList<>();

        for(Book b : bookList){

            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setGenre(b.getGenre());
            bookResponseDto.setPages(b.getPages());
            bookResponseDto.setName(b.getName());

            booksWrittenDto.add(bookResponseDto);
        }
        //Set attributes for authorResponse Dto
        authorResponseDto.setBooksWritten(booksWrittenDto);
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setRating(author.getRating());


        return authorResponseDto;

    }
}
