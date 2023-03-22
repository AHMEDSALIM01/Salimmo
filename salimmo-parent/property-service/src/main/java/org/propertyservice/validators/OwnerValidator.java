package org.propertyservice.validators;

import lombok.Getter;
import org.propertyservice.dto.PropertyOwnerDto;
import org.springframework.stereotype.Component;

@Component
@Getter
public class OwnerValidator {
    private String message;
    public Boolean isValid(PropertyOwnerDto propertyOwnerDto){
        if(propertyOwnerDto.getEmail() == null){
            this.message = "Email is required !";
            return false;
        }
        if(!propertyOwnerDto.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            this.message = "Email is invalid ,required format :exemple@email.com";
            return false;
        }
        if (propertyOwnerDto.getFirstName() == null ){
            this.message =  "Firstname is required !";
            return false;
        }
        if (!propertyOwnerDto.getFirstName().matches("([A-ZÀ-ÿ])+[-,a-z. ']{3,15}$")){
            this.message = "Firstname is invalid";
            return false;
        }
        if(propertyOwnerDto.getLastName() == null){
            this.message = "Lastname is required !";
            return false;
        }
        if(!propertyOwnerDto.getLastName().matches("([A-ZÀ-ÿ])+[-,a-z. ']{3,15}$")){
            this.message = "Lastname is invalid";
            return false;
        }
        if (propertyOwnerDto.getPhone() == null){
            this.message = "Phone is required !";
            return false;
        }
        if (!propertyOwnerDto.getPhone().matches("^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$")){
            this.message = "Phone number is invalid";
            return false;
        }

        this.message = "";
        return true;
    }
}
