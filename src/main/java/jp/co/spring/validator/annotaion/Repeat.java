package jp.co.spring.validator.annotaion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import jp.co.spring.validator.RepeatValidator;

@Documented
@Constraint(validatedBy = RepeatValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Repeat {
    String message() default "既存のIDは登録できません.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}