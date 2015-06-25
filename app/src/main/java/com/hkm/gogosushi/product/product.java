package com.hkm.gogosushi.product;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.hkm.gogosushi.R;

/**
 * Created by hesk on 25/6/15.
 */
public class product extends AppCompatActivity {
    private Toolbar toolbar;

    protected void setCustomActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomActionBar();
        setContentView(R.layout.page_product);
    }
}
