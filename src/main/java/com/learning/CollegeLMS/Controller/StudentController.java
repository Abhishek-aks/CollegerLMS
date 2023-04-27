package com.learning.CollegeLMS.Controller;


import com.learning.CollegeLMS.DTO.StudentUpdateMobRequestDto;
import com.learning.CollegeLMS.Model.Student;
import com.learning.CollegeLMS.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/add")
    public String createdStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }

    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email")String email){

        return studentService.findNameByEmail(email);
    }


    @PutMapping("/update_mob")
    public String updateMob(@RequestBody StudentUpdateMobRequestDto studentReqDto){

        return studentService.updateMobNo(studentReqDto);
    }
}