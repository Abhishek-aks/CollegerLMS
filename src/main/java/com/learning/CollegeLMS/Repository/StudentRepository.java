package com.learning.CollegeLMS.Repository;

import com.learning.CollegeLMS.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);

    //select * from student where country=India;   //Return of Entities
    List<Student> findByCountry(String country);
}
