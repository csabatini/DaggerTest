package com.csab.daggertest.dagger;

import android.content.Context;

import com.csab.daggertest.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = MainActivity.class,
    addsTo = AndroidModule.class,
    library = true
)
public class ActivityModule {

    private final TestBaseActivity activiy;

    public ActivityModule(TestBaseActivity activity) {
        this.activiy = activity;
    }

    @Provides
    @Singleton
    @ForActivity
    Context provideActivityContext() {
        return activiy;
    }
}
