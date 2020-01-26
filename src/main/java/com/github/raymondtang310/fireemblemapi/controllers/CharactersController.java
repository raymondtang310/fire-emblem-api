package com.github.raymondtang310.fireemblemapi.controllers;

import com.github.raymondtang310.fireemblemapi.models.CharactersResponse;
import com.github.raymondtang310.fireemblemapi.repositories.CharactersRepository;
import com.github.raymondtang310.fireemblemapi.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharactersController {
    @Autowired
    private CharactersRepository repository;

    @GetMapping
    public CharactersResponse getCharactersByName(@RequestParam String name) {
        List<Character> characters = repository.findByName(name);
        return new CharactersResponse(characters);
    }
}
