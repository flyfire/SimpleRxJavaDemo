package com.solarexsoft.simplerxjava;

import android.os.Handler;
import android.os.Looper;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 16/06/2017
 *    Desc:
 * </pre>
 */

public class Observable<T> {
    private OnSubscrible<T> mOnSubscrible;

    private Observable(OnSubscrible<T> onSubscrible) {
        this.mOnSubscrible = onSubscrible;
    }

    public static <T> Observable<T> create(OnSubscrible<T> onSubscrible) {
        return new Observable<T>(onSubscrible);
    }

    public void subscrible(Subscrible<? super T> subscrible) {
        mOnSubscrible.call(subscrible);
    }

    public <R> Observable<R> map(Func1<? super T, ? extends R> func1) {
        return lift(new OperatorMap<>(func1));
    }

    private <R> Observable<R> lift(OperatorMap<T, R> trOperatorMap) {
        return new Observable<>(new OnSubscribleLift<>(mOnSubscrible, trOperatorMap));
    }

    public Observable<T> subscribleOnIO(){
        return create(new OnSubscribleOnIO<T>(this));
    }

    public Observable<T> subscribleOnMain(){
        return create(new OnSubscribleMain<T>(new Handler(Looper.getMainLooper()), this));
    }

}
