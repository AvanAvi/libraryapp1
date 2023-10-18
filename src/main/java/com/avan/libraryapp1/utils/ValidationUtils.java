package com.avan.libraryapp1.utils;

import java.util.Date;
import java.util.Objects;

public class ValidationUtils {

    /**
     * Validates if the provided object is not null.
     *
     * @param obj The object to validate.
     * @param fieldName The name of the field being validated, for a more descriptive error.
     * @throws IllegalArgumentException if the object is null.
     */
    public static void validateNotNull(Object obj, String fieldName) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException(fieldName + " should not be null");
        }
    }

    /**
     * Validates if the provided date is in the past or present.
     *
     * @param date The date to validate.
     * @param dateFieldName The name of the date field being validated, for a more descriptive error.
     * @throws IllegalArgumentException if the date is in the future or null.
     */
    public static void validatePastOrPresent(Date date, String dateFieldName) {
        if (Objects.isNull(date)) {
            throw new IllegalArgumentException(dateFieldName + " should not be null");
        }
        if (date.after(new Date())) {
            throw new IllegalArgumentException(dateFieldName + " should be in the past or present");
        }
    }
    
    /**
     * Validates if the provided ID (Long) is not null and is a positive value.
     *
     * @param id The ID to validate.
     * @param idFieldName The name of the ID field being validated, for a more descriptive error.
     * @throws IllegalArgumentException if the ID is null or non-positive.
     */
    public static void validateId(Long id, String idFieldName) {
        validateNotNull(id, idFieldName);
        if (id <= 0) {
            throw new IllegalArgumentException(idFieldName + " should be a positive value");
        }
    }
}
