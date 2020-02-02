package com.github.raymondtang310.fireemblemapi.controllers;

import com.github.raymondtang310.fireemblemapi.models.Character;
import com.github.raymondtang310.fireemblemapi.models.CharactersResponse;
import com.github.raymondtang310.fireemblemapi.repositories.CharactersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CharactersControllerTest is a class for unit testing {@link CharactersController}.
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({CharactersController.class})
public class CharactersControllerTest {
    @Mock
    private CharactersRepository repository;
    @InjectMocks
    private CharactersController controller = new CharactersController();

    /**
     * Tests that the <code>getCharactersByName</code> method finds {@link Character}s by the specified name.
     */
    @Test
    public void testGetCharactersByNameShouldFindCharactersByName() {
        String name = "Byleth";

        controller.getCharactersByName(name);

        Mockito.verify(repository, Mockito.times(1)).findByName(name);
    }

    /**
     * Tests that the <code>getCharactersByName</code> method returns a {@link CharactersResponse} containing a
     * {@link List} of {@link Character}s that have the specified name
     */
    @Test
    public void testGetCharactersByNameShouldReturnCharactersResponse() {
        String name = "Byleth";
        Character character = new Character();
        character.setName(name);
        List<Character> characters = Collections.singletonList(character);
        Mockito.doReturn(characters).when(repository).findByName(name);

        CharactersResponse response = controller.getCharactersByName(name);

        assertEquals(new CharactersResponse(characters), response);
    }
}
