package com.ys.skywingracing.competition.domain.model;

import com.ys.skywingracing.competition.domain.valueObject.AdmissionPercentage;
import com.ys.skywingracing.competition.domain.valueObject.Coordinate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotNull
    @Embedded
    private Coordinate coordinate;

    @Positive
    @Column(nullable = false)
    private Double distance;

    @Positive
    @Column(name = "max_pigeons", nullable = false)
    private Integer maxPigeons;

    @Positive
    @Embedded
    @Column(name = "admission_percentage", nullable = false)
    private AdmissionPercentage admissionPercentage;

    @Column(name = "date_start")
    private LocalDateTime dateStart;

    @Column(name = "date_end")
    private LocalDateTime dateEnd;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;
}
