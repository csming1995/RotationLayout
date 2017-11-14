package com.csm.rotationlayout.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.csm.rotationlayout.R;
import com.csm.rotationlayout.widget.RotationLayout;

public class MainActivity extends AppCompatActivity {

    private static final int ROTATION_STATUS_NORMAL = 1;
    private static final int ROTATION_STATUS_HORIZONTAL = 2;

    //屏幕状态状态
    private int rotationStatus = 1;

    private Button mButton;
    private RotationLayout rotationLayout;
    private TextView mTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mTvText = findViewById(R.id.text);
        rotationLayout = findViewById(R.id.rotationLayout);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ROTATION_STATUS_NORMAL == rotationStatus) {
                    rotationLayout.setRotation(0, 90);
                    rotationStatus = ROTATION_STATUS_HORIZONTAL;
                }else if (ROTATION_STATUS_HORIZONTAL == rotationStatus){
                    rotationLayout.setRotation(90, 0);
                    rotationStatus = ROTATION_STATUS_NORMAL;
                }
            }
        });
    }
}
