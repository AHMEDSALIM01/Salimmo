package org.propertyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "property_owner")
@SQLDelete(sql = "UPDATE property_owner SET isDeleted = true")
@Where(clause = "isDeleted=false")
public class PropertyOwner extends BaseEntity implements Serializable {
    @OneToMany(mappedBy = "owner")
    private Set<Property> properties;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;

    private String createdBy;

    private String updatedBy;

    private String deletedBy;
    private Boolean isDeleted=Boolean.FALSE;
    private LocalDateTime deletedAt;
    @PreRemove
    public void deletedAt(){
        this.deletedAt = LocalDateTime.now();
    }
}
