package com.rayzor.fireemblemapi.models;

import java.util.List;

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
}
