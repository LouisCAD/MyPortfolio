package xyz.louiscad.portfolio.ui.fragment;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

import java.util.ArrayList;

import xyz.louiscad.portfolio.R;
import xyz.louiscad.portfolio.ui.model.Website;

/**
 * Created by Louis Cognault on 20/09/15.
 */
@EFragment(R.layout.fragment_recycler_view)
public class WebsitesListFragment extends Fragment {

    @FragmentArg
    ArrayList<Website> websitesList;
}
