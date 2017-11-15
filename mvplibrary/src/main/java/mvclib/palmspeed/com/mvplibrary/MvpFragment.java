package mvclib.palmspeed.com.mvplibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * A Fragment that uses a {@link MvpPresenter} to implement a Model-View-Presenter
 * architecture.
 *
 * @author Prashant Bale
 */
public abstract class MvpFragment<V extends MvpView, P extends MvpPresenter<V>> extends Fragment implements MvpView {

    private static final String TAG = "base-MvpFragment";
    protected P presenter;
    protected V view;

    /**
     * Instantiate a presenter instance
     *
     * @return The {@link MvpPresenter} for this view
     */
    @NonNull
    public abstract P createPresenter();

    public abstract V getFragmentView();

    protected abstract String tag();

    @Override public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        presenter = createPresenter();

        view = getFragmentView();

        presenter.attachView(view);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView(getRetainInstance());
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
