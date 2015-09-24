package xyz.louiscad.portfolio.ui.activity;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import xyz.louiscad.portfolio.R;
import xyz.louiscad.portfolio.ui.fragment.AppsPortfolioFragment_;
import xyz.louiscad.portfolio.ui.fragment.WebPortfolioFragment_;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String APPS_FRAGMENT_TAG = "apps_fragment";
    private static final String WEBSITES_FRAGMENT_TAG = "websites_fragment";
    private static final String ABOUT_FRAGMENT_TAG = "about_fragment";

    @ViewById
    CoordinatorLayout coordinatorLayout;

    @ViewById
    Toolbar toolbar;

    @ViewById
    public TabLayout tabLayout;

    @ViewById(R.id.drawerLayout)
    DrawerLayout drawer;

    @ViewById
    NavigationView navigationView;

    @AfterViews
    void init() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        showFragment(new AppsPortfolioFragment_());
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    @OptionsItem
    boolean actionSettingsSelected() {
        Snackbar.make(coordinatorLayout, "Settings activity isn't ready yet :(", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        boolean handled = false;
        switch (item.getItemId()) {
            case R.id.nav_apps:
                showFragment(APPS_FRAGMENT_TAG);
                handled = true;
                break;
            case R.id.nav_websites:
                //showFragment(WEBSITES_FRAGMENT_TAG);
                //handled = true;
                break;
            case R.id.nav_about:
                handled = true;
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return handled;
    }

    private void showFragment(String tag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            switch (tag) {
                case APPS_FRAGMENT_TAG:
                    fragment = new AppsPortfolioFragment_();
                    break;
                case WEBSITES_FRAGMENT_TAG:
                    fragment = new WebPortfolioFragment_();
                    break;
                case ABOUT_FRAGMENT_TAG:
                default:
                    throw new IllegalArgumentException("Case not handled yet :(");
            }
        }
        showFragment(fragment);
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
