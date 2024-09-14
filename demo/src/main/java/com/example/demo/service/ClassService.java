package com.example.demo.service;

import com.example.demo.model.Classroom;
import com.example.demo.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    // Retrieve all classrooms
    public List<Classroom> getAllClassrooms() {
        return classRepository.findAll();
    }

    // Retrieve a classroom by its ID
    public Classroom getClassroomById(Long id) {
        return classRepository.findById(id).orElse(null);
    }

    // Create a new classroom
    public Classroom createClassroom(Classroom classroom) {
        return classRepository.save(classroom);
    }

    // Update an existing classroom
    public Classroom updateClassroom(Long id, Classroom classroom) {
        if (classRepository.existsById(id)) {
            classroom.setId(id);
            return classRepository.save(classroom);
        }
        return null; // Return null if the classroom with the specified ID does not exist
    }

    // Delete a classroom by its ID
    public boolean deleteClassroom(Long id) {
        if (classRepository.existsById(id)) {
            classRepository.deleteById(id);
            return true;
        }
        return false; // Return false if the classroom with the specified ID does not exist
    }
}
