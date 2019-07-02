package com.dragonforest.android.matrialdesignapp.searchview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dragonforest.android.matrialdesignapp.R;

public class SearchViewActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toobar);
//        initToolbar(toolbar);
    }

    private void initToolbar(Toolbar toolbar) {
        toolbar.inflateMenu(R.menu.toolbar_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        initSearchView(searchView);

        return true;
    }

    private void initSearchView(SearchView searchView) {
        // 设置一出来就显示搜索框
        searchView.setIconified(false);
        // 提交按钮
        searchView.setSubmitButtonEnabled(true);
        //
        SearchView.SearchAutoComplete et= searchView.findViewById(R.id.search_src_text);
        et.setHint("请输入商品名");
        et.setHintTextColor(Color.GRAY);

        // 关闭监听
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Toast.makeText(SearchViewActivity.this, "searchView关闭", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // 文本提交和文本改变
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(SearchViewActivity.this, "searchView提交", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                Toast.makeText(SearchViewActivity.this, "searchView text change", Toast.LENGTH_SHORT).show();
                Log.e("TAG", "searchView onQueryTextChange()");
                return false;
            }
        });

        // 搜索图标被点击 点击之后显示searchView
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchViewActivity.this, "searchView click", Toast.LENGTH_SHORT).show();
            }
        });

        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int i) {
                Toast.makeText(SearchViewActivity.this, "onSuggestionSelect:"+i, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onSuggestionClick(int i) {
                return false;
            }
        });
    }
}
