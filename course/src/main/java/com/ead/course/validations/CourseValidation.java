package com.ead.course.validations;

import com.ead.course.configs.security.AuthenticationCurrentUserService;
import com.ead.course.dtos.CourseDto;
import com.ead.course.enums.UserType;
import com.ead.course.models.UserModel;
import com.ead.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
import java.util.UUID;

@Component
public class CourseValidation implements Validator {

    @Autowired
    @Qualifier("defaultValidator")
    private Validator validator;

    @Autowired
    UserService userService;


    @Autowired
    AuthenticationCurrentUserService authenticationCurrentUserService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseDto courseDto = (CourseDto) target;
        validator.validate(courseDto, errors);
        if(!errors.hasErrors()){
            validateUserInstructor(courseDto.getUserInstructor(), errors);
        }
    }

    private void validateUserInstructor(UUID userInstructor, Errors errors){
        UUID currentUserId = authenticationCurrentUserService.getCurrentUser().getUserId();
        if(currentUserId.equals(userInstructor)){
            Optional<UserModel> userModelOptional = userService.findById(userInstructor);
            if(!userModelOptional.isPresent()){
                errors.rejectValue("userInstructor", "UserInstructorError", "Instructor not Found");
            }
            if(userModelOptional.get().getUserType().equals(UserType.STUDENT.toString())){
                errors.rejectValue("userInstructor", "UserInstructorError", "User must be instructor or admin");
            }
        }else {
            throw new AccessDeniedException("Forbidden");
        }


       // ResponseEntity<UserDto> responseUserInstructor;
        /*try{
            responseUserInstructor = authUserClient.getOneUserById(userInstructor);
            if(responseUserInstructor.getBody().getUserType().equals(UserType.STUDENT)){
                errors.rejectValue("userInstructor", "userInstructorError", "User must be Instructor or ADMIN");
            }
        }catch(HttpStatusCodeException e){
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                errors.rejectValue("userInstructor", "userInstructorError", "Instructor not Found");
            }
        }*/
    }
}
