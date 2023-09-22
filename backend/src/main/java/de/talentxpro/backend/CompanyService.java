package de.talentxpro.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Company findCompanyById(String id) {
        Optional<Company> company = companyRepo.findById(id);

        if (company.isEmpty()) {
            throw new NoSuchElementException("Company with id: " + id + " not found");
        }

        return company.get();
    }
}
