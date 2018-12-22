package com.zackeezy.redditpictures;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class RedditPicturesActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "RedditPixPrefs";
    public static final String SUBREDDIT_URL = "SubUrl";
    public static final String BASE_URL = "http://pictures.paulbradley.codes/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reddit_pictures);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
        if(!prefs.contains(SUBREDDIT_URL)){
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(SUBREDDIT_URL,"");
        }

        Intent intent = getIntent();
        String sub = intent.getStringExtra("sub");
        if(sub != null){
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(SUBREDDIT_URL, sub);
            editor.apply();
        }

        WebView wv = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = wv.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");

        String url = BASE_URL;

        if(!prefs.getString(SUBREDDIT_URL,"").equals("")){
            url = url.concat("r/".concat(prefs.getString(SUBREDDIT_URL,"")));
        }

        Log.d("Zackeezy", url);

        wv.loadUrl(url);
    }

    public void SettingsMenu(View view) {
        Intent i = new Intent(getApplicationContext(),Settings.class);
        startActivity(i);
    }
}
