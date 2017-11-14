package c.yplay.yplay.search;

import android.widget.ImageView;

/**
 * Created by samur on 11/14/2017.
 */

public class Result {

    private String title;
    private String title1;
    private ImageView imageView;

    public Result(){};

    public Result(String title, String title1){

        this.title=title;
        this.title1=title1;
        //this.imageView=imageView;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String GetTitle(   ){
        return title;
    }
    public String GetTitle1(){
        return title1;
    }
    public ImageView GetImage(){
        return imageView;
    }
}
