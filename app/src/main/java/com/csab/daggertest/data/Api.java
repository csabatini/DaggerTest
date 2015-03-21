package com.csab.daggertest.data;


import com.csab.daggertest.model.NameResponse;

import retrofit.http.GET;
import rx.Observable;

public interface Api {

    @GET("/name")
    Observable<NameResponse> names();

}
