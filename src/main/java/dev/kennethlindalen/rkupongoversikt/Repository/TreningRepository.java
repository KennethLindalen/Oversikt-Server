package dev.kennethlindalen.rkupongoversikt.Repository;

import dev.kennethlindalen.rkupongoversikt.Models.TreningDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreningRepository extends MongoRepository<TreningDocumentModel, String> {

}
