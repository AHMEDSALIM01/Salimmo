package org.propertyservice.entities;

import lombok.*;
import org.propertyservice.enums.HeatingType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyEnergies extends BaseEntity implements Serializable {
    @OneToOne(mappedBy = "propertyEnergies")
    private Property property;
    @Enumerated(EnumType.STRING)
    private HeatingType heatingType;
    private String hotWater;
    private String electricalInstallation;
    private Double heatingLoads;
    private Double waterLoads;
    private Double electricLoads;

}
