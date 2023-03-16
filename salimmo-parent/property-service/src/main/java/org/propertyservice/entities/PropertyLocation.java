package org.propertyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyLocation extends BaseEntity implements Serializable {
    @OneToOne
    private Property property;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;
    private int houseNumber;
    private String street;
    private String latitude;
    private String longitude;
}
