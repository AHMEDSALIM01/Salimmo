package org.propertyservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
