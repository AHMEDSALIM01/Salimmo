package org.propertyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ExteriorProperty implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
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

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    private void created(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    private void updated(){
        this.updatedAt = LocalDateTime.now();
    }
}
