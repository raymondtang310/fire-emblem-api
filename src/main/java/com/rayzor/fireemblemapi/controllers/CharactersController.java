package com.rayzor.fireemblemapi.controllers;

import com.rayzor.fireemblemapi.models.Character;
import com.rayzor.fireemblemapi.models.CharactersResponse;
import com.rayzor.fireemblemapi.repositories.CharactersRepository;
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
