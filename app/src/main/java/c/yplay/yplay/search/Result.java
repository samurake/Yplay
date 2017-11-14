package c.yplay.yplay.search;

/**
 * Created by samur on 11/14/2017.
 */
public class Result {

    private String id;
    private String title;
    private String description;
    private String thumbnailURL;

    public Result(){}

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String title1) {
        this.description = title1;
    }

    public void setThumbnailURL(String thumbnail) {
        this.thumbnailURL = thumbnail;
    }

    public String getId() {
        return id;
    }

    public String GetTitle(   ){
        return title;
    }

    public String GetDescription(){
        return description;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }
}
