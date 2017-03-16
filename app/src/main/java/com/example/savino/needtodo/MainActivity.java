package com.example.savino.needtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = ">>>>> TAG: ";

    PublishSubject<String> mUserInput = PublishSubject.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = Arrays.asList("dive", "hello");

        Observable<List<String>> backendValues = Observable.just(list);

        mUserInput
                .withLatestFrom(backendValues, new Func2<String, List<String>, String>() {
                    @Override
                    public String call(String s, List<String> stringList) {
                        Log.d(TAG, "withLatestFrom " + s);
                        return s.toLowerCase();
                    }
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        Log.d(TAG, "filter " + s);
                        return list.contains(s);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.d(TAG, "subscribe " + s);
                    }
                });

        mUserInput.onNext("dede");
        mUserInput.onNext("dive");
        mUserInput.onNext("hello");

    }
}
