package example.com.android.triviaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher{


    private TextView textView;
    private EditText editText;
    private TextView scoreView;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) this.findViewById(R.id.question3);
        editText = (EditText) this.findViewById(R.id.edit);
        scoreView = (TextView) findViewById(R.id.points);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                score = score+1;
                updatePoints(score);

            }
        });

        Button firstbutton = findViewById(R.id.firstbtn);
        Button secondbutton = findViewById(R.id.secondbtn);
        Button thirdbutton = findViewById(R.id.thirdbtn);
        Button submitbutton = findViewById(R.id.SubmitAnswer);

         // we set listeners for the first,second and third buttons
        firstbutton.setOnClickListener(this);
        secondbutton.setOnClickListener(this);
        thirdbutton.setOnClickListener(this);
        // we set a listener for the submit button once it is clicked or pressed
        submitbutton.setOnClickListener(this);
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.jay_d:
                //checks if the first checkbox is checked and it awards a point
                if (checked) {
                    score = score + 1;
                    updatePoints(score);

                    //jason todd
                    Toast.makeText(MainActivity.this,"CORRECT", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.art_s:
                //checks if the second checkbox is checked and it awards a point
                if (checked) {
                    score = score + 1;
                    updatePoints(score);
                    //artemis
                    Toast.makeText(MainActivity.this,"CORRECT", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.biz_o:
                //checks if the third checkbox is checked and it awards a point
                if (checked) {
                    //bizarro
                    Toast.makeText(MainActivity.this,"CORRECT", Toast.LENGTH_SHORT).show();
                    score = score + 1;
                    updatePoints(score);

                }
                break;

            case R.id.con_k:
                //checks if the fourth checkbox is checked and it awards no point
                score = score + 0;
                updatePoints(score);
                // conner kent
                Toast.makeText(MainActivity.this,"wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            //checks if the first radio button is clicked or checked
            case R.id.fifthbtn:
                if (checked) {
                    score = score+0;
                    updatePoints(score);
                    Toast.makeText(MainActivity.this,"wrong", Toast.LENGTH_SHORT).show();
                }
                break;
            //checks if the second radio button is clicked or checked
            case R.id.sixthbtn:
                if (checked) {
                    score = score+0;
                    updatePoints(score);
                    Toast.makeText(MainActivity.this,"wrong", Toast.LENGTH_SHORT).show();
                }
                break;
            //checks if the third radio button is clicked or checked
            case R.id.seventhbtn:
                if (checked) {
                    score = score+1;
                    updatePoints(score);
                    Toast.makeText(MainActivity.this, "CORRECT", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void updatePoints(int score) {
        scoreView.setText("" + score);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //checks if the first button is clicked
            case R.id.firstbtn:
                Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                break;
            //checks if the first button is clicked
            case R.id.secondbtn:
                Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                break;
            //checks if the first button is clicked
            case R.id.thirdbtn:
                score = score+1;
                updatePoints(score);
                Toast.makeText(MainActivity.this, "CORRECT", Toast.LENGTH_SHORT).show();
                break;
                //checks if the submit button is pressed, outputs the the total score in by toasting it
            case  R.id.SubmitAnswer:
                Toast.makeText(MainActivity.this, "total score is \n" +score, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


    }

    @Override
    public void afterTextChanged(Editable editable) {
        // try and catch is used to catch any exception that may arise
        try {
            int namba = Integer.parseInt(editable.toString());
            // the statement checks if the text entered is equivalent to save and if it is then the score add to one then updated
            if (namba == 7) {
                score = score+1;
                updatePoints(score);
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT ).show();
            }
            else Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
        }
        catch (NumberFormatException e) {}
    }
}
