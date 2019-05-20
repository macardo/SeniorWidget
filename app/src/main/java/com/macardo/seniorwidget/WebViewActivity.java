package com.macardo.seniorwidget;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.baidu.com/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl("https://www.baidu.com/");
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100){
                    if (dialog!= null && dialog.isShowing()){}
                    dialog.dismiss();
                    dialog = null;
                }else {
                    if (dialog == null){
                        dialog = new ProgressDialog(WebViewActivity.this);
                        dialog.setTitle("正在加载");
                        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        dialog.setProgress(newProgress);
                        dialog.show();
                    }else {
                        dialog.setProgress(newProgress);
                    }
                }
                super.onProgressChanged(view,newProgress);
            }
        });
    }
}
