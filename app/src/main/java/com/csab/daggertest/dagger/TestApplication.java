package com.csab.daggertest.dagger;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class TestApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(
                new AndroidModule(this),
                new TestModule());
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }
}
