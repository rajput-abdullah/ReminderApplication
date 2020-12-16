package com.example.reminderapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Dashboard extends Fragment {
    ViewPager2 viewPager;
    TabLayout tabLayout;
    SearchView searchView;

    public Dashboard() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Inflate the layout for this fragment
        viewPager = root.findViewById(R.id.view_pager);
        tabLayout = root.findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager.setAdapter(createCardAdapter());
//        new TabLayoutMediator(tabLayout, viewPager,
//                (tab, position) -> tab.setText("Tab " + (position + 1))).attach();
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    tab.setText(((ViewPagerAdapter)(Objects.requireNonNull(viewPager.getAdapter()))).mFragmentNames[position]);//Sets tabs names as mentioned in ViewPagerAdapter fragmentNames array, this can be implemented in many different ways.
                }
        ).attach();
        return root;
    }
    private ViewPagerAdapter createCardAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        return adapter;
    }

    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        setHasOptionsMenu(true);

        menu.clear();
        inflater.inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.search_bar);
//        var searchManager = (SearchManager) this.Activity.GetSystemService(Context.SearchService);
//        searchView = (SearchView) (menu.FindItem(Resource.Id.action_search).ActionView);
//        searchView.SetSearchableInfo(searchManager.GetSearchableInfo(Activity.ComponentName));

        // MenuItemCompat.setShowAsAction(item, //MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | //MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        //  MenuItemCompat.setActionView(item, searchView);
        // These lines are deprecated in API 26 use instead
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);
        item.setActionView(searchView);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//       SearchView searchView = (SearchView) item.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Log.w("myApp", "onQueryTextSubmit ");
//                return true;
//            }
//
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                Log.w("myApp", "onQueryTextChange ");
//                return false;
//            }
//        });
//        super.onCreateOptionsMenu(menu, inflater);

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


        }
    }


