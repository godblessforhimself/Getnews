package com.example.tony.getnews;

import android.content.Context;

import java.io.IOException;
import java.util.List;

/**
 * Created by LTL on 2017/9/8.
 */

public class BackendInter implements  BackendInterface
{
   public  NewsTitle getNewsTitle(int page, int pagesize, Context context) throws Exception
    {
        String oncesee=Config.load("page"+page+"pagesize"+pagesize,context);
        NewsTitle title;
        if (oncesee.equals("1"))  title=Storage.findTitle(page,pagesize,context);
            else
        {
            String str=ReversedNews.getReversedNews(page,pagesize);
           title=JasonClass.StringtoJson(str,NewsTitle.class);
        }
        if (Storage.isShield(title,context))
        {
            Exception e=new Exception();
            throw e;
        }
        return title;
    }
    public NewsText getNewsText(NewsTitle title,Context context) throws Exception
    {
        String oncesee=Config.load("page"+title.pageNo+"pagesize"+title.pageSize,context);
        NewsText text;
        if (oncesee.equals("1")) text=Storage.findText(title.list.get(0).news_ID,context);
         else
        {
            String str=ReversedNews.getReversedNewsText(title.list.get(0).news_ID);
            text=JasonClass.StringtoJson(str,NewsText.class);
        }
        return text;
    }
    public List<NewsTitle> getCollectionNews(Context context)
    {
        return Storage.findCollectionNews(context);
    }
    public void addCollectionNews(NewsTitle title,Context context)
    {
        Storage.addCollectionFile(title,context);
    }
    public void delCollectionNews(NewsTitle title ,Context context)
    {
        Storage.delCollectionFile(title,context);
    }
    public  void addShiledWord(String shieldword,Context context)
    {
        Storage.addshieldwordsFile(shieldword,context);
    }
    public  void delShiledWord(String shieldword,Context context)
    {
        Storage.delshieldFile(shieldword,context);
    }
    public void setPicturesDisplay(int type,Context context)
    {
        Config.Save("PicturesDisplay",Integer.toString(type),context);
    }
    public int getPicturesDisplay(Context context)
    {
        return Integer.parseInt(Config.load("PicturesDisplay",context));
    }
    public void viewed(NewsTitle title,NewsText text,Context context)
    {
        Storage.addTitleFile(title,context);
        Storage.addTextFile(text,context);
     }//已看过新闻

}
