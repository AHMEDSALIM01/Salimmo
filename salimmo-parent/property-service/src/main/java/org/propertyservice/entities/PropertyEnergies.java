package org.propertyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.enums.HeatingType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyEnergies extends BaseEntity implements Serializable {
    @OneToOne(mappedBy = "propertyEnergies", optional = false)
    private Property property;
    @Enumerated(EnumType.STRING)
    private HeatingType heatingType;
    private String hotWater;
    private String electricalInstallation;
    private Double heatingLoads;
    private Double waterLoads;
    private Double electricLoads;
}
