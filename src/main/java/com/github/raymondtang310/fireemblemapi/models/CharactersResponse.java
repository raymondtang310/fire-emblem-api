package com.github.raymondtang310.fireemblemapi.models;

import java.util.List;
import java.util.Objects;

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
