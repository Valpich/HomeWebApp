package dev.valentinpichavant.validators;

/**
 * Created by valentinpichavant on 10/21/16.
 */

import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class ValidatorUtil {

    public static void addValidationError(String field, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addNode(field)
                .addConstraintViolation();
    }

    public static Object getFieldValue(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field f = object.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(object);
    }
}