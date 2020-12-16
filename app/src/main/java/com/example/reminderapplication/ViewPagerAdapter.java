package com.example.reminderapplication;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class ViewPagerAdapter extends FragmentStateAdapter {
    private final Fragment[] mFragments = new Fragment[] {//Initialize fragments views
//Fragment views are initialized like any other fragment (Extending Fragment)
            new FirstFragment(),//First fragment to be displayed within the pager tab number 1
            new SecondFragment(),
    };
    public final String[] mFragmentNames = new String[] {//Tabs names array
            "Dashboard",
            "Favaourites"
    };

    public ViewPagerAdapter(Dashboard fa){//Pager constructor receives Activity instance
        super(fa);
    }

    @Override
    public int getItemCount() {
        return mFragments.length;//Number of fragments displayed
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragments[position];
    }
//    int mNumOfTabs;
//    private static final int CARD_ITEM_SIZE = 2;
//
//    public ViewPagerAdapter(@NonNull Dashboard fragmentActivity) {
//        super(fragmentActivity);
//    }
//
//    @NonNull @Override public Fragment createFragment(int position) {
//        return CardFragment.newInstance(position);
//    }
//
//    @Override public int getItemCount() {
//        return CARD_ITEM_SIZE;
//    }
}
//    <?xml version="1.0" encoding="utf-8"?>
//<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        xmlns:tools="http://schemas.android.com/tools"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:id="@+id/toolbar"
//        tools:context=".Dashboard">
//<LinearLayout
//        android:layout_width="match_parent"
//                android:layout_height="match_parent"
//                android:orientation="vertical"
//                >
//
//<com.google.android.material.tabs.TabLayout
//        android:id="@+id/tab_layout"
//        style="@style/Widget.MaterialComponents.TabLayout.Colored"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content" />
//
//<androidx.viewpager2.widget.ViewPager2
//        android:id="@+id/view_pager"
//        android:layout_width="match_parent"
//        android:layout_height="0dp"
//        android:layout_weight="1" />
//
//</LinearLayout>
//</FrameLayout>