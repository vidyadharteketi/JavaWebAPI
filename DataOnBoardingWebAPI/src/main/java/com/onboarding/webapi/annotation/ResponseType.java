package com.onboarding.webapi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseType {

    /**
     * Specifies response type
     * @return Class for identifying response type
     */
    @SuppressWarnings("rawtypes")
	public Class value();

    /**
     *
     * @return <code>true</code> if response with single entity differs
     * from response with multiple entities.
     */
    public boolean supportSingularResponse() default false;
}

