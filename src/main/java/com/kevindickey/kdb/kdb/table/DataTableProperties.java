package com.kevindickey.kdb.kdb.table;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @ interface DataTableProperties {
    String Name();
 }