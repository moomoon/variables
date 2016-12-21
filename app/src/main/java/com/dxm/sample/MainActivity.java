package com.dxm.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dxm.variable.Val;
import com.dxm.variable.Var;
import com.dxm.variable.Variables;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Val<Integer> lazyVal = new Variables.Lazy<Integer>() {
//            @Override public Integer create() {
//                return some calculation;
//            }
//        };
//
//        Var<Integer> observableVal = new Variables.Observable<Integer>(0) {
//
//            @Override public void onChange(Integer oldValue, Integer newValue) {
//                do your thing;
//            }
//        };
    }
}
