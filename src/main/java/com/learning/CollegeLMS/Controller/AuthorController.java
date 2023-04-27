package com.learning.CollegeLMS.Controller;

import com.learning.CollegeLMS.DTO.AuthorEntryDto;
import com.learning.CollegeLMS.DTO.AuthorResponseDto;
import com.learning.CollegeLMS.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {

    //    / is optional : you want to write you can
    // otherwise not required


    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){
        return authorService.createAuthor(authorEntryDto);
    }


    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId")Integer authorId){
        return authorService.getAuthor(authorId);
    }
}
