package c.yplay.yplay.search;

import android.widget.ImageView;

import c.yplay.yplay.R;

/**
 * Created by samur on 11/14/2017.
 */

public class Result {

    private String title;
    private String title1;
    private int imageView;

    public Result(){};

    public Result(String title, String title1, int imageResource){

        this.title=title;
        this.title1=title1;
        this.imageView=imageResource;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }



    public String GetTitle(   ){
        return title;
    }
    public String GetTitle1(){
        return title1;
    }
    public int GetImage(){
        return imageView;
    }
}
