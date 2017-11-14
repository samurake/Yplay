package c.yplay.yplay.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import c.yplay.yplay.R;
import c.yplay.yplay.search.Result;

/**
 * Created by samur on 11/14/2017.
 */
public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.MyViewHolder> {

    private List<Result> resultList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.title1)
        TextView title1;
        @BindView(R.id.image)
        ImageView image;


        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
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
        Result resultT = resultList.get(position);
        holder.title.setText(resultT.GetTitle());
        holder.title1.setText(resultT.GetTitle1());
        holder.image.setImageResource(resultT.GetImage());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }
}