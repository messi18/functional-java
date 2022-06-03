package com.lance.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalUtils {
    public static <A,B,C> Function<B,C> partial1(A a, BiFunction<A,B,C> f) {
        return (B b) -> f.apply(a,b);
    }
}
