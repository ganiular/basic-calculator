package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    TextView expressionView, resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expressionView = findViewById(R.id.expressionView);
        resultView = findViewById(R.id.resultView);

        findViewById(R.id.button_0).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_1).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_2).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_3).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_4).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_5).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_6).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_7).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_8).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_9).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_mod).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_div).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_mul).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_min).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_add).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_dot).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_ac).setOnClickListener(view -> clearAll(view));
        findViewById(R.id.button_c).setOnClickListener(view -> clearLast(view));
        findViewById(R.id.button_equ).setOnClickListener(view -> evaluate(view));
    }

    private void evaluate(View view) {
        try {
            String expressionText = expressionView.getText().toString();
            Expression expression = new ExpressionBuilder(expressionText).build();
            double result = expression.evaluate();
            String resultText = String.valueOf(result);
            if(resultText.endsWith(".0")){
                resultText = resultText.substring(0, resultText.length() - 2);
            }
            resultView.setText(resultText);
        } catch (Exception e){
            resultView.setText("Error");
        }
    }

    private void clearLast(View view) {
        String expressionText = expressionView.getText().toString();
        if(expressionText.length() > 0){
            expressionText = expressionText.substring(0, expressionText.length() - 1);
        }
        expressionView.setText(expressionText);
    }

    private void clearAll(View view) {
        expressionView.setText("");
        resultView.setText("0");
    }

    private void addViewTextToScreen(View view) {
        Button button = (Button) view;
        String expressionText = expressionView.getText().toString();
        expressionText += button.getText().toString();
        expressionView.setText(expressionText);
    }
}