package com.csab.daggertest.dagger;

import android.content.Context;
import android.net.wifi.WifiManager;

import com.csab.daggertest.data.Api;
import com.path.android.jobqueue.JobManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module(library = true)
public class AndroidModule {

    private final TestApplication application;

    public AndroidModule(TestApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    WifiManager provideWifiManager() {
        return (WifiManager) application.getSystemService(Context.WIFI_SERVICE);
    }

    @Provides
    @Singleton
    JobManager provideJobManager() {
        return new JobManager(application);
    }

    @Provides
    @Singleton
    Api provideApi() {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://45.55.154.121/api/")
                .build();
        return restAdapter.create(Api.class);
    }
}
