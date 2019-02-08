package nl.hva.msi.level1application_logica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText truetrueInput;
    private EditText truefalseInput;
    private EditText falsetrueInput;
    private EditText falsefalseInput;
    private Button submitButton;
    private int inputlength = 0;
    private String answer = "";


    private void reset() {
        truetrueInput.setText("");
        truefalseInput.setText("");
        falsetrueInput.setText("");
        falsefalseInput.setText("");
        inputlength = 0;
        answer = "";
    }

    private void answerCorrect() {
        Toast.makeText(this, "You are right everythings done!", Toast.LENGTH_SHORT).show();
        reset();
    }

    private void answerIncorrect(String answer) {
        Toast.makeText(this, "You are wrong try again! These are the wrong answers: " + answer, Toast.LENGTH_SHORT).show();
        reset();
    }


    public void checkInput(View view) {
        boolean solution = true;
        if (!truetrueInput.getText().toString().toUpperCase().equals("T")) {
            answer = answer + "T^T";
            solution = false;
        }
        if (!truefalseInput.getText().toString().toUpperCase().equals("F")) {
            solution = false;
            answer = answer + ", " + "T^F";
        }
        if (!falsetrueInput.getText().toString().toUpperCase().equals("F")) {
            answer = answer + ", " + "F^T";
            solution = false;
        }
        if (!falsefalseInput.getText().toString().toUpperCase().equals("T")) {
            solution = false;
            answer = answer + ", " + "F^F";
        }
        if (solution) {
            answerCorrect();
        } else {
            answerIncorrect(answer);
        }
        reset();
    }


    private void submit() {
        truetrueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                inputlength++;
                if (inputlength >= 4) {
                    submitButton.setEnabled(true);
                }
            }
        });
        truefalseInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                inputlength++;
                if (inputlength >= 4) {
                    submitButton.setEnabled(true);
                }
            }
        });
        falsetrueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                inputlength++;
                if (inputlength >= 4) {
                    submitButton.setEnabled(true);
                }
            }
        });
        falsefalseInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                inputlength++;
                if (inputlength >= 4) {
                    submitButton.setEnabled(true);
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        truetrueInput = findViewById(R.id.truetrueInput);
        truefalseInput = findViewById(R.id.truefalseInput);
        falsefalseInput = findViewById(R.id.falsfalseInput);
        falsetrueInput = findViewById(R.id.falsetrueInput);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setEnabled(false);

        submit();
    }
}
