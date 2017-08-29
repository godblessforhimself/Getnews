package com.example.tony.getnews;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button mTButton;
    private Button mFButton;
    private LinearLayout mLayout;
    private String news;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        try{
            news = getReversedNews(1,20);
        }catch(IOException e){
            news = e.toString();
        }

        setContentView(R.layout.activity_main);
        mLayout = (LinearLayout)findViewById(R.id.Lay);
        mTButton = (Button)findViewById(R.id.true_b);
        mFButton = (Button) findViewById(R.id.false_b);
        mTButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, news, Toast.LENGTH_SHORT).show();
            }
        });
        mFButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                TextView tv = new TextView(MainActivity.this);
                tv.setText(news.substring(count, count + 20));
                count += 20;
                mLayout.addView(tv);
            }
        });

    }
    public String getReversedNews(int page, int pagesize) throws IOException
    {
        URL website = new URL("http://166.111.68.66:2042/news/action/query/latest?pageNo="+page+"&pageSize="+pagesize);
        HttpURLConnection con = (HttpURLConnection)website.openConnection();
        InputStreamReader in = new InputStreamReader(con.getInputStream(),"utf-8");
        BufferedReader buffer = new BufferedReader(in);
        String response,result = "";
        while ((response = buffer.readLine())!=null)
        {
            result += response;
        }
        return result;
    }
}
