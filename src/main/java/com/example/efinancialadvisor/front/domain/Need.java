package com.example.efinancialadvisor.front.domain;

import java.util.Objects;

public class Need {

    private String need;
    private int value;

    public Need() {
    }

    public Need(String need, int value) {
        this.need = need;
        this.value = value;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Need)) return false;
        Need need1 = (Need) o;
        return value == need1.value && Objects.equals(need, need1.need);
    }

    @Override
    public int hashCode() {
        return Objects.hash(need, value);
    }
}
