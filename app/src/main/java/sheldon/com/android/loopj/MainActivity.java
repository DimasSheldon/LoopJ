package sheldon.com.android.loopj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnLoopjListener {

    EditText mUsername, mPassword;
    Button mButtonGET, mButtonPOST;
    TextView mResult;

    MyLoopjTask myLoopjTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mButtonGET = (Button) findViewById(R.id.btnGET);
        mButtonPOST = (Button) findViewById(R.id.btnPOST);
        mResult = (TextView) findViewById(R.id.results);

        myLoopjTask = new MyLoopjTask(this, this);
    }

    public void doGET(View view) {
        myLoopjTask.executeLoopjGET();
    }

    public void doPOST(View view) {
        String username = mUsername.getText().toString();
        mUsername.setText("");
        String password = mPassword.getText().toString();
        mPassword.setText("");
        myLoopjTask.executeLoopjPOST(username, password);
    }

    @Override
    public void getResponse(String responses) {
        mResult.setText(responses);
    }
}