package com.solarexsoft.simplerxjava;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 16/06/2017
 *    Desc:
 * </pre>
 */

public abstract class Subscrible<T> {
    public abstract void onNext(T t);
}
