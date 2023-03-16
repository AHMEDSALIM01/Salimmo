package org.propertyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
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
@Data
@ToString
@Table(name = "property")
@SQLDelete(sql = "UPDATE property SET isDeleted = true")
@Where(clause = "isDeleted=false")
public class Property extends BaseEntity implements Serializable {
    private UUID ref;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private PropertyOwner owner;
    @Enumerated(EnumType.STRING)
    private PropertyCategory category;
    @Enumerated(EnumType.STRING)
    private PropertyType type;
    @OneToOne
    private PropertyLocation propertyLocation;
    @OneToOne
    private InnerProperty innerProperty;
    @OneToOne
    private PropertySurface propertySurface;
    @OneToOne
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
    private Boolean isDeleted;
    private LocalDateTime deletedAt;

    @PreRemove
    public void deletedAt(){
        this.deletedAt = LocalDateTime.now();
    }
}
