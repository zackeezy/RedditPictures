package com.zackeezy.redditpictures;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void ChangeSub(View view) {
        EditText subName = (EditText) findViewById(R.id.subText);

        String subNameStr = subName.getText().toString();

        Intent i = new Intent(getApplicationContext(),RedditPicturesActivity.class);
        i.putExtra("sub", subNameStr);
        startActivity(i);
    }
}
