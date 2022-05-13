package com.Golub.school.service;

import com.Golub.school.entity.*;
import com.Golub.school.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentsRepository StudentsRepository;

    public Students findStudentByIduser(int id) { return StudentsRepository.findStudentsByUsers_Iduser(id);}

    public List<Students> findAll() {
        return StudentsRepository.findAll();
    }

    public void saveStudents(Students students) {
        StudentsRepository.save(students);
    }

    public List<Students> findStudentsBySurname(String surname) {
        return StudentsRepository.findAllBySurnameContaining(surname);
    }

    public List<Students> findStudentsByName(String name) {
        return StudentsRepository.findAllByNameContaining(name);
    }

    public Students findStudentById(int id) {
        return StudentsRepository.findStudentsByIdstudents(id);
    }

    public void deleteStudent(Students students) {
        StudentsRepository.delete(students);
    }

    public void addStudent(Students students) {StudentsRepository.save(students);}
}
