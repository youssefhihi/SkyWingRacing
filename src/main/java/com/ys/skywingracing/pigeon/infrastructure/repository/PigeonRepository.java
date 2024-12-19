package com.ys.skywingracing.pigeon.infrastructure.repository;

import com.ys.skywingracing.pigeon.domain.model.Pigeon;
import com.ys.skywingracing.pigeon.domain.valueObject.BandNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PigeonRepository extends JpaRepository<Pigeon, UUID> {
    Optional<Pigeon> findByBandNumber(BandNumber bandNumber);

}
