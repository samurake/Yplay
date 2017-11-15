package c.yplay.yplay.search.helper;

import android.content.Context;
import android.util.Log;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import c.yplay.yplay.R;
import c.yplay.yplay.search.Result;

/**
 * Created by samur on 11/14/2017.
 */
public class YoutubeConnector {

    private YouTube youtube;
    private YouTube.Search.List query;
    private final long MAX_RESULTS=10;
    // Your developer key goes here
    public static final String KEY
            = "AIzaSyDD28IA0J_wPbmeNyXGkTCbtaI3W-R4IRA";

    public YoutubeConnector(Context context) {
        youtube = new YouTube.Builder(new NetHttpTransport(),
                new JacksonFactory(), new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest hr) throws IOException {}
        }).setApplicationName(context.getString(R.string.app_name)).build();

        try{

            query = youtube.search().list("id,snippet");
            query.setMaxResults(MAX_RESULTS);
            query.setKey(KEY);
            query.setType("video");
            query.setFields("items(id/videoId,snippet/title,snippet/description,snippet/thumbnails/default/url)");
        }catch(IOException e){
            Log.d("YC", "Could not initialize: "+e);
        }
    }

    public List<Result> search(String keywords){
        query.setQ(keywords);
        List<Result> items = new ArrayList<Result>();
        try{
            SearchListResponse response = query.execute();
            List<SearchResult> results = response.getItems();

            for(SearchResult result:results){
                Result item = new Result();
                item.setTitle(result.getSnippet().getTitle());
                item.setDescription(result.getSnippet().getDescription());
                item.setThumbnailURL(result.getSnippet().getThumbnails().getDefault().getUrl());
                item.setId(result.getId().getVideoId());
                items.add(item);

            }
        }catch(IOException e){
            Log.d("YC", "Could not search: "+e);
        }
        return items;
    }
}
