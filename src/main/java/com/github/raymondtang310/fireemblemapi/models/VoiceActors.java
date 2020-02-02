package com.github.raymondtang310.fireemblemapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

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
 * @since 1.0
 */
@JsonInclude(Include.NON_NULL)
public class VoiceActors {
    private List<String> english;
    private List<String> japanese;

    public VoiceActors() {
    }

    public List<String> getEnglish() {
        return english;
    }

    public void setEnglish(List<String> english) {
        this.english = english;
    }

    public List<String> getJapanese() {
        return japanese;
    }

    public void setJapanese(List<String> japanese) {
        this.japanese = japanese;
    }
}
