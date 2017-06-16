package com.solarexsoft.simplerxjava;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 16/06/2017
 *    Desc:
 * </pre>
 */

public class OperatorMap<T,R> implements Operator<R, T> {
    Func1<? super T, ? extends R> transform;

    public OperatorMap(Func1<? super T, ? extends R> transform){
        this.transform = transform;
    }
    @Override
    public Subscrible<? super T> call(Subscrible<? super R> subscrible) {
        return new MapSubscrible<>(subscrible, transform);
    }


    private class MapSubscrible<T, R> extends Subscrible<T>{
        private Subscrible<? super R> actual;
        private Func1<? super T, ? extends R> transform;

        public MapSubscrible(Subscrible<? super R> actual, Func1<? super T, ? extends R>
                transform) {
            this.actual = actual;
            this.transform = transform;
        }

        @Override
        public void onNext(T t) {
            R r = transform.call(t);
            actual.onNext(r);
        }
    }
}
