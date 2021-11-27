package com.example.asm2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ivHeadline;
    TextView tvTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTopic = findViewById(R.id.tvTopic);

        // gán thuộc tính tag cho phần tử ivHeadline bằng ID của ivIconHeadLine
        // và lắng nghe sự kiện onClick trên ivHeadLine để hiển thị fragment menu
        ivHeadline = findViewById(R.id.ivIconHeadline);
        ivHeadline.setTag(R.id.ivIconHeadline);
        ivHeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFrg(R.id.ivIconHeadline);
            }
        });


    }

    public void showFrg(int tag) {

        switch (tag) {

            case R.id.ivIconHeadline:
                NavFrg menu = new NavFrg();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_Main, menu, null).commit();
                break;

            case R.string.peding_sms:
                tvTopic.setText("SMS Schedule");
                break;

            case R.string.phone_call:
                tvTopic.setText("Pending Call");
                break;

            case R.string.alarm:
                tvTopic.setText("Alarm");
                break;
        }
    }
}