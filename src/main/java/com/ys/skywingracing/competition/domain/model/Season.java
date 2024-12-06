package com.ys.skywingracing.competition.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

//    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<SeasonPigeon> seasonPigeons = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(
//            name = "season_competition",
//            joinColumns = @JoinColumn(name = "season_id"),
//            inverseJoinColumns = @JoinColumn(name = "competition_id")
//    )
//    private List<Competition> competitions = new ArrayList<>();

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate  // Ensure this is set automatically during the entity's lifecycle
    private LocalDateTime createdDate;

    // Default constructor for JPA
    public Season() {
    }

}
