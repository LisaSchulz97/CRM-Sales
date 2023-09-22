package de.talentxpro.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepo extends MongoRepository<Company, String> {
}
