package com.example.admin.takeout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by admin on 2017/4/6.
 */

public class InfoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.info_layout);
    }
}
