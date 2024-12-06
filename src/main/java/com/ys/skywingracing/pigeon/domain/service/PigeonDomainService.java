package com.ys.skywingracing.pigeon.domain.service;

import com.ys.skywingracing.pigeon.application.dto.request.PigeonRequestDTO;
import com.ys.skywingracing.pigeon.application.dto.response.PigeonResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PigeonDomainService {
    PigeonResponseDTO create (PigeonRequestDTO dto );
    List<PigeonResponseDTO> findAll();
    PigeonResponseDTO getSeasonById ( UUID value );
    Boolean deletePigeonById ( UUID value );


}
