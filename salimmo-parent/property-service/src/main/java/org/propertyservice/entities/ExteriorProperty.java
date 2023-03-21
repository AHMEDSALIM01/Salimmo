package org.propertyservice.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExteriorProperty extends BaseEntity implements Serializable{
    @OneToOne(mappedBy = "exteriorProperty",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},orphanRemoval = true)
    private Property property;
    @DateTimeFormat(pattern = "yyyy")
    private Date yearConstruction;
    private String windows;
    private String shutter;
    private String roof;
    private Boolean sewer;
    private String condition;
    private Boolean existingGarage;
    private int nbrOfGarage;
    private String fence;
    private Boolean terrace;
    private Boolean piscine;
}
