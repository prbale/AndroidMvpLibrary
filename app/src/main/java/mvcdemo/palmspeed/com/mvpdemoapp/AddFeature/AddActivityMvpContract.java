package mvcdemo.palmspeed.com.mvpdemoapp.AddFeature;

import mvclib.palmspeed.com.mvplibrary.MvpPresenter;
import mvclib.palmspeed.com.mvplibrary.MvpView;

public interface AddActivityMvpContract {

    interface Presenter extends MvpPresenter<View> {

        void addTwoNumbers(String a, String b);

        void setRouter(Router router);
    }

    interface View extends MvpView {

        void displayAddition(int res);

        void displayError(String errMsg);

        void displayProgress();

        void dismissProgress();

        void setRouterToPresenter();
    }

    interface Interactor {
        void addTwoNumbers(String a, String b);
    }

    interface Router {
        void goToErrorPage(String errorMessage);
        void goToSuccessPage(String result);
    }
}
