package br.harlan.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private WebView webView;
    private EditText edtSite;
    private Button btnIr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWebView((WebView)findViewById(R.id.webView));
        setEdtSite((EditText)findViewById(R.id.edtSite));
        setBtnIr((Button)findViewById(R.id.btnIr));

        getWebView().getSettings().setLoadsImagesAutomatically(true);
        getWebView().getSettings().setJavaScriptEnabled(true);

        getWebView().setWebViewClient(new WebViewClient());

        getBtnIr().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=getEdtSite().getText().toString();
                getWebView().loadUrl(url);
            }
        });
    }

    public WebView getWebView() {
        return webView;
    }
    public void setWebView(WebView webView) {
        this.webView = webView;
    }
    public EditText getEdtSite() {
        return edtSite;
    }
    public void setEdtSite(EditText edtSite) {
        this.edtSite = edtSite;
    }
    public Button getBtnIr() {
        return btnIr;
    }
    public void setBtnIr(Button btnIr) {
        this.btnIr = btnIr;
    }
}
