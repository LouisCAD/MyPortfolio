package xyz.louiscad.portfolio.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import xyz.louiscad.portfolio.R;
import xyz.louiscad.portfolio.ui.activity.MainActivity;
import xyz.louiscad.portfolio.ui.model.Website;

/**
 * Created by Louis Cognault on 20/09/15.
 */
@EFragment(R.layout.fragment_view_pager)
public class WebPortfolioFragment extends Fragment {

    @ViewById
    ViewPager viewPager;


    @AfterViews
    void initView() {
        MainActivity activity = (MainActivity) getActivity();
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        activity.tabLayout.setupWithViewPager(viewPager);
    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private ArrayList<Website> getUniversityWebsites() {
            ArrayList<Website> sites = new ArrayList<>();
            sites.add(new Website());
            return sites;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return WebsitesListFragment_.builder()
                            .websitesList(getUniversityWebsites())
                            .build();
                default:
                    throw new IllegalArgumentException("No fragment at position " + position);
            }
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}
