package org.propertyservice.validators;

import lombok.Getter;
import org.propertyservice.dto.PropertySurfaceDto;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SurfaceValidator {
    private String message;
    public Boolean isValid(PropertySurfaceDto propertySurfaceDto){
        if(propertySurfaceDto.getSquareArea() <30){
            this.message = "Invalid Surface";
            return false;
        }
        return true;
    }
}
