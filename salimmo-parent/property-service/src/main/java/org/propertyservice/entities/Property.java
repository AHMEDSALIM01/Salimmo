package org.propertyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.enums.PropertyCategory;
import org.propertyservice.enums.PropertyType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID ref;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private PropertyOwner owner;
    @Enumerated(value = EnumType.STRING)
    private PropertyCategory category;
    @Enumerated(value = EnumType.STRING)
    private PropertyType type;
    @OneToOne
    private PropertyLocation propertyLocation;
    @OneToOne
    private InnerProperty innerProperty;
    @OneToOne
    @Transient
    private PropertySurface propertySurface;
    @OneToOne
    @Transient
    private PropertyEnergies propertyEnergies;
    @OneToOne
    private ExteriorProperty exteriorProperty;
    private String title;
    private String description;
    private Double fees;
    private Double netPrice;
    private Byte [] images;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
