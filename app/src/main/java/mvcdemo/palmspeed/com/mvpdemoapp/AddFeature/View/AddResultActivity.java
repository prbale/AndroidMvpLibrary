package mvcdemo.palmspeed.com.mvpdemoapp.AddFeature.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
import mvcdemo.palmspeed.com.mvpdemoapp.MyApplication;
import mvcdemo.palmspeed.com.mvpdemoapp.R;
import mvcdemo.palmspeed.com.mvpdemoapp.UserStatus;

public class AddResultActivity extends AppCompatActivity {

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String result = getIntent().getStringExtra("RESULT");

        textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(result);

    }

}
