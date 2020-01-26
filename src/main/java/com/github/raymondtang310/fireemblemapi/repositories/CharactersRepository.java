package com.github.raymondtang310.fireemblemapi.repositories;

import com.github.raymondtang310.fireemblemapi.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharactersRepository extends MongoRepository<Character, String> {
    List<Character> findByName(String name);
}
