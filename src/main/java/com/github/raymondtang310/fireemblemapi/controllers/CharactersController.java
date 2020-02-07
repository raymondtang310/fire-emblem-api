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
 * CharactersController is a {@link RestController} that provides methods matching HTTP endpoints for retrieving data on
 * Fire Emblem characters.
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0.0
 */
@RestController
@RequestMapping("/characters")
public class CharactersController {
    @Autowired
    private CharactersRepository repository;

    /**
     * Gets {@link Character}s. {@link Character}s are filtered by the specified name if the specified name is not
     * <code>null</code>.
     *
     * @param name the name of the {@link Character}(s) to search for
     * @return a {@link CharactersResponse} containing a {@link List} of {@link Character}s that have the specified name
     * @since 1.0.0
     */
    @GetMapping
    @ApiOperation(value = "Finds characters",
            notes = "Returns Fire Emblem characters. Optionally, characters can be filtered by name.",
            response = CharactersResponse.class)
    public CharactersResponse getCharacters(@ApiParam(value = "The name of the character(s) to search for", example = "Byleth")
                                            @RequestParam(required = false) String name) {
        List<Character> characters = name != null ? repository.findByName(name) : repository.findAll();
        return new CharactersResponse(characters);
    }
}
