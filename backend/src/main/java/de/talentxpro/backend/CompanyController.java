package de.talentxpro.backend;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public Company addCompany() {
        var company = new Company(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        );
        return companyService.addCompany(company);
    }
}
