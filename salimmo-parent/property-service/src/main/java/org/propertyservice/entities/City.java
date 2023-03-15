package org.propertyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<PropertyLocation> propertyLocations;
    private String latitude;
    private String longitude;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
