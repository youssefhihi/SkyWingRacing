package com.ys.skywingracing.pigeon.api;

import com.ys.skywingracing.common.api.ResponseApi;
import com.ys.skywingracing.pigeon.application.dto.request.PigeonRequestDTO;
import com.ys.skywingracing.pigeon.application.dto.response.PigeonResponseDTO;
import com.ys.skywingracing.pigeon.domain.service.PigeonDomainService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/private/user/pigeons")
@RequiredArgsConstructor
class PigeonController {

    private final PigeonDomainService service;

    @PostMapping
    public ResponseEntity<ResponseApi<PigeonResponseDTO>> create (@Valid @RequestBody PigeonRequestDTO dto ) {
        PigeonResponseDTO createdPigeon = service.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseApi.created(createdPigeon, "Pigeon created successfully"));
    }

    @GetMapping
    public ResponseEntity<ResponseApi<List<PigeonResponseDTO>>> findAll () {
        List<PigeonResponseDTO> pigeonResponse = service.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseApi.success(pigeonResponse, "Successfully retrieved the list of pigeons."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseApi<PigeonResponseDTO>> findById ( @Valid @PathVariable String id ) {
        PigeonResponseDTO pigeonResponse = service.getSeasonById(UUID.fromString(id));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseApi.success(pigeonResponse, "Successfully retrieved the pigeon by id."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete ( @Valid @PathVariable String id ) {
        Boolean dd = service.deletePigeonById(UUID.fromString(id));
        if (dd) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pigeon deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Pigeon could not be deleted.");
    }
}
