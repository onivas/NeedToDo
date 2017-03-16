package com.example.savino.needtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = ">>>>> TAG: ";

    PublishSubject<Void> mRefresh = PublishSubject.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = Arrays.asList("dive", "hello");

        Observable<List<String>> backendValues = Observable.just(list);

        mRefresh
                .startWith(Observable.just(null))   // this is used to start the chain for the first time without calling onNext
                .withLatestFrom(backendValues, new Func2<Void, List<String>, Void>() {
                    @Override
                    public Void call(Void aVoid, List<String> stringList) {
                        Log.d(TAG,  "withLatestFrom");
                        return null;
                    }
                })
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Log.d(TAG,  list.toString());
                    }
                });

        mRefresh.onNext(null);  // this start the chain again - A kind of refresh way for the user

    }
}
