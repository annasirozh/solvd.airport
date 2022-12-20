package com.solvd.app.functionalInterface;

@FunctionalInterface
public interface MFunction <T, R> {
    R apply(T t);
}
