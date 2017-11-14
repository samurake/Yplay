package c.yplay.yplay.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import c.yplay.yplay.R;
import c.yplay.yplay.search.Result;

/**
 * Created by samur on 11/14/2017.
 */

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.MyViewHolder> {

    private List<Result> resultList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        // declare list element(views)

        public MyViewHolder(View view) {
            super(view);
            // view initialisation here
            ///
        }
    }


    public SearchRecyclerViewAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_item_result, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Result movie = resultList.get(position);
       // holder.
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }
}