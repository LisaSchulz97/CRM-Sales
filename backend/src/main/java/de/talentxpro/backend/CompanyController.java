package de.talentxpro.backend;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/company")
@RestController
public class CompanyController {
   private final CompanyService companyService;


    @GetMapping
    public List<Company> getCompanies() {
        return companyService.listCompanies();
    }

    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable String id) {
        return ResponseEntity.ok(companyService.findCompanyById(id));
    }

    @PostMapping
    public Company addCompany(Company company) {
        return companyService.addCompany(company);
    }
}
