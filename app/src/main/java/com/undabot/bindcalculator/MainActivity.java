package com.undabot.bindcalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.TextView;

import rx.Observable;
import rx.android.observables.ViewObservable;
import rx.functions.Action1;


public class MainActivity extends ActionBarActivity {

    private int mNumOne = 0;
    private int mNumTwo = 1;
    private int rez;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick = (Button) findViewById(R.id.btn_click);
        final TextView tvResultLabel = (TextView) findViewById(R.id.tv_result);

        final Observable<Button> btnClickObservable = ViewObservable.clicks(btnClick, false);
        btnClickObservable.subscribe(new Action1<Button>() {
            @Override
            public void call(Button button) {

                tvResultLabel.setText(String.valueOf(getResult()));
            }
        });


    }

    public int getResult() {
        rez = mNumOne + mNumTwo;
        mNumOne = mNumTwo;
        mNumTwo = rez;
        return rez;
    }

}
