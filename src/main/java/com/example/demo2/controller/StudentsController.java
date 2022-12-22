package com.example.demo2.controller;

import com.example.demo2.model.Students;
import com.example.demo2.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    public List<Students> getStudentsPaymentFalse() {
        //Получение списка студентов не оплативших курс.
        List<Students> students = studentsService.findAllByPayment();
        return students;
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
        // Получение студентов по имени
    // http://localhost:8080/first?firstName=gena  gena - имя студента
    }

//    @DeleteMapping("/delete/{id}")
//    @ResponseBody
//    public List<Students> deleteById(@PathVariable ("id")Long id) {
////        List<Students> delete = studentsService.deleteById(id);
////        //studentsService.deleteById(id);
////        return delete;

        //@DeleteMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
        //public void deleteById(@RequestParam (value = "id") Long id) {
    public void deleteById(PathVariable("id") Long id) {
            studentsService.deleteById(id);
    }





}
