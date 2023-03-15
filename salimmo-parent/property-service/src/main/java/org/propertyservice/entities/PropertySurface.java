package org.propertyservice.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PropertySurface implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "propertySurface", optional = false)
    private Property property;

}
