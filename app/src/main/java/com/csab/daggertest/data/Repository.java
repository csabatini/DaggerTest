package com.csab.daggertest.data;

import android.net.wifi.WifiManager;

import com.csab.daggertest.model.NameResponse;
import com.path.android.jobqueue.JobManager;

import javax.inject.Inject;

import rx.Observable;

public class Repository {

    @Inject
    public WifiManager mWifiManager;
    @Inject
    public JobManager mJobManager;
    @Inject
    public Api mApi;

    @Inject
    public Repository(WifiManager wifi, JobManager manager, Api api) { }

    public Observable<NameResponse> getNames() {
        return mApi.names();
    }
}
