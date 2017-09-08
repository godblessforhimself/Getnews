package com.example.tony.getnews;
import android.util.Log;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by MacheNike on 2017/9/8.
 */

public class LTLTest
{
    @Test
    public void addition_isCorrect() throws Exception
    {
        String str=ReversedNews.getReversedNews(1,10);
        NewsTitle title=JasonClass.StringtoJson(str,NewsTitle.class);
        System.out.println(title.list.get(0).news_ID);
        assertEquals(1,1);
    }
}
