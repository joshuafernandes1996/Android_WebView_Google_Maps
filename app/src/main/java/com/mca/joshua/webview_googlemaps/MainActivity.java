package com.mca.joshua.webview_googlemaps;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetworkAvailable()) {
            loadmap();
        } else {
            Toast.makeText(getApplicationContext(), "Check Internet Connection", Toast.LENGTH_LONG).show();
        }


    }

    private void loadmap() {
        map = findViewById(R.id.mapsView);
        map.setWebViewClient(new WebViewClient());
        map.getSettings().setJavaScriptEnabled(true);
        map.loadUrl("http://maps.google.com/maps?");
    }

    @Override
    public void onBackPressed() {
        if (map.canGoBack()) {
            map.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
