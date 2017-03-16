package com.example.savino.needtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
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

        Observable<Void> withLatestFrom = mRefresh
                .withLatestFrom(backendValues, new Func2<Void, List<String>, Void>() {
                    @Override
                    public Void call(Void aVoid, List<String> stringList) {
                        Log.d(TAG, "withLatestFrom");
                        return null;
                    }
                }).share(); // this is useful when i do a network call and share the result to all the subscriber instead to call again the network

        withLatestFrom
                .subscribe(aVoid -> {
                    Log.d(TAG, "1 " + list.toString());
                });

        withLatestFrom
                .subscribe(aVoid -> {
                    Log.d(TAG, "2 " +list.toString());
                });

        mRefresh.onNext(null);

    // D/>>>>> TAG:: withLatestFrom     <--- here is onNext
    // D/>>>>> TAG:: 1 [dive, hello]
    // D/>>>>> TAG:: 2 [dive, hello]    <--- this does not call withLatestFrom
    }
}
