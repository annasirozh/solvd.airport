package com.solvd.app.functionalInterface;

@FunctionalInterface
public interface Consumer <T> {
    void accept(T t);
}
