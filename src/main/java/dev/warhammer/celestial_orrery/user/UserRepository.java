package dev.warhammer.celestial_orrery.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);

    long count();

}
