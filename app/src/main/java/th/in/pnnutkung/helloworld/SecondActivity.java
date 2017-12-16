package th.in.pnnutkung.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button okBtn;
    private EditText editText;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        sum = intent.getIntExtra("result", 0);
        Bundle bundle = intent.getBundleExtra("cBundle");
        int x = bundle.getInt("x");
        int y = bundle.getInt("x");
        int z = bundle.getInt("x");

        CoordinateSerializable c2 = (CoordinateSerializable) intent.getSerializableExtra("cSerializable");

        CoordinateParcelable c3 = intent.getParcelableExtra("cParcelable");
        initInstance();
    }

    private void initInstance() {
        editText = findViewById(R.id.secondEditText);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setText(String.format(Locale.ENGLISH, "Result = %d", sum));
        okBtn = findViewById(R.id.second_ok_btn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", editText.getText().toString());
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
