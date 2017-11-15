package mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.Interactor;

import android.os.Handler;
import android.text.TextUtils;

import mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.AddActivityMvpContract;

public class AddActivityMvpInteractor implements AddActivityMvpContract.Interactor {

    private addActivityMvpInteractorCallback mListener;

    public AddActivityMvpInteractor(addActivityMvpInteractorCallback listener) {
        mListener = listener;
    }

    @Override
    public void addTwoNumbers(final String param1, final String param2) {

        if(TextUtils.isEmpty(param1) || TextUtils.isEmpty(param2)) {
            mListener.displayError("Please enter valid value.");
            return;
        }

        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                try {

                    int a = Integer.parseInt(param1);
                    int b = Integer.parseInt(param2);

                    int res = a + b;
                    mListener.calculatedAddition(res);
                }
                catch(Exception e) {
                    mListener.displayError("Please enter numeric value.");
                }


            }
        }, 3000);

    }
}
