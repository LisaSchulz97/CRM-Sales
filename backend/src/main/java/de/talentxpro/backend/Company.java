package de.talentxpro.backend;

import org.springframework.data.annotation.Id;

public record Company(
        @Id
        String id,
        String website,
        String name,
        String telephone,
        String address,
        String person,
        String contacted,
        String reminder,
        String comment,
        String email
) {
}
