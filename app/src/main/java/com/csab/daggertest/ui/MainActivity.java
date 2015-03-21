package com.csab.daggertest.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.csab.daggertest.R;
import com.csab.daggertest.dagger.TestBaseActivity;
import com.csab.daggertest.data.Repository;
import com.csab.daggertest.model.NameResponse;
import com.google.gson.Gson;

import javax.inject.Inject;

import rx.Subscriber;


public class MainActivity extends TestBaseActivity {

    @Inject
    public Repository mRepo;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onResume() {
        super.onResume();
        bind(mRepo.getNames()).subscribe(
                new Subscriber<NameResponse>() {
                    @Override
                    public void onCompleted() { }

                    @Override
                    public void onError(Throwable e) { }

                    @Override
                    public void onNext(NameResponse response) {
                        mTextView.setText(new Gson().toJson(response, NameResponse.class));
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
