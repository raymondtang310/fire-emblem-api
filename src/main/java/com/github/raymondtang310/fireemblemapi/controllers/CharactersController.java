package com.github.raymondtang310.fireemblemapi.controllers;

import com.github.raymondtang310.fireemblemapi.models.Character;
import com.github.raymondtang310.fireemblemapi.models.CharactersResponse;
import com.github.raymondtang310.fireemblemapi.repositories.CharactersRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CharactersController is a {@link RestController} that provides methods matching HTTP endpoints for retrieving data
 * on Fire Emblem characters.
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0
 */
@RestController
@RequestMapping("/characters")
public class CharactersController {
    @Autowired
    private CharactersRepository repository;

    /**
     * Gets {@link Character}s that have the specified name.
     *
     * @param name the name of the {@link Character}(s) to search for
     * @return a {@link CharactersResponse} containing a {@link List} of {@link Character}s that have the specified name
     * @since 1.0
     */
    @GetMapping
    @ApiOperation(value = "Finds characters by name",
            notes = "Gets characters that have the specified name.",
            response = CharactersResponse.class)
    public CharactersResponse getCharactersByName(@ApiParam(value = "The name of the character(s) to search for", required = true)
                                                  @RequestParam String name) {
        List<Character> characters = repository.findByName(name);
        return new CharactersResponse(characters);
    }
}
