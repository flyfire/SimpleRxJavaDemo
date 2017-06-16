package com.solarexsoft.simplerxjava;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 16/06/2017
 *    Desc:
 * </pre>
 */

public interface Operator<T, R> extends Func1<Subscrible<? super T>, Subscrible<? super R>> {
}
