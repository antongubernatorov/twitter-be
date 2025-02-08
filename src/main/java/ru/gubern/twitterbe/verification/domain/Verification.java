package ru.gubern.twitterbe.verification.domain;

import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Verification {

    private boolean status = false;
    private OffsetDateTime startedAt;
    private OffsetDateTime endsAt;

    @Enumerated
    private VerificationPlanType planType;
}
