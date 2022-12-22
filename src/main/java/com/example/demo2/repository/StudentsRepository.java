package com.example.demo2.repository;

import com.example.demo2.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {
    //List<MyStudents> findByLastName(String lastName)

    //List<MyStudents> findAllBy
    List<Students> findAllByPaymentFalse();
    //List<Students> findAllByPayment(boolean payment);

    List<Students> findAllByGroupp(String groupp);
    List<Students> findByFirstName(String firstName);
    void deleteById(Long id);


}
