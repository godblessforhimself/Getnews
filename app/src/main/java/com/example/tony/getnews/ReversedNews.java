package com.example.tony.getnews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MacheNike on 2017/9/8.
 */

public class ReversedNews
{
    static  public String getReversedNews(int page, int pagesize) throws IOException
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
