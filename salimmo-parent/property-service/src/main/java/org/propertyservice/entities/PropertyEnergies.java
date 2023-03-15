package org.propertyservice.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PropertyEnergies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "propertyEnergies", optional = false)
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
