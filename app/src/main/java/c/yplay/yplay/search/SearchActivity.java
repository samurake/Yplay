package c.yplay.yplay.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import c.yplay.yplay.R;
import c.yplay.yplay.base.BaseActivity;

public class SearchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Initialize search fragment
        Fragment searchFragment = SearchFragment.newInstance("works","works");
        // Doing fragment transaction here at first activity start
        if(savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contentPanel, searchFragment).addToBackStack(null).commit();
        }
    }
}
