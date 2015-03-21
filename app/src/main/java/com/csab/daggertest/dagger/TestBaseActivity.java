package com.csab.daggertest.dagger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import rx.Observable;
import rx.android.app.AppObservable;
import rx.android.lifecycle.LifecycleEvent;
import rx.android.lifecycle.LifecycleObservable;
import rx.subjects.BehaviorSubject;

public abstract class TestBaseActivity extends ActionBarActivity {

    @Inject
    public Bus mBus;

    private final BehaviorSubject<LifecycleEvent> lifecycleSubject = BehaviorSubject.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TestApplication) getApplication()).inject(this);
        lifecycleSubject.onNext(LifecycleEvent.CREATE);
    }

    @Override
    public void onStart() {
        super.onStart();
        lifecycleSubject.onNext(LifecycleEvent.START);
    }

    @Override
    public void onResume() {
        super.onResume();
        lifecycleSubject.onNext(LifecycleEvent.RESUME);
        mBus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        lifecycleSubject.onNext(LifecycleEvent.PAUSE);
        mBus.unregister(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        lifecycleSubject.onNext(LifecycleEvent.STOP);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycleSubject.onNext(LifecycleEvent.DESTROY);
    }

    protected <T> Observable<T> bind(Observable<T> observable) {
        Observable<T> boundObservable = AppObservable.bindActivity(this, observable);
        return LifecycleObservable.bindActivityLifecycle(getLifecycle(), boundObservable);
    }

    private Observable<LifecycleEvent> getLifecycle() {
        return lifecycleSubject.asObservable();
    }

}
