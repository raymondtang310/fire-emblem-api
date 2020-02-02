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
 * @since 1.0
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

    public Character() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    public List<String> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(List<String> otherImages) {
        this.otherImages = otherImages;
    }

    public List<String> getAppearances() {
        return appearances;
    }

    public void setAppearances(List<String> appearances) {
        this.appearances = appearances;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public VoiceActors getVoiceActors() {
        return voiceActors;
    }

    public void setVoiceActors(VoiceActors voiceActors) {
        this.voiceActors = voiceActors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(_id, character._id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }
}
