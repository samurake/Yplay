package c.yplay.yplay.search;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import c.yplay.yplay.R;
import c.yplay.yplay.search.adapter.SearchRecyclerViewAdapter;
import c.yplay.yplay.search.helper.YoutubeConnector;


public class SearchFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private volatile List<Result> resultList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SearchRecyclerViewAdapter adapter;
    Button btn;
    EditText inputKeyword;

    private Handler handler;

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
        handler = new Handler();

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.search_container);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Result a = new Result();
        a.setId("a");
        a.setTitle("blabla");
        a.setDescription("tralala");
        resultList.add(a);


        adapter = new SearchRecyclerViewAdapter(getContext(),resultList);
        recyclerView.setAdapter(adapter);

        inputKeyword=(EditText)view.findViewById(R.id.input);
         btn=(Button)view.findViewById(R.id.button);
         btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyGetFromInout="";
                keyGetFromInout=inputKeyword.getText().toString();
                new LongOperation().execute(keyGetFromInout);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public class LongOperation extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            YoutubeConnector yc = new YoutubeConnector(getContext());
            resultList.clear();
            resultList.addAll(yc.search(strings[0])) ;

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}
