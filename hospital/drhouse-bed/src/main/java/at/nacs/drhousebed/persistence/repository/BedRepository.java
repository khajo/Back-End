package at.nacs.drhousebed.persistence.repository;

import at.nacs.drhousebed.persistence.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BedRepository extends MongoRepository<Patient,String> {
}
