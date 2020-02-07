package com.github.raymondtang310.fireemblemapi.models;

import java.util.List;
import java.util.Objects;

/**
 * CharactersResponse is the class of an object that serializes into a JSON response containing a list of Fire Emblem
 * characters.
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0.0
 */
public class CharactersResponse {
    private List<Character> characters;

    /**
     * Initializes a new {@link CharactersResponse} instance.
     *
     * @since 1.0.0
     */
    public CharactersResponse() {
    }

    /**
     * Initializes a new {@link CharactersResponse} instance with the specified {@link List} of {@link Character}s.
     *
     * @param characters a {@link List} of {@link Character}s for initialization
     * @since 1.0.0
     */
    public CharactersResponse(List<Character> characters) {
        this.characters = characters;
    }

    /**
     * Returns characters stored in this {@link CharactersResponse}.
     *
     * @return a {@link List} of {@link Character}s stored in this {@link CharactersResponse}
     * @since 1.0.0
     */
    public List<Character> getCharacters() {
        return characters;
    }

    /**
     * Sets characters on this {@link CharactersResponse} to the specified characters.
     *
     * @param characters a {@link List} of {@link Character}s to set for this {@link CharactersResponse}
     * @since 1.0.0
     */
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    /**
     * Indicates whether the specified object is "equal to" this {@link CharactersResponse}. Two instances of {@link
     * CharactersResponse} are considered equal if the characters of each instance are equal to each other.
     *
     * @param object the reference object with which to compare
     * @return true if this {@link CharactersResponse} is equal to the specified object; false otherwise
     * @since 1.0.0
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CharactersResponse that = (CharactersResponse) object;
        return Objects.equals(characters, that.characters);
    }

    /**
     * Returns a hash code value for this {@link CharactersResponse}. This method is supported for the benefit of hash
     * tables such as those provided by HashMap.
     *
     * @return a hash code value for this {@link CharactersResponse}
     * @since 1.0.0
     */
    @Override
    public int hashCode() {
        return Objects.hash(characters);
    }

    /**
     * Returns a string representation of this {@link CharactersResponse}.
     *
     * @return a {@link String} representation of this {@link CharactersResponse}
     * @since 1.0.0
     */
    @Override
    public String toString() {
        return "CharactersResponse{" +
                "characters=" + characters +
                '}';
    }
}
