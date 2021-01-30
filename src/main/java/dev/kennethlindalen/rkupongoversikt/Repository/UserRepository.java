package dev.kennethlindalen.rkupongoversikt.Repository;

import dev.kennethlindalen.rkupongoversikt.Models.UserDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocumentModel, String> {

    public UserDocumentModel findUserByUsername(String Username);
    public UserDocumentModel findPasswordByUsername(String Username);
}
