package com.example.savino.needtodo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.savino.needtodo.databinding.ActivityMainBinding;
import com.example.savino.needtodo.model.Stargazers;
import com.example.savino.needtodo.networking.ApiManagerImpl;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = ">>>>>> RETROFIT:";
    private ActivityMainBinding mBinding;
    private ApiManagerImpl mApiManager;

    CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mApiManager = new ApiManagerImpl();

        Subscription subscribe = mApiManager.listStargazers("onivas", "MenuAnimation")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Stargazers>>() {
                    @Override
                    public void call(List<Stargazers> stargazerses) {
                        if (stargazerses.size() > 1) {
                            Stargazers stargazers = stargazerses.get(0);
                            mBinding.name.setText(stargazers.getLogin());
                            mBinding.surname.setText(stargazers.getAvatar());
                            mBinding.age.setText(stargazers.getId());
                        }
                    }
                });

        mCompositeSubscription.add(subscribe);
    }

    @Override
    protected void onStop() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
        super.onStop();
    }
}
