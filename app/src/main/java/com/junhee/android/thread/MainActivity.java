package com.junhee.android.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int mainValue = 0;
    TextView mainText, backText;
    Button increase;
    BackThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainvalue);
        backText = (TextView) findViewById(R.id.backvalue);
        increase = (Button) findViewById(R.id.increase);
        increase.setOnClickListener(this);

        thread = new BackThread(handler);
        thread.setDaemon(true);
        thread.start();


    }


    @Override
    public void onClick(View v) {
        mainValue++;
        mainText.setText("mainValue : " + mainValue);
        // 아래 주석을 풀었을 때, 클릭 시에만 잠깐 해당 문구가 뜸
        // backText.setText("Basdfjklsajdfkl");
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                backText.setText("backValue : " + msg.arg1);
            }
        }
    };
}

class BackThread extends Thread {
    int backValue = 0;
    Handler handler;
    // 생성자를 통해 handler를 넘겨 받는다.
    BackThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        while (true) {
            backValue++;
            Message msg = new Message();
            msg.what = 0;
            msg.arg1 = backValue;
            handler.sendMessage(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

