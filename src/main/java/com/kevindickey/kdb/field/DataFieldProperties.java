package com.kevindickey.kdb.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @ interface DataFieldProperties {
    String Name();
    PostgreSqlDataType Type();
    long Length() default 0;
    boolean IsNullable() default true;
    boolean IsPrimaryKey() default false;
 }