package com.csab.daggertest.dagger;

import com.csab.daggertest.ui.MainActivity;

import dagger.Module;

@Module(
    includes = AndroidModule.class,
    injects = MainActivity.class,
    complete = false
)
public class TestModule {
}
