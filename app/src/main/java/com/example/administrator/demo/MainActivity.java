package com.example.administrator.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zdsoft.littleapple.utils.display.DisplayUtils;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private Button button;
    private ImageView imageView;
    private EditText userNameText;
    private EditText passWordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        linearLayout = (LinearLayout) findViewById(R.id.login_layout);
        button = (Button) findViewById(R.id.login_btn);
        imageView = (ImageView) findViewById(R.id.app_logo);
//        userNameText = (EditText) findViewById(R.id.username);
//        passWordText = (EditText) findViewById(R.id.password);
        RelativeLayout.LayoutParams ll = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        ll.width = DisplayUtils.getDisplayMetrics(MainActivity.this).widthPixels/2;
        linearLayout.setLayoutParams(ll);
    }
}
