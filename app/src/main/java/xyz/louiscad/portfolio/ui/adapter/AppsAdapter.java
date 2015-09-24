package xyz.louiscad.portfolio.ui.adapter;

import android.view.ViewGroup;

import java.util.List;

import xyz.louiscad.portfolio.ui.model.App;
import xyz.louiscad.portfolio.ui.util.recyclerview.RecyclerViewAdapterBase;
import xyz.louiscad.portfolio.ui.view.AppListItem;
import xyz.louiscad.portfolio.ui.view.AppListItem_;

/**
 * Created by Louis Cognault on 18/09/15.
 */
public class AppsAdapter extends RecyclerViewAdapterBase<App, AppListItem> {

    private List<App> mAppList;

    public AppsAdapter(List<App> appList) {
        mAppList = appList;
    }

    @Override
    protected AppListItem onCreateItemView(ViewGroup parent, int viewType) {
        return AppListItem_.build(parent.getContext());
    }

    @Override
    protected App getData(int position) {
        return mAppList.get(position);
    }

    @Override
    public int getItemCount() {
        return mAppList.size();
    }
}
