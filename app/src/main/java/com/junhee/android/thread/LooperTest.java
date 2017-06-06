package com.junhee.android.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class LooperTest extends AppCompatActivity {
    int mainValue = 0;
    TextView mainText, backText;
    EditText numEdit;
    CalThread thread;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper_test);
    }

    private class CalThread extends Thread {
        Handler mainHandler;
        Handler backHanlder;

        CalThread(Handler handler){
            mainHandler = handler;
        }

        @Override
        public void run() {
            Looper.prepare();
            backHanlder = new Handler(){
                public void handleMessage(Message msg){
                    Message retmsg = new Message();
                    switch(msg.what){

                    }
                }
            };
        }
    }
}
