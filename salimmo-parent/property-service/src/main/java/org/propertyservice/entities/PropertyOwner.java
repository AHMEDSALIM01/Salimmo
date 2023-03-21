package org.propertyservice.entities;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "property_owner")
@Where(clause = "deleted=false")
public class PropertyOwner extends BaseEntity implements Serializable {
    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST})
    private Set<Property> properties;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;

    private String createdBy;

    private String updatedBy;

    private String deletedBy;
    private Boolean deleted=false;
    private LocalDateTime deletedAt;
}
