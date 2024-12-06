package com.ys.skywingracing.pigeon.domain.model;

import com.ys.skywingracing.pigeon.domain.enums.Gender;
import com.ys.skywingracing.pigeon.domain.valueObject.BandNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "pigeons", uniqueConstraints = {
        @UniqueConstraint(columnNames = "band_number")
})
public class Pigeon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "band_number", nullable = false, unique = true))
    })
    private BandNumber bandNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Positive
    @Column(nullable = false)
    private double age;

    @NotBlank
    @Column(nullable = false)
    private String color;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
