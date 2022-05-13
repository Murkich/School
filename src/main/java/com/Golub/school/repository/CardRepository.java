package com.Golub.school.repository;

import com.Golub.school.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Card findCardByIdcard(int id);

    Card findCardByStudents_Idstudents(int id);
}
