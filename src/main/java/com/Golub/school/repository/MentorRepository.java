package com.Golub.school.repository;

import com.Golub.school.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    Mentor findMentorByIdmentor(int id);

    List<Mentor> findMentorBySurname(String surname);

    List<Mentor> findMentorByName(String name);

    Mentor findMentorByUsers_Iduser(int id);
}
