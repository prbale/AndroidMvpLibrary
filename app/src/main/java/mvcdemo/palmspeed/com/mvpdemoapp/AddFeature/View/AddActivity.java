package mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mvcdemo.palmspeed.com.mvpdemoapp.About.View.AboutActivity;
import mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.AddActivityMvpContract;
import mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.Presenter.AddActivityMvpPresenter;
import mvcdemo.palmspeed.com.mvpdemoapp.AppModel;
import mvcdemo.palmspeed.com.mvpdemoapp.Base.BaseActivity;
import mvcdemo.palmspeed.com.mvpdemoapp.Error.ErrorActivity;
import mvcdemo.palmspeed.com.mvpdemoapp.MyApplication;
import mvcdemo.palmspeed.com.mvpdemoapp.R;
import mvcdemo.palmspeed.com.mvpdemoapp.UserStatus;
import mvclib.palmspeed.com.mvplibrary.MvpActivity;

public class AddActivity extends BaseActivity<AddActivityMvpContract.View, AddActivityMvpContract.Presenter> implements AddActivityMvpContract.View, AddActivityMvpContract.Router {

    private Button btnAdd, btnAbout;
    private EditText etTxtNumber1, etTxtNumber2;

    @NonNull
    @Override
    public AddActivityMvpContract.Presenter createPresenter() {
        return new AddActivityMvpPresenter();
    }

    @Override
    public AddActivityMvpContract.View getView() {
        return this;
    }

    @Override
    protected String tag() {
        return "AddActivityTag";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This is mandatory
        setRouterToPresenter();

        initFields();

        AppModel model = MyApplication.getInstance().getModel();
        if(model.getUserStatus() == UserStatus.LOGGED_IN) {
            Toast.makeText(this, "User : Logged in", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "User : Logged out", Toast.LENGTH_SHORT).show();
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String param1 = etTxtNumber1.getText().toString();
                String param2 = etTxtNumber2.getText().toString();

                AppModel model = MyApplication.getInstance().getModel();
                model.setUserStatus(UserStatus.LOGGED_IN);
                MyApplication.getInstance().setModel(model);

                presenter.addTwoNumbers( param1 , param2);

            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity( new Intent(AddActivity.this, AboutActivity.class));
            }
        });



    }

    @Override
    protected void setUp() {
        System.out.println("Setup done for the activity..!!");
    }

    private void initFields() {

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        etTxtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        etTxtNumber2 = (EditText) findViewById(R.id.txtNumber2);
    }


    @Override
    public void displayAddition(int res) {
    }

    @Override
    public void displayError(String errMsg) {
    }

    @Override
    public void displayProgress() {
        showLoading();
    }


    @Override
    public void dismissProgress() {
       hideLoading();
    }

    @Override
    public void setRouterToPresenter() {
        presenter.setRouter(this);
    }

    @Override
    public void goToErrorPage(String errorMessage) {
        Intent intent = new Intent(this, ErrorActivity.class);
        intent.putExtra("ERROR_MSG", errorMessage);
        startActivity(intent);
    }

    @Override
    public void goToSuccessPage(String result) {
        Intent intent = new Intent(this, AddResultActivity.class);
        intent.putExtra("RESULT", result);
        startActivity(intent);
    }
}
