package com.example.tony.getnews;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by LTL on 2017/9/8.
 */

public class Storage
{
    private static String newsTitlefile="newsTitlefile.txt";
    private static String newsTextfile="newsTextfile.txt";
    private static String collectionfile="collectionfile.txt";
    private static String shieldwordsfile="shieldwords.txt";
    public static void addTitleFile(NewsTitle title,Context context)
    {
        try {
            File file = new File(context.getFilesDir(), newsTitlefile);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            out.write(JasonClass.JsontoString(title) + "\n");
            out.close();
        }catch (Exception e)
        {

        }
    }
    public static void addTextFile(NewsText text,Context context)
    {
        try
        {
            File file = new File(context.getFilesDir(), newsTextfile);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            out.write(JasonClass.JsontoString(text)+"\n");
            out.close();
        } catch (Exception e)
        {

        }
    }
    public static void addCollectionFile(NewsTitle title,Context context) {
        File file = new File(context.getFilesDir(), collectionfile);
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            out.write(JasonClass.JsontoString(title)+"\n");
            out.close();
        }catch (Exception e)
        {

        }


    }
    public static void delCollectionFile(NewsTitle title, Context context)
    {
        List<NewsTitle> list=findCollectionNews(context);
        File file = new File(context.getFilesDir(), collectionfile);
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for (int i=0;i<list.size();i++)

                if (!list.get(i).list.get(0).news_ID.equals(title.list.get(0).news_ID))
                    out.write(JasonClass.JsontoString(list.get(i)) + "\n");
            out.close();
        }catch (Exception e)
        {

        }

    }
    public static void addshieldwordsFile(String shieldword,Context context)
    {
        try
        {
            File file = new File(context.getFilesDir(), shieldwordsfile);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(shieldword + "\n");
            out.close();
        }catch (Exception e)
        {

        }
    }
    public static void delshieldFile(String shieldword, Context context)
    {
        List<String> list=getShieldWords(context);
        File file = new File(context.getFilesDir(), collectionfile);
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for (int i=0;i<list.size();i++)
                if (!list.get(i).equals(shieldword))
                    out.write(list.get(i) + "\n");
            out.close();
        }catch (Exception e)
        {

        }

    }
    public static List<String> getShieldWords(Context context)
    {
        List<String> list=new LinkedList<String>();
        File file = new File(context.getFilesDir(), shieldwordsfile);
        try {
            Scanner scanf = new Scanner(new FileInputStream(file));
            while (scanf.hasNext()) list.add(scanf.nextLine());
            scanf.close();
        }catch (Exception e)
        {

        }
        return list;
    }
    public static boolean isShield(NewsTitle title,Context context) throws Exception
    {
        List<String> shieldwords=getShieldWords(context);
        File file = new File(context.getFilesDir(), newsTextfile);
        Scanner scanf=new Scanner(new FileInputStream(file));
         while (scanf.hasNext())
        {
            NewsText text=JasonClass.StringtoJson(scanf.nextLine(),NewsText.class);
            int n=text.seggedPListOfContent.size();
            int m=shieldwords.size();
            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    if (shieldwords.get(j).equals(text.seggedPListOfContent.get(i)))
                    {
                        scanf.close();
                        return true;
                    }
        }

        scanf.close();
        return false;
    }
    public static  NewsTitle findTitle(int page,int pagesize,Context context) throws Exception
    {
        File file = new File(context.getFilesDir(), newsTitlefile);
        Scanner scanf=new Scanner(new FileInputStream(file));
        while (scanf.hasNext())
        {
            String str=scanf.nextLine();
            NewsTitle title=JasonClass.StringtoJson(str,NewsTitle.class);
            if (title.pageNo==page&&title.pageSize==pagesize)
            {
                scanf.close();
                return title;
            }
        }
        scanf.close();
        return null;
    }
    public static  NewsText findText(String newsid,Context context) throws Exception
    {
        File file = new File(context.getFilesDir(), newsTextfile);
        Scanner scanf=new Scanner(new FileInputStream(file));
        while (scanf.hasNext())
        {
            String str=scanf.nextLine();
            NewsText text=JasonClass.StringtoJson(str,NewsText.class);
            if (text.news_ID.equals(newsid))
            {
                scanf.close();
                return text;
            }
        }
        scanf.close();
        return null;
    }
    public static List<NewsTitle> findCollectionNews(Context context)
    {
        List<NewsTitle> list=new LinkedList<NewsTitle>();
        File file = new File(context.getFilesDir(), collectionfile);
        Scanner scanf=null;
        try
        {
            scanf=new Scanner(new FileInputStream(file));
        }catch(Exception e)
        {

        }
        while (scanf.hasNext()) list.add(JasonClass.StringtoJson(scanf.nextLine(),NewsTitle.class));
        scanf.close();
        return list;
    }

}
