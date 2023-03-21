package org.propertyservice.entities;


import lombok.*;
import org.hibernate.annotations.Where;
import org.propertyservice.enums.PropertyCategory;
import org.propertyservice.enums.PropertyType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "property")
@Where(clause = "deleted=false")
public class Property extends BaseEntity implements Serializable {
    private UUID ref;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private PropertyOwner owner;
    @Enumerated(EnumType.STRING)
    private PropertyCategory category;
    @Enumerated(EnumType.STRING)
    private PropertyType type;
    @OneToOne
    //@JsonIgnoreProperties("property")
    private PropertyLocation propertyLocation;
    @OneToOne
    //@JsonIgnoreProperties("property")
    private InnerProperty innerProperty;
    @OneToOne
    //@JsonIgnoreProperties("property")
    private PropertySurface propertySurface;
    @OneToOne
    //@JsonIgnoreProperties("property")
    private PropertyEnergies propertyEnergies;
    @OneToOne
    //@JsonIgnoreProperties("property")
    private ExteriorProperty exteriorProperty;
    private String title;
    private String description;
    private Double fees;
    private Double netPrice;
    private Byte [] images;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Boolean deleted=false;
    private LocalDateTime deletedAt;

    @PostPersist
    private void generateRefer(){
        this.ref = UUID.randomUUID();
    }
}
