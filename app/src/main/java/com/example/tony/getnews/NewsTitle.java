package com.example.tony.getnews;

/**
 * Created by MacheNike on 2017/9/8.
 */
import java.util.List;

public class NewsTitle
{
        List<MyList> list;
        int pageNo,pageSize,totalPages,totalRecords;
        class MyList
        {
                String newsClassTag,news_ID,news_Source,news_Title,news_Time,news_URL,news_Author,lang_Type,news_Pictures,news_Video,news_Intro;
        }
}

