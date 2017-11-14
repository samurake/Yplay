package c.yplay.yplay.search;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import c.yplay.yplay.R;
import c.yplay.yplay.search.adapter.SearchRecyclerViewAdapter;


public class SearchFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Result> resultList = new ArrayList<>();
    private RecyclerView recyclerView;
    SearchRecyclerViewAdapter adapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        populateLayout();
        View view = inflater.inflate(R.layout.fragment_search, container, false);



        recyclerView = (RecyclerView) view.findViewById(R.id.search_container);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SearchRecyclerViewAdapter(resultList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        // Inflate the layout for this fragment

        return view;
    }

    void populateLayout(){

        for (int i=0;i<24;i++) {
            Result a;
            a = new Result("Title :"+i,"Title1 :"+(i+1));
            resultList.add(a);
        }
        //adapter.notifyDataSetChanged();
    }
}
