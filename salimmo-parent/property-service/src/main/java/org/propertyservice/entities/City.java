package org.propertyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class City extends BaseEntity implements Serializable{
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<PropertyLocation> propertyLocations;
    @Column(nullable = false)
    private String latitude;
    @Column(nullable = false)
    private String longitude;
}
