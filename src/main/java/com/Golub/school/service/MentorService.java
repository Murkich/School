package com.Golub.school.service;

import com.Golub.school.entity.Mentor;
import com.Golub.school.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    public Mentor findMentorByIduser(int id) { return mentorRepository.findMentorByUsers_Iduser(id);}

    public List<Mentor> findAll() {
        return mentorRepository.findAll();
    }

    public void saveMentor(Mentor mentor) {
        mentorRepository.save(mentor);
    }

    public List<Mentor> findMentorByName(String name) {
        return mentorRepository.findMentorByName(name);
    }

    public List<Mentor> findMentorBySurname(String surname) {
        return mentorRepository.findMentorBySurname(surname);
    }

    public Mentor findMentorById(int id) {
        return mentorRepository.findMentorByIdmentor(id);
    }

    public void deleteMentor(Mentor mentor) {
        mentorRepository.delete(mentor);
    }
}
