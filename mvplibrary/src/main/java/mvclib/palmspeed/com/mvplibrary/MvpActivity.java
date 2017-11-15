package mvclib.palmspeed.com.mvplibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * An Activity that uses a {@link MvpPresenter} to implement a Model-View-Presenter
 * architecture.
 *
 * @author Prashant Bale
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends AppCompatActivity implements MvpView {

    private static final String TAG = "base-MvpActivity";
    protected P presenter;
    protected V view;

    /**
     * Instantiate a presenter instance
     *
     * @return The {@link MvpPresenter} for this view
     */
    @NonNull
    public abstract P createPresenter();

    public abstract V getView();

    protected abstract String tag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        presenter = createPresenter();

        view = getView();

        presenter.attachView(view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(true);
    }


}
