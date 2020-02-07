package com.github.raymondtang310.fireemblemapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

/**
 * Character is the class of an object that is mapped to from a document in the <code>characters</code> collection in
 * the <code>fireEmblemData</code> MongoDB database.
 * <p>
 * A Character object encapsulates data on a Fire Emblem character, which includes:
 * <ul>
 * <li>the name of the character
 * <li>a primary image of the character
 * <li>additional images of the characters
 * <li>games in which the character has appeared
 * <li>titles that the character is known by
 * <li>voice actors who have portrayed the character
 * </ul>
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0.0
 */
@Document(collection = "characters")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Character {
    @Id
    @JsonIgnore
    private ObjectId _id;
    private String name;
    private String primaryImage;
    private List<String> otherImages;
    private List<String> appearances;
    private List<String> titles;
    private VoiceActors voiceActors;

    /**
     * Initializes a new {@link Character} instance.
     *
     * @since 1.0.0
     */
    public Character() {
    }

    /**
     * Returns the _id of this {@link Character}.
     *
     * @return the _id of this {@link Character}
     * @since 1.0.0
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * Sets the _id of this {@link Character} to the specified _id.
     *
     * @param _id the _id to set for this {@link Character}
     * @since 1.0.0
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Returns the name of this {@link Character}.
     *
     * @return the name of this {@link Character}
     * @since 1.0.0
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this {@link Character} to the specified name.
     *
     * @param name the name to set for this {@link Character}
     * @since 1.0.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the primary image of this {@link Character}.
     *
     * @return the primary image of this {@link Character}
     * @since 1.0.0
     */
    public String getPrimaryImage() {
        return primaryImage;
    }

    /**
     * Sets the primary image of this {@link Character} to the specified image.
     *
     * @param primaryImage the primary image to set for this {@link Character}
     * @since 1.0.0
     */
    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    /**
     * Returns other images of this {@link Character}.
     *
     * @return a {@link List} of other images of this {@link Character}
     * @since 1.0.0
     */
    public List<String> getOtherImages() {
        return otherImages;
    }

    /**
     * Sets other images of this {@link Character} to the specified images.
     *
     * @param otherImages a {@link List} of other images to set for this {@link Character}
     * @since 1.0.0
     */
    public void setOtherImages(List<String> otherImages) {
        this.otherImages = otherImages;
    }

    /**
     * Returns the appearances of this {@link Character}.
     *
     * @return a {@link List} of appearances of this {@link Character}
     * @since 1.0.0
     */
    public List<String> getAppearances() {
        return appearances;
    }

    /**
     * Sets the appearances of this {@link Character} to the specified appearances.
     *
     * @param appearances a {@link List} of appearances to set for this {@link Character}
     * @since 1.0.0
     */
    public void setAppearances(List<String> appearances) {
        this.appearances = appearances;
    }

    /**
     * Returns the titles of this {@link Character}.
     *
     * @return a {@link List} of titles of this {@link Character}
     * @since 1.0.0
     */
    public List<String> getTitles() {
        return titles;
    }

    /**
     * Sets the titles of this {@link Character} to the specified titles.
     *
     * @param titles a {@link List} of titles to set for this {@link Character}
     * @since 1.0.0
     */
    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    /**
     * Returns the voice actors for this {@link Character}.
     *
     * @return the {@link VoiceActors} for this {@link Character}
     * @since 1.0.0
     */
    public VoiceActors getVoiceActors() {
        return voiceActors;
    }

    /**
     * Sets the voice actors for this {@link Character} to the specified voice actors.
     *
     * @param voiceActors the {@link VoiceActors} to set for this {@link Character}
     * @since 1.0.0
     */
    public void setVoiceActors(VoiceActors voiceActors) {
        this.voiceActors = voiceActors;
    }

    /**
     * Indicates whether the specified object is "equal to" this {@link Character}. Two {@link Character}s are
     * considered equal if the _id of each {@link Character} is equal to each other.
     *
     * @param object the reference object with which to compare
     * @return true if this {@link Character} is equal to the specified object; false otherwise
     * @since 1.0.0
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Character character = (Character) object;
        return Objects.equals(_id, character._id);
    }

    /**
     * Returns a hash code value for this {@link Character}. This method is supported for the benefit of hash tables
     * such as those provided by HashMap.
     *
     * @return a hash code value for this {@link Character}
     * @since 1.0.0
     */
    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }

    /**
     * Returns a string representation of this {@link Character}.
     *
     * @return a {@link String} representation of this {@link Character}
     * @since 1.0.0
     */
    @Override
    public String toString() {
        return "Character{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", primaryImage='" + primaryImage + '\'' +
                ", otherImages=" + otherImages +
                ", appearances=" + appearances +
                ", titles=" + titles +
                ", voiceActors=" + voiceActors +
                '}';
    }
}
