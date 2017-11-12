package th.in.pnnutkung.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private TextView tvResult;
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
        tvResult = findViewById(R.id.tvResult);
        tvResult.setText(String.format(Locale.ENGLISH, "Result = %d", sum));
    }
}
