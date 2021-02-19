package com.example.demo.webRest;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {
    @GetMapping("/students/all")
    public ResponseEntity getAll(){
        Student student = new Student(1L, "Davlatjon", "Ochilov", "Final");
        Student student1 = new Student(1L, "Temur", "Ismonov", "Final");
        Student student2 = new Student(1L, "Bobur", "Axmedov", "Final");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);

        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student2 = new Student(id, "Bobur", "Axmedov", "Final");
        return ResponseEntity.ok(student2);
    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course){
        Student student = new Student(id, name, lastName, course);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping ("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Ma'lumot o'chirildi !!!");
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id,
            @RequestBody Student studentNew){
        Student student2 = new Student(1L, "Bobur", "Axmedov", "Final");
        student2.setId(id);
        student2.setName(studentNew.getName());
        student2.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student2);
    }
}
