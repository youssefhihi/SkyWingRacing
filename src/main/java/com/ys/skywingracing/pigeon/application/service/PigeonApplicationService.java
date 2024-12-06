package com.ys.skywingracing.pigeon.application.service;

import com.ys.skywingracing.pigeon.domain.model.Pigeon;
import com.ys.skywingracing.pigeon.domain.valueObject.BandNumber;

import java.util.UUID;

public interface PigeonApplicationService {
    Pigeon findPigeonById (UUID value );
    Pigeon findPigeonByBandNumber ( BandNumber value );
}
