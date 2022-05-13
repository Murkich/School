package com.Golub.school.repository;

import com.Golub.school.entity.Course;
import com.Golub.school.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {

    Students findStudentsByIdstudents(int id);

    Students findStudentsByUsers_Iduser(int id);

    List<Students> findAllBySurnameContaining(String surname);

    List<Students> findAllByNameContaining(String name);
}
