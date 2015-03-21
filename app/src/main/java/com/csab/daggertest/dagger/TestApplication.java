package com.csab.daggertest.dagger;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class TestApplication extends Application {

    private ObjectGraph applicationGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationGraph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(
                new AndroidModule(this));
    }

    ObjectGraph getApplicationGraph() {
        return applicationGraph;
    }
}
