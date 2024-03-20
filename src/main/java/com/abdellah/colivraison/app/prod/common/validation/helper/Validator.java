package com.abdellah.colivraison.app.prod.common.validation.helper;

import jakarta.validation.ConstraintValidatorContext;
import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Component
@Data
public class Validator<T> {

    private String propertyName;
    private int min;
    private int max;
    private int minLength;
    private int maxLength;
    private int Length;
    private Pattern pattern;

    private ConstraintValidatorContext context;


    private void addConstraintViolation(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }


    public boolean isNull(T value) {
        if (value != null) return false;
        addConstraintViolation(context, propertyName + " ne doit pas être null");
        return true;
    }

    public boolean isBoolean(String value) {

        if ((value.equals("true") || value.equals("false") || (value.equals("1") || value.equals("0")))) return true;

        addConstraintViolation(context, propertyName + " doit être un boolean");
        return false;

    }


    public boolean isNumber(T value) {
        if (NumberUtils.isCreatable(String.valueOf(value))) return true;
        addConstraintViolation(context, propertyName + " doit être un nombre");
        return false;
    }

    public boolean isPositive(Double value) {
        if (value < 0) {
            addConstraintViolation(context, propertyName + " doit être positif");
            return true;
        }
        return false;
    }

    public boolean isBiggerThan(Double value) {
        if (value < min && min != -1) {
            addConstraintViolation(context, propertyName + " doit être supérieur à " + min);
            return true;
        }
        return false;
    }

    public boolean isYoungerThan(Double value) {
        if (value > max && max != -1) {
            addConstraintViolation(context, propertyName + " doit être inférieur à " + max);
            return false;
        }
        return true;
    }

    public boolean isInteger(String value, ConstraintValidatorContext context) {
        if (value.contains(".")) {
            addConstraintViolation(context, propertyName + " doit être un entier");
            return false;
        }
        return true;
    }

    public boolean isEmpty(String value) {
        if (value.isEmpty()) {
            addConstraintViolation(context, propertyName + " ne doit pas être vide");
            return false;
        }
        return true;
    }


    public boolean isTallerThan(String value) {
        if (String.valueOf(value).length() < minLength) {
            addConstraintViolation(context, propertyName + " doit être supérieur à " + minLength + " caractères");
            return false;
        }
        return true;
    }

    public boolean isLengthEqual(String string) {
        if (string.length() != Length) {
            addConstraintViolation(context, propertyName + " doit être de longueur " + Length);
            return false;
        }
        return true;
    }

    public boolean isUUidFormat(String value) {
        try {
            UUID.fromString(value);
        } catch (IllegalArgumentException ex) {
            addConstraintViolation(context, propertyName + " doit être un UUID like this : 123e4567-e89b-12d3-a456-426614174000");
            return false;
        }
        return true;
    }

    public boolean isEmptyList(List<?> value) {
        if (!value.isEmpty()) return false;
        addConstraintViolation(context, propertyName + " ne doit pas être vide");
        return true;
    }

    public boolean isEmptyItems(List<String> strings) {
        for (String string : strings) {
            if (string.isEmpty()) {
                addConstraintViolation(context, propertyName + ": un des éléments ne doit pas être vide");
                return false;
            }
        }
        return true;
    }

    public boolean isLengthItemsEqual(List<String> strings) {
        boolean result = true;
        for (String string : strings) {
            if (string.length() != Length) {
                addConstraintViolation(context, propertyName + " ( " + string + " ) doit être de longueur " + Length);
                result = false;
            }
        }
        return result;
    }

    public boolean isPhoneItems(List<String> strings) {
        boolean result = true;
        for (String string : strings) {
            result = isPhone(string);
        }
        return result;
    }

    private boolean isPhone(String string) {
        if (!string.startsWith("06") && !string.startsWith("07") && !string.startsWith("05")) {
            addConstraintViolation(context, propertyName + " ( " + string + " ) doit commencer par 06 ou 07 ou 05");
            return false;
        }
        return true;
    }

    public boolean isNumberItems(List<String> strings) {

        boolean result = true;
        String tempPhone;
        for (String string : strings) {
            tempPhone = string.replaceFirst("^0", "");
            if (!NumberUtils.isCreatable(tempPhone)) {
                addConstraintViolation(context, propertyName + " ( " + string + " ) doit être un nombre");
                result = false;
            }
        }
        return result;
    }

    public boolean isIntegerItems(List<String> strings) {

        boolean result = true;
        for (String string : strings) {
            if (string.contains(".")) {
                addConstraintViolation(context, propertyName + " ( " + string + " ) doit être un entier");
                result = false;
            }
        }
        return result;
    }

    public boolean isDuplicateItems(List<String> strings) {
        Map<String, Long> frequencyMap = strings.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequencyMap.entrySet().stream()
                .noneMatch(entry -> {
                    if (entry.getValue() > 1) {
                        addConstraintViolation(context, propertyName + " ( " + entry.getKey() + " ) est dupliqué");
                        return true;
                    }
                    return false;
                });
    }


    public boolean isPattern(String value, String patternName, String helpMessage) {
        if (pattern.matcher(value).matches()) return true;

        addConstraintViolation(context, propertyName + " doit être un " + patternName + " valide : ( " + helpMessage + " )");
        return false;
    }
}
