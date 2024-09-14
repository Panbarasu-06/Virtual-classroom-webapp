package com.example.demo.controller;

import com.example.demo.model.Classroom;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classService.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable Long id) {
        Classroom classroom = classService.getClassroomById(id);
        return classroom != null ? ResponseEntity.ok(classroom) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classService.createClassroom(classroom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable Long id, @RequestBody Classroom classroom) {
        Classroom updatedClassroom = classService.updateClassroom(id, classroom);
        return updatedClassroom != null ? ResponseEntity.ok(updatedClassroom) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Long id) {
        if (classService.deleteClassroom(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
