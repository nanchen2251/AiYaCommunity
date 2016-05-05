package com.example.nanchen.newsdemo.find;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nanchen.newsdemo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class TranslateActivity extends Activity {

    private EditText editText;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_translate);

        TextView menu_text = (TextView) findViewById(R.id.menu_text);
        menu_text.setText("英汉互译");
        ImageButton btn_back = (ImageButton) findViewById(R.id.imageButton_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editText = (EditText) findViewById(R.id.content_fanyi);
        tv = (TextView) findViewById(R.id.get_content_fanyi);
    }

    public void btnClick(View view) {
        String str = "";
        try {
            str = URLEncoder.encode(editText.getText().toString().trim(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=httpsnanchen&" +
                "key=937123870&type=data&doctype=json&version=1.1&q="
                + str;
        tv.setText("");
        new AsyncTask<String, Float, String>() {

            @Override
            protected String doInBackground(String... params) {
                URL url = null;
                try {
                    url = new URL(params[0]);
                    //获得连接
                    URLConnection connection = url.openConnection();
                    //获取数据
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String str;
                    StringBuffer sbf = new StringBuffer();
                    while((str = br.readLine()) != null){
                        sbf.append(str);
                    }
                    br.close();
                    return sbf.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                tv.setText("");
                tv.append(JSONTransform(s));
                super.onPostExecute(s);
            }
        }.execute(url);
    }

    //有道传回的JSON数据解析
    private String JSONTransform(String data) {
        StringBuffer buf = new StringBuffer();
        try {
            JSONObject root = new JSONObject(data);
            JSONArray arr = root.getJSONArray("translation");
            buf.append("有道翻译：");
            for (int i = 0; i < arr.length(); i++) {
                buf.append(arr.get(i).toString() + ", ");
            }
            buf.append("\n" + "基本词典:\n ");
            JSONObject basic = root.getJSONObject("basic");
            buf.append("发音-" + basic.getString("phonetic") + "\n");
            if (basic.get("uk-phonetic") != null)
                buf.append("英式发音-" + basic.getString("phonetic") + "\n");
            if (basic.get("us-phonetic") != null)
                buf.append("美式发音-" + basic.getString("phonetic") + "\n");
            buf.append("基本词典解释：\n");
            JSONArray explains = basic.getJSONArray("explains");
            for (int i = 0; i < explains.length(); i++) {
                buf.append(explains.get(i).toString() + ", ");
            }
            buf.append("\n" + "网络词典:\n ");
            JSONArray web = root.getJSONArray("web");
            JSONArray value = ((JSONObject) web.get(0)).getJSONArray("value");
            for (int i = 0; i < explains.length(); i++) {
                buf.append(value.get(i).toString() + ", ");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return buf.toString();

    }
}
