package com.rayzor.fireemblemapi.repositories;

import com.rayzor.fireemblemapi.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharactersRepository extends MongoRepository<Character, String> {
    List<Character> findByName(String name);
}
