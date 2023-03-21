package org.propertyservice.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertyLocation extends BaseEntity implements Serializable {
    @OneToOne(mappedBy = "propertyLocation")
    private Property property;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;
    private int houseNumber;
    private String street;
    private String latitude;
    private String longitude;
}
