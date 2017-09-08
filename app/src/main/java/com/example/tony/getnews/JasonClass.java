package com.example.tony.getnews;

/**
 * Created by MacheNike on 2017/9/8.
 */
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
public class JasonClass
{
    static <T> T StringtoJson(String str,Class<T> type)
    {
            Gson gson=new Gson();
            return gson.fromJson(str,type);
    }

}
