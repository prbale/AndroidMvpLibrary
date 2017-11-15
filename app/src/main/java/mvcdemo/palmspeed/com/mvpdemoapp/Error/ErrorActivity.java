package mvcdemo.palmspeed.com.mvpdemoapp.Error;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import mvcdemo.palmspeed.com.mvpdemoapp.R;

public class ErrorActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        String errorMessage = getIntent().getStringExtra("ERROR_MSG");

        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText(errorMessage);
    }
}
