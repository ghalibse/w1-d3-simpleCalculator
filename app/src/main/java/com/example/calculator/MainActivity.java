package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG = "MainActivityTAG_";

    private EditText mEditText;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButtonAdd;
    private Button mButtonSub;
    private Button mButtonEq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.a_main_et);

        mButton1 = (Button) findViewById(R.id.btn1);
        mButton2 = (Button) findViewById(R.id.btn2);
        mButton3 = (Button) findViewById(R.id.btn3);

        mButtonAdd = (Button) findViewById(R.id.plus);
        mButtonSub = (Button) findViewById(R.id.minus);
        mButtonEq = (Button) findViewById(R.id.equal);
    }

    public void type1(View view) {
        Log.d(TAG,"type1:");
        String tmp = mEditText.getText().toString();
        mEditText.setText(tmp + "1");
    }

    public void type2(View view) {
        Log.d(TAG,"type2:" );
        String tmp = mEditText.getText().toString();
        mEditText.setText(tmp + "2");
    }

    public void type3(View view) {
        Log.d(TAG,"type3:" );
        String tmp = mEditText.getText().toString();
        mEditText.setText(tmp + "3");
    }

    public void add(View view) {
        Log.d(TAG,"ADD:");
        String tmp = mEditText.getText().toString();
        mEditText.setText(tmp + "+");
    }

    public void sub(View view) {
        Log.d(TAG,"SUB:");
        String tmp = mEditText.getText().toString();
        mEditText.setText(tmp + "-");
    }

    public void eq(View view) {
        Log.d(TAG,"EQU:");
        String tmp = mEditText.getText().toString();

        char ch =  calc(tmp);

        mEditText.setText(tmp + "="+ ch);
    }
    public char calc(String str) {

        StringBuilder s = new StringBuilder(str);
        s.reverse();
        //s.deleteCharAt(0);

        Stack st = new Stack();
        char [] strArry = s.toString().toCharArray();

        for( char i : strArry) st.push(i);

        int ans = 0;
        while(st.size() != 1){

            int a = (char)st.pop() - '0';
            char sn = (char)st.pop();
            int b = (char) st.pop() - '0';

            switch(sn){
                case '+' : ans =  a + b; break;
                case '-' : ans =  a - b; break;
            }
            st.push((char)(ans + '0'));
        }
        return (char) st.pop();
    }

}
