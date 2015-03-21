package com.csab.daggertest.dagger;

import android.content.Context;
import android.net.wifi.WifiManager;

import com.csab.daggertest.data.Api;
import com.google.gson.Gson;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module(library = true)
public class AndroidModule {
    private TestApplication application;

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
    WifiManager providesWifiManager() {
        return (WifiManager) application.getSystemService(Context.WIFI_SERVICE);
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter() {
        return new RestAdapter.Builder()
                .setEndpoint("http://45.55.154.121/api/")
                .build();
    }

    @Provides
    @Singleton
    Api provideApi(RestAdapter restAdapter) {
        return restAdapter.create(Api.class);
    }

    @Provides
    @Singleton
    Bus providesBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

}
