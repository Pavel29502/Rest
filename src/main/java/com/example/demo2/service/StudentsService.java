package com.example.demo2.service;
import com.example.demo2.exception.NotFoundException;
import com.example.demo2.model.Students;
import com.example.demo2.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    public Students findById(Long id) throws NotFoundException {
        //получить студента по id
        return studentsRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found with id " + id));
    }
    public List<Students> findAll() {
        return studentsRepository.findAll();
    }
    //public void create(Long id, String firstName, String lastName, String groupp, boolean payment) {
    //Students student1 = new Students(id, firstName, lastName, groupp, payment);
    public void create(Students student1) {
        studentsRepository.save(student1);
    }

    public List<Students> findAllByPayment() {

        return studentsRepository.findAllByPaymentFalse();
    }

    public List<Students> findAllByGroupp(String groupp) {
        return studentsRepository.findAllByGroupp(groupp);
    }

    public List<Students> findByFirstName(String firstName) {
        return studentsRepository.findByFirstName(firstName);
    }

    public void deleteById(Long id) {
        studentsRepository.deleteById(id);
    }

    public List<Students> findByLastName(String lastName) {
        return studentsRepository.findByLastName(lastName);
    }
}
//        public List<Students> addNewStudent(@RequeestBody)
//    }
