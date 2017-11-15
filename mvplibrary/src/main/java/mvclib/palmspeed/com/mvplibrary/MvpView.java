package mvclib.palmspeed.com.mvplibrary;

import android.support.annotation.StringRes;

/**
 * This is base interface for all the MVP View interface.
 * This interface common methods which will required across all the views.
 *
 * @author Prashant Bale.
 */
public interface MvpView {

        /**
         * This will notify view to display loading view.
         */
        void showLoading();

        /**
         * This will notify view that background operation has been completed.
         * Loading view can be hide or removed.
         */
        void hideLoading();

        /**
         * This will notify view, that there has been some error.
         * @param resId String resource id, to display error message to the user.
         */
        void onError(@StringRes int resId);

        /**
         * This will notify view, that there has been some error.
         * @param message String to display error message to the user.
         */
        void onError(String message);

        /**
         * This will notify view with some specific message.
         * TODO: May be we dont require this.
         * @param message Message string to be displayed.
         */
        void showMessage(String message);

        /**
         * This will notify view with some specific message.
         * TODO: May be we dont require this.
         * @param resId Message string resource id to be displayed.
         */
        void showMessage(@StringRes int resId);

        /**
         * This will be used to check, whether application has network connection.
         */
        boolean isNetworkConnected();

        /**
         * If in case we need to hide keyboard. There are many situation when we need to hide the keyboard.
         */
        void hideKeyboard();

    }

