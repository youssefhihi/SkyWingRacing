package com.ys.skywingracing.pigeon.domain.service.impl;

import com.ys.skywingracing.pigeon.application.dto.request.PigeonRequestDTO;
import com.ys.skywingracing.pigeon.application.dto.response.PigeonResponseDTO;
import com.ys.skywingracing.pigeon.application.mapper.PigeonMapper;
import com.ys.skywingracing.pigeon.application.service.PigeonApplicationService;
import com.ys.skywingracing.pigeon.domain.exception.NotFoundException;
import com.ys.skywingracing.pigeon.domain.model.Pigeon;
import com.ys.skywingracing.pigeon.domain.service.PigeonDomainService;
import com.ys.skywingracing.pigeon.domain.valueObject.BandNumber;
import com.ys.skywingracing.pigeon.infrastructure.repository.PigeonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultPigeonDomainService implements PigeonDomainService, PigeonApplicationService {
    private final PigeonRepository repository;
    private final PigeonMapper mapper;

    @Override
    public PigeonResponseDTO create (PigeonRequestDTO dto ) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public List<PigeonResponseDTO> findAll () {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public PigeonResponseDTO getSeasonById ( UUID id ) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("pigeon", id.toString()));
    }

    @Override
    public Pigeon findPigeonById (UUID id ) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("pigeon", id.toString()));
    }

    @Override
    public Pigeon findPigeonByBandNumber(BandNumber value ) {
        return repository.findByBandNumber(value).orElseThrow(() -> new NotFoundException("pigeon", value.toString()));
    }

    @Override
    public Boolean deletePigeonById ( UUID id ) {
        Pigeon pigeon = findPigeonById(id);
        repository.delete(pigeon);
        return true;
    }
}
