package com.solarexsoft.simplerxjava;

import android.os.Handler;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 16/06/2017
 *    Desc:
 * </pre>
 */

public class OnSubscribleMain<T> implements OnSubscrible<T> {
    private Handler mHandler;
    private Observable<T> mSource;

    public OnSubscribleMain(Handler handler, Observable<T> source) {
        mHandler = handler;
        mSource = source;
    }

    @Override
    public void call(final Subscrible<? super T> subscrible) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mSource.subscrible(subscrible);
            }
        });
    }
}
