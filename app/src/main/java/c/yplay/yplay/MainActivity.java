package c.yplay.yplay;

import android.content.Intent;
import android.os.Bundle;

import c.yplay.yplay.base.BaseActivity;
import c.yplay.yplay.search.SearchActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }
}
