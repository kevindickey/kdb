package com.kevindickey.kdb.field;


public class DataField<T> {
    private T value;

    public T getValue(){
        return this.value;
    };
    public void setValue(T val) {
        this.value = val;
    }
}
