package com.example.demo2.controller;
import com.example.demo2.exception.NotFoundException;
import com.example.demo2.model.Students;
import com.example.demo2.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("/findStudent")
    public Students findById(@RequestParam Long id) throws NotFoundException {
        Students findStudent = studentsService.findById(id);
        return findStudent;
    }
    @GetMapping("/all")
    public List<Students> findAll() {
    List<Students> all = studentsService.findAll();
    return all;
        //Получение списка студентов.
        //http://localhost:8080/all
    }
    @GetMapping("/students")
    public List<Students> getStudentsPaymentFalse() {
        List<Students> students = studentsService.findAllByPayment();
        return students;
        //Получение списка студентов не оплативших курс.
        //http://localhost:8080/students
    }
    @GetMapping("/number")
    public List<Students> getFindAllByGroupp(@RequestParam String groupp) {
    List<Students> number = studentsService.findAllByGroupp(groupp);
    return number;
    // Получение студентов по номеру группы
    // http://localhost:8080/number?groupp=7b   7b - номер группы
    }
    @GetMapping("/first")
    public List<Students> getFindByFirstName(@RequestParam String firstName) {
        List<Students> first = studentsService.findByFirstName(firstName);
        return first;
        // Получение студентов по имени.
        // http://localhost:8080/first?firstName=gena  gena - имя студента
    }
    @GetMapping("/last")
    public List<Students> getFindByLastName(@RequestParam String lastName) {
        List<Students> last = studentsService.findByLastName(lastName);
        return last;
        // Получение студентов по фамилии.
        //http://localhost:8080/last?lastName=lis
    }
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
            studentsService.deleteById(id);
            //Удаление студента по id.
    }
@PostMapping("/create")
    public void create(@RequestBody Students student1) {
        studentsService.create(student1);
        //Добавление студента.
        // 1)Пишем в постман, ложим в body.
//    {
//        "id": 10,
//            "firstName": "Zlatan",
//            "lastName": "Ibragimovich",
//            "groupp": "7b",
//            "payment": true
//    }
    // 2) еще можно через URL в браузере.
//    @PostMapping("/create/{id}")
//    public void create(@RequestBody Students student1,
//                       @RequestParam String groupp,
//                       @RequestParam String firstName,
//                       @PathVariable Long id) {
//        studentsService.create(student1);

    }



}
