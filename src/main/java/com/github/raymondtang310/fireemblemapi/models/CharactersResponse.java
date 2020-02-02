package com.github.raymondtang310.fireemblemapi.models;

import java.util.List;
import java.util.Objects;

/**
 * CharactersResponse is the class of an object that serializes into a JSON response containing a list of Fire
 * Emblem characters.
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0
 */
public class CharactersResponse {
    private List<Character> characters;

    public CharactersResponse() {
    }

    public CharactersResponse(List<Character> characters) {
        this.characters = characters;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharactersResponse that = (CharactersResponse) o;
        return Objects.equals(characters, that.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characters);
    }
}
