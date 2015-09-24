package xyz.louiscad.portfolio.ui.fragment;

import android.support.annotation.StringRes;
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
import xyz.louiscad.portfolio.ui.model.App;

/**
 * Created by Louis Cognault on 18/09/15.
 */
@EFragment(R.layout.fragment_view_pager)
public class AppsPortfolioFragment extends Fragment implements ViewPager.OnPageChangeListener {

    @ViewById
    ViewPager viewPager;



    @AfterViews
    void initViews() {
        MainActivity activity = (MainActivity) getActivity();
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(this);
        activity.tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public ArrayList<App> getNanodegreeApps() {
            ArrayList<App> apps = new ArrayList<>();
            apps.add(new App(R.string.popular_movies, R.string.message_dev_not_started, 0, R.color.udacity, R.color.white, null));
            apps.add(new App(R.string.scores_app, R.string.message_dev_not_started, 0, R.color.udacity, R.color.white, null));
            apps.add(new App(R.string.library_app, R.string.message_dev_not_started, 0, R.color.udacity, R.color.white, null));
            apps.add(new App(R.string.build_it_bigger, R.string.message_dev_not_started, 0, R.color.udacity, R.color.white, null));
            apps.add(new App(R.string.xyz_reader, R.string.message_dev_not_started, 0, R.color.udacity, R.color.white, null));
            apps.add(new App(R.string.capstone, R.string.message_dev_not_started, 0, R.color.red_900, R.color.white, null));
            return apps;
        }

        public ArrayList<App> getHomeApps() {
            ArrayList<App> apps = new ArrayList<>();
            apps.add(new App(R.string.checkwake, R.string.message_under_dev, 0, R.color.deep_purple_800, R.color.white, null));
            return apps;
        }

        public ArrayList<App> getWorkApps() {
            ArrayList<App> apps = new ArrayList<>();
            apps.add(new App(R.string.suivi_dati, R.string.message_under_dev, 0, R.color.blue_grey_500, R.color.white, null));
            return apps;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            @StringRes int titleResId;
            switch (position) {
                case 0:
                    titleResId = R.string.nanodegree;
                    break;
                case 1:
                    titleResId = R.string.home;
                    break;
                case 2:
                    titleResId = R.string.work;
                    break;
                default:
                    throw new IllegalArgumentException("Nothing at position " + position);
            }
            return getString(titleResId);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return AppListFragment_.builder()
                            .mTitle(R.string.nanodegree)
                            .mAppList(getNanodegreeApps())
                            .build();
                case 1:
                    return AppListFragment_.builder()
                            .mTitle(R.string.home)
                            .mAppList(getHomeApps())
                            .build();
                case 2:
                    return AppListFragment_.builder()
                            .mTitle(R.string.work)
                            .mAppList(getWorkApps())
                            .build();
                default:
                    throw new IllegalArgumentException("No fragment at position " + position);
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
