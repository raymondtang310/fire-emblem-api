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

import java.util.Arrays;
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
     * Tests that the <code>getCharacters</code> method finds {@link Character}s by the specified name if the specified
     * name is not null.
     */
    @Test
    public void testGetCharactersShouldFindCharactersByNameIfNameIsNotNull() {
        String name = "Byleth";
        Character character = new Character();
        character.setName(name);
        List<Character> characters = Collections.singletonList(character);
        Mockito.doReturn(characters).when(repository).findByName(name);

        CharactersResponse response = controller.getCharacters(name);

        Mockito.verify(repository, Mockito.times(1)).findByName(name);
        Mockito.verify(repository, Mockito.never()).findAll();
        assertEquals(new CharactersResponse(characters), response);
    }

    /**
     * Tests that the <code>getCharacters</code> method finds all {@link Character}s if the specified name is null.
     */
    @Test
    public void testGetCharactersShouldFindAllCharactersIfNameIsNull() {
        String name = null;
        Character character1 = new Character();
        character1.setName("Byleth");
        Character character2 = new Character();
        character2.setName("Ike");
        List<Character> characters = Arrays.asList(character1, character2);
        Mockito.doReturn(characters).when(repository).findAll();

        CharactersResponse response = controller.getCharacters(name);

        Mockito.verify(repository, Mockito.never()).findByName(name);
        Mockito.verify(repository, Mockito.times(1)).findAll();
        assertEquals(new CharactersResponse(characters), response);
    }
}
