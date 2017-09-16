package windcao.d1crash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.buttonC)
    Button buttonC;

    @BindView(R.id.buttonCT)
    Button buttonCT;

    @BindView(R.id.editTextDivTo)
    EditText editTextDivTo;

    @BindView(R.id.editTextTobeDiv)
    EditText editTextTobeDiv;

    @BindView(R.id.textViewResult)
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        initView();
    }


    private void initView() {
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
            }
        });

        buttonCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeWithTry();
            }
        });
    }

    private void compute() {
        int tobeDiv = Integer.valueOf(editTextTobeDiv.getText().toString());
        int divTo = Integer.valueOf(editTextDivTo.getText().toString());
        int result = tobeDiv / divTo;
        textViewResult.setText(String.format("%d", result));
    }

    private void computeWithTry() {
        int tobeDiv = Integer.valueOf(editTextTobeDiv.getText().toString());
        int divTo = Integer.valueOf(editTextDivTo.getText().toString());
        int result = 0;
        try {
            result = tobeDiv / divTo;
            textViewResult.setText(String.format("%d", result));
        } catch (Exception e) {
            textViewResult.setText(String.format("%s", e.getMessage()));
        }
    }
}
