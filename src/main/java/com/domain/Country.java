package com.domain;

public enum Country {
    US("America"),
    UK("United Kingdom"),
    UA("Ukraine");

    public final String name;

    Country(String name) {
        this.name = name;
    }
}
