package com.github.raymondtang310.fireemblemapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;
import java.util.Objects;

/**
 * A VoiceActors object encapsulates data on a Fire Emblem character's voice actors, which includes:
 * <ul>
 * <li>English voice actors who have portrayed the character
 * <li>Japanese voice actors who have portrayed the character
 * </ul>
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0.0
 */
@JsonInclude(Include.NON_NULL)
public class VoiceActors {
    private List<String> english;
    private List<String> japanese;

    /**
     * Initializes a new {@link VoiceActors} instance.
     *
     * @since 1.0.0
     */
    public VoiceActors() {
    }

    /**
     * Returns the English voice actors of this {@link VoiceActors} object.
     *
     * @return returns a {@link List} of English voice actors of this {@link VoiceActors} object
     * @since 1.0.0
     */
    public List<String> getEnglish() {
        return english;
    }

    /**
     * Sets the English voice actors of this {@link VoiceActors} object to the specified voice actors.
     *
     * @param english a {@link List} of English voice actors to set for this {@link VoiceActors} object
     * @since 1.0.0
     */
    public void setEnglish(List<String> english) {
        this.english = english;
    }

    /**
     * Returns the Japanese voice actors of this {@link VoiceActors} object.
     *
     * @return returns a {@link List} of Japanese voice actors of this {@link VoiceActors} object
     * @since 1.0.0
     */
    public List<String> getJapanese() {
        return japanese;
    }

    /**
     * Sets the Japanese voice actors of this {@link VoiceActors} object to the specified voice actors.
     *
     * @param japanese a {@link List} of Japanese voice actors to set for this {@link VoiceActors} object
     * @since 1.0.0
     */
    public void setJapanese(List<String> japanese) {
        this.japanese = japanese;
    }

    /**
     * Indicates whether the specified object is "equal to" this {@link VoiceActors} object. Two instances of {@link
     * VoiceActors} are considered equal if the English and Japanese voice actors of each instance are equal to each
     * other.
     *
     * @param object the reference object with which to compare
     * @return true if this {@link VoiceActors} is equal to the specified object; false otherwise
     * @since 1.0.0
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VoiceActors that = (VoiceActors) object;
        return Objects.equals(english, that.english) &&
                Objects.equals(japanese, that.japanese);
    }

    /**
     * Returns a hash code value for this {@link VoiceActors} object. This method is supported for the benefit of hash
     * tables such as those provided by HashMap.
     *
     * @return a hash code value for this {@link VoiceActors} object
     * @since 1.0.0
     */
    @Override
    public int hashCode() {
        return Objects.hash(english, japanese);
    }

    /**
     * Returns a string representation of this {@link VoiceActors} object.
     *
     * @return a {@link String} representation of this {@link VoiceActors} object
     * @since 1.0.0
     */
    @Override
    public String toString() {
        return "VoiceActors{" +
                "english=" + english +
                ", japanese=" + japanese +
                '}';
    }
}
