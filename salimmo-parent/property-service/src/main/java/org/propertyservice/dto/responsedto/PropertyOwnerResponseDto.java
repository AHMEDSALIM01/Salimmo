package org.propertyservice.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.propertyservice.entities.Property;

import javax.persistence.Column;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyOwnerResponseDto {
    private Set<PropertyResponseDto> properties;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
}
