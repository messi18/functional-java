package com.lance.functional;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalUtils {
    public static <A,B,C> Function<B,C> partial1(A a, BiFunction<A,B,C> f) {
        return (B b) -> f.apply(a,b);
    }

    public static<A,B,C>  Function<A,Function<B,C>> curry(BiFunction<A,B,C> f) {
        return (A a) -> (B b) -> f.apply(a,b);
    }
    public static <A,B,C> BiFunction<A,B,C> uncurry(Function<A,Function<B,C>> f) {
        return (A a, B b) -> f.apply(a).apply(b);
    }

    public static <A,B,C> Function<A,C> compose(Function<B,C> h, Function<A,B> g) {
        return (a) -> g.andThen(h).apply(a);
    }

    public static <A,B,C> Optional<C> map2(Optional<A> a, Optional<B> b, BiFunction<A,B,C> f) {
        return a.flatMap(x -> b.map(y  -> f.apply(x,y)));
    }

    // test
    public static double test(int a, int b) {
        return a*1.0/b;
    }
    public static void main(String[] args) {
        Function<Integer, Integer> integerIntegerFunction = partial1(1, (Integer a, Integer b) -> a + b);

//        System.out.println(integerIntegerFunction.andThen());
        Optional<Double> aDouble = map2(Optional.of(2), Optional.of(3), FunctionalUtils::test);
        System.out.println(integerIntegerFunction.apply(3));
        System.out.println(integerIntegerFunction.apply(8));
        System.out.println(aDouble.orElse(0.0));
    }
}
