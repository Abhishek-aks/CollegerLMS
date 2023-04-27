package com.learning.CollegeLMS.Repository;


import com.learning.CollegeLMS.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface CardRepository extends JpaRepository<Card,Integer> {

    }

