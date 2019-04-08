package at.nacs.drhousebed.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BedRepository extends MongoRepository<Patient,String> {
}
