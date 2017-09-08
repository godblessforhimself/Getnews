package com.example.tony.getnews;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created by MacheNike on 2017/9/8.
 */

public class Storage
{
    private static String newsTitlefile="newsTitlefile.txt";
    private static String newsTextfile="newsTextfile.txt";
    private static String collectionfile="collectionfile.txt";
    private static String keywordsfile="keywords.txt";
    public static void saveTitlefile(Context context,NewsTitle title) throws Exception
    {
        File file = new File(context.getFilesDir(), newsTitlefile);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file, true)));
        out.write(JasonClass.JsontoString(title)+"\n");
    }
    public static void saveTextfile(Context context,NewsText text) throws Exception
    {
        File file = new File(context.getFilesDir(), newsTextfile);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file, true)));
        out.write(JasonClass.JsontoString(text)+"\n");
    }
    public static void savecollectionfile(Context context,String nameid) throws Exception
    {
        File file = new File(context.getFilesDir(), newsTextfile);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file, true)));
        out.write(nameid+"\n");
    }
    public static void savekeywordsfile(Context context,String nameid) throws Exception
    {
        File file = new File(context.getFilesDir(), newsTextfile);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file, true)));
        out.write(nameid+"\n");
    }/*
    public static List<NewsTitle> LoadTitile(Context context)
    {
        File file = new File(context.getFilesDir(), newsTextfile);

    }*/
}
