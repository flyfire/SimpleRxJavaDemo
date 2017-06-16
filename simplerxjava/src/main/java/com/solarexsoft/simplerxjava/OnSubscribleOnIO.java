package com.solarexsoft.simplerxjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 16/06/2017
 *    Desc:
 * </pre>
 */

public class OnSubscribleOnIO<T> implements OnSubscrible<T> {
    private static ExecutorService sExecutorService = Executors.newCachedThreadPool();

    Observable<T> mSource;

    public OnSubscribleOnIO(Observable<T> source) {
        mSource = source;
    }

    @Override
    public void call(final Subscrible<? super T> subscrible) {
        sExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                mSource.subscrible(subscrible);
            }
        });
    }
}
