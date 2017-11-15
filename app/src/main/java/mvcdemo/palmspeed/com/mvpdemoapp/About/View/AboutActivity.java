package mvcdemo.palmspeed.com.mvpdemoapp.About.View;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.AddActivityMvpContract;
import mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.Presenter.AddActivityMvpPresenter;
import mvcdemo.palmspeed.com.mvpdemoapp.AppModel;
import mvcdemo.palmspeed.com.mvpdemoapp.Base.BaseActivity;
import mvcdemo.palmspeed.com.mvpdemoapp.MyApplication;
import mvcdemo.palmspeed.com.mvpdemoapp.R;
import mvcdemo.palmspeed.com.mvpdemoapp.UserStatus;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        AppModel model = MyApplication.getInstance().getModel();
        if(model.getUserStatus() == UserStatus.LOGGED_IN) {
            Toast.makeText(this, "User : Logged in", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "User : Logged out", Toast.LENGTH_SHORT).show();
        }
    }
}
