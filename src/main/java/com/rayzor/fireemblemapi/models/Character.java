package com.rayzor.fireemblemapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
}
