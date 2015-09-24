package xyz.louiscad.portfolio.ui.fragment;

import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import xyz.louiscad.portfolio.R;
import xyz.louiscad.portfolio.ui.adapter.AppsAdapter;
import xyz.louiscad.portfolio.ui.model.App;

/**
 * TODO: fill this
 */
@EFragment(R.layout.fragment_recycler_view)
public class AppListFragment extends Fragment {

    @StringRes
    @FragmentArg
    int mTitle;

    @ColorRes
    @FragmentArg
    int mPrimaryColor, mAccentColor;

    @FragmentArg
    ArrayList<App> mAppList;

    @ViewById
    RecyclerView recyclerView;

    @AfterViews
    void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new AppsAdapter(mAppList));
    }

}
