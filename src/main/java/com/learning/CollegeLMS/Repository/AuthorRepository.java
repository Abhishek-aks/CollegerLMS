package com.learning.CollegeLMS.Repository;

import com.learning.CollegeLMS.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}