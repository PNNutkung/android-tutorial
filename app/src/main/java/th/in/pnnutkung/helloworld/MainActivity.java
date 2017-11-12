package th.in.pnnutkung.helloworld;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    private EditText editText1;
    private EditText editText2;
    private Button btnCalculate;
    private RadioGroup rbGroup;
    private CustomViewGroup customViewGroup1;
    private CustomViewGroup customViewGroup2;
    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Toast.makeText(MainActivity.this, String.format(Locale.ENGLISH, "Width = %d, Height = %d", width, height), Toast.LENGTH_SHORT).show();
        initInstances();
    }

    private void initInstances() {
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);
        rbGroup = findViewById(R.id.rbGroup);
        customViewGroup1 = findViewById(R.id.viewGroup1);
        customViewGroup2 = findViewById(R.id.viewGroup2);
        customViewGroup1.setButtonText("Hello");
        customViewGroup2.setButtonText("World");
    }

    @Override
    public void onClick(View view) {
        if (view == btnCalculate) {
            int text1 = 0;
            int text2 = 0;
            sum = 0;
            try {
                text1 = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException nfe) {
                Toast.makeText(MainActivity.this, "Please type a number to the left dialog", Toast.LENGTH_SHORT).show();
            }
            try {
                text2 = Integer.parseInt(editText2.getText().toString());
            } catch (NumberFormatException nfe) {
                Toast.makeText(MainActivity.this, "Please type a number to the right dialog", Toast.LENGTH_SHORT).show();
            }
            try {
                switch (rbGroup.getCheckedRadioButtonId()) {
                    case R.id.rbPlus:
                        sum = text1 + text2;
                        break;
                    case R.id.rbMinus:
                        sum = text1 - text2;
                        break;
                    case R.id.rbMultiply:
                        sum = text1 * text2;
                        break;
                    case R.id.rbDivide:
                        sum = text1 / text2;
                        break;
                }
                tvResult.setText(String.format(Locale.ENGLISH, "=%d", sum));
                Log.d("Calculation", String.format("%d", sum));
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("result", sum);

                Coordinate c1 = new Coordinate();
                c1.x = 5;
                c1.y = 10;
                c1.z = 20;
                Bundle bundle = new Bundle();
                bundle.putInt("x", c1.x);
                bundle.putInt("y", c1.y);
                bundle.putInt("z", c1.z);
                intent.putExtra("cBundle", bundle);

                CoordinateSerializable c2 = new CoordinateSerializable();
                c2.x = 5;
                c2.y = 10;
                c2.z = 20;
                intent.putExtra("cSerializable", c2);

                CoordinateParcelable c3 = new CoordinateParcelable();
                c3.x = 5;
                c3.y = 10;
                c3.z = 20;
                intent.putExtra("cParcelable", c3);

                //startActivity(intent);
            } catch (ArithmeticException ae) {
                Toast.makeText(MainActivity.this, "You should not divide by zero", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
