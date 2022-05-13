package com.Golub.school.service;

import com.Golub.school.entity.Card;
import com.Golub.school.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card findCardById(int id) {
        return cardRepository.findCardByIdcard(id);
    }

    public Card findCardByIdstudent(int id) {return cardRepository.findCardByStudents_Idstudents(id);}
}
