package at.nacs.drhousebed;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BedRepository extends MongoRepository<Patient,String> {
}
