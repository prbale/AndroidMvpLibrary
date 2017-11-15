package mvclib.palmspeed.com.mvplibrary;

import android.support.annotation.UiThread;

/**
 * The base interface for each mvp presenter.
 *
 * <p>
 *     Assume that all the interaction (i.e. updating the view) between presenter and view is
 *     executed on android's main UI thread.
 * </p>
 *
 * @author Prashant Bale.
 */
public interface MvpPresenter<V extends MvpView> {

    /**
     * This will have two method declaration which will need to implement in our presenter classes.
     * These methods helps to attach and detach view on orientation change
     * Which helps to maintain the memory.
     */
    @UiThread
    void attachView(V view);

    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * <code>Activity.detachView()</code> or <code>Fragment.onDestroyView()</code>
     * @param retainInstance
     */
    @UiThread
    void detachView(boolean retainInstance);
}
