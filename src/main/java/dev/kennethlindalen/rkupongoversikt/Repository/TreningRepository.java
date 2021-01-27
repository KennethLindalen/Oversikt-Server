package dev.kennethlindalen.rkupongoversikt.Repository;

import dev.kennethlindalen.rkupongoversikt.Models.Trening;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreningRepository extends MongoRepository<Trening, String> {

}
