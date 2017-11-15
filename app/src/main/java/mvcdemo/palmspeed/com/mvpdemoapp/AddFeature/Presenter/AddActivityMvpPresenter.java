package mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.Presenter;

import mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.AddActivityMvpContract;
import mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.Interactor.AddActivityMvpInteractor;
import mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.Interactor.addActivityMvpInteractorCallback;
import mvclib.palmspeed.com.mvplibrary.MvpBasePresenter;

public class AddActivityMvpPresenter extends MvpBasePresenter<AddActivityMvpContract.View> implements AddActivityMvpContract.Presenter, addActivityMvpInteractorCallback {

    AddActivityMvpContract.Interactor mAddActivityMvpInteractor;
    AddActivityMvpContract.Router mRouter;

    public AddActivityMvpPresenter() {
        mAddActivityMvpInteractor = new AddActivityMvpInteractor(this);
    }

    @Override
    public void attachView(AddActivityMvpContract.View view) {
        super.attachView(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }

    @Override
    public void addTwoNumbers(String a, String b) {

        if( isViewAttached() )
            getView().displayProgress();

        mAddActivityMvpInteractor.addTwoNumbers(a,b);
    }

    @Override
    public void setRouter(AddActivityMvpContract.Router router) {
        mRouter = router;
    }

    @Override
    public void calculatedAddition(int res) {

        if (isViewAttached()) {
            getView().dismissProgress();
            getView().displayAddition(res);
            mRouter.goToSuccessPage(String.valueOf(res));
        }
    }

    @Override
    public void displayError(String errMsg) {

        if (isViewAttached()) {
            getView().dismissProgress();
            getView().displayError(errMsg);
            mRouter.goToErrorPage(errMsg);
        }
    }
}
