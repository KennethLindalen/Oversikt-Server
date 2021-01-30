package dev.kennethlindalen.rkupongoversikt.Repository;

import dev.kennethlindalen.rkupongoversikt.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findUserByUsername(String Username);
    public User findPasswordByUsername(String Username);
}
