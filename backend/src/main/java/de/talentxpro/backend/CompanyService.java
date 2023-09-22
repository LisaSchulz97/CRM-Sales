package de.talentxpro.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepo companyRepo;

    public List<Company> listCompanies() {
        return companyRepo.findAll();
    }

    public Company addCompany(Company company) {
        return companyRepo.save(company);
    }
}
