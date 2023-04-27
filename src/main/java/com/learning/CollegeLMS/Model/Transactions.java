package com.learning.CollegeLMS.Model;

import com.learning.CollegeLMS.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="transactions")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Enumerated(value = EnumType.STRING)
    TransactionStatus transactionStatus;

     int fine;

     String transactionId = UUID.randomUUID().toString();

    @CreationTimestamp
     Date transactionDate;

     boolean isIssueOperation;

    //Things I will write for connecting it book.
    @ManyToOne
    @JoinColumn
    private Book book; //book entity pk will come here and become a foreign key.

    //We need to connect it to the Card class.
    @ManyToOne
    @JoinColumn
    private Card card;

}