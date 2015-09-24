package xyz.louiscad.portfolio.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import xyz.louiscad.portfolio.R;
import xyz.louiscad.portfolio.ui.model.App;
import xyz.louiscad.portfolio.ui.util.recyclerview.ViewWrapper;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by Louis Cognault on 18/09/15.
 */
@EViewGroup(R.layout.app_list_item)
public class AppListItem extends FrameLayout implements ViewWrapper.Binder<App>, View.OnClickListener {

    @ViewById
    AppCompatButton appButton;

    App data;

    public AppListItem(Context context) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    @Override
    public void bind(App data) {
        this.data = data;
        appButton.setOnClickListener(this);
        appButton.setText(data.name);
        appButton.setTextColor(getColor(data.textColor));
        appButton.setSupportBackgroundTintList(new ColorStateList(new int[][]{{0}}, new int[]{getColor(data.backgroundColor)}));
        appButton.setCompoundDrawablesWithIntrinsicBounds(data.icon, 0, 0, 0);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, data.message, Snackbar.LENGTH_LONG).show();
    }

    @ColorInt
    @SuppressWarnings("deprecation")
    private int getColor(@ColorRes int color) {
        if (Build.VERSION.SDK_INT < 23) return getContext().getResources().getColor(color);
        else return getContext().getColor(color);
    }
}
