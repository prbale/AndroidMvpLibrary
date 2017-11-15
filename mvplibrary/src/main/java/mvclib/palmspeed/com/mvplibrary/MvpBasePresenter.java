package mvclib.palmspeed.com.mvplibrary;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

import java.lang.ref.WeakReference;


/**
 * A base implementation of a {@link MvpPresenter} that uses a <b>WeakReference</b> for referring to
 * the attached view
 *
 *
 * @param <V> type of the {@link MvpView}
 * @author Prashant Bale
 */

public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = "MvpBasePresenter";

    /**
     * This will hold weak reference of the view. So that there is no memory leak if in case of orientation
     * change or any other situations.
     */
    private WeakReference<V> weakViewRef;

    @UiThread
    @Override
    public void attachView(V view) {
        weakViewRef = new WeakReference<V>(view);

        System.out.println("Attaching view : " + weakViewRef);
    }

    @UiThread
    @Override
    public void detachView(boolean retainInstance) {

        if(weakViewRef != null) {
            weakViewRef.clear();
            weakViewRef = null;  // Now weakViewRef available for Garbage collection.
        }

        System.out.println("View detached : " + weakViewRef);
    }

    /**
     * Get the attached view. You should always call {@link #isViewAttached()} to check if the view
     * is attached to avoid NullPointerException.
     *
     * @return <code>null</code>, if view is not attached, otherwise the concrete view instance.
     */
    @Nullable
    public V getView() {
        return weakViewRef == null ? null : weakViewRef.get();
    }


    /**
     * Check if view is attached to this presenter. You should always call this method before
     * calling {@link #getView()} to get the view instance.
     */
    public boolean isViewAttached() {
        return ( weakViewRef != null && weakViewRef.get() != null );
    }

}
