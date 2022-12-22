package com.example.demo2.service;

import com.example.demo2.model.Students;
import com.example.demo2.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentsService {
@Autowired
    private StudentsRepository studentsRepository;

    public Students findById(Long id) {
    //получить студента по id
        return studentsRepository.findById(id).orElse(null);
    }

    public List<Students> findAllByPayment() {
        return studentsRepository.findAllByPaymentFalse();
    }

    public List<Students> findAllByGroupp(String groupp) {
        return studentsRepository.findAllByGroupp(groupp);
    }

    public List<Students> findByFirstName(String firstName) {
        return  studentsRepository.findByFirstName(firstName);
    }

    public void deleteById(Long id) {
       studentsRepository.deleteById(id);
    }
}
