package xyz.louiscad.portfolio.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by Louis Cognault on 18/09/15.
 */
public class App implements Parcelable {

    @StringRes
    public int name, message;

    @DrawableRes
    public int icon;

    @ColorRes
    public int backgroundColor, textColor;

    public String packageName;

    public App(@StringRes int name,
               @StringRes int message,
               @DrawableRes int icon,
               @ColorRes int backgroundColor,
               @ColorRes int textColor,
               String packageName) {
        this.name = name;
        this.icon = icon;
        this.packageName = packageName;
        this.message = message;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.name);
        dest.writeInt(this.icon);
        dest.writeInt(this.backgroundColor);
        dest.writeInt(this.textColor);
    }

    protected App(Parcel in) {
        this.name = in.readInt();
        this.icon = in.readInt();
        this.backgroundColor = in.readInt();
        this.textColor = in.readInt();
    }

    public static final Parcelable.Creator<App> CREATOR = new Parcelable.Creator<App>() {
        public App createFromParcel(Parcel source) {
            return new App(source);
        }

        public App[] newArray(int size) {
            return new App[size];
        }
    };
}
