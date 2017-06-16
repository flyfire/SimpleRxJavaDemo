package com.solarexsoft.simplerxjavademo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.solarexsoft.simplerxjava.Func1;
import com.solarexsoft.simplerxjava.Observable;
import com.solarexsoft.simplerxjava.OnSubscrible;
import com.solarexsoft.simplerxjava.Subscrible;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable.create(new OnSubscrible<String>() {
            @Override
            public void call(Subscrible<? super String> subscrible) {
                Log.d("Solarex", "1");
                subscrible.onNext("Hello,world");
                Log.d("Solarex", "2");
                Log.d("Solarex", "current thread: " + Thread.currentThread().getName());
            }
        }).map(new Func1<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                Log.d("Solarex", "3");
                Log.d("Solarex", s);
                Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.ic_launcher);
                Log.d("Solarex", "4");
                return bitmap;
            }
        }).subscribleOnMain().subscrible(new Subscrible<Bitmap>() {
            @Override
            public void onNext(Bitmap bitmap) {
                Log.d("Solarex", "5");
                Log.d("Solarex", bitmap.toString());
            }
        });
    }
}
