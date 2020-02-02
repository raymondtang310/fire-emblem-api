package com.github.raymondtang310.fireemblemapi.repositories;

import com.github.raymondtang310.fireemblemapi.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * CharactersRepository is a {@link MongoRepository} interface which provides methods for querying the
 * <code>characters</code> collection in the <code>fireEmblemData</code> MongoDB database.
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0
 */
public interface CharactersRepository extends MongoRepository<Character, String> {
    /**
     * Finds {@link Character}s that have the specified name. Returns an empty {@link List} if no {@link Character}s are
     * found.
     *
     * @param name the name of the {@link Character}(s) to search for
     * @return a {@link List} of {@link Character}s that have the specified name
     * @since 1.0
     */
    List<Character> findByName(String name);
}
