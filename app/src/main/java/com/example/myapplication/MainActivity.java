package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btadd;
    EditText fnum, snum;
    TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);

        btadd = findViewById(R.id.btadd);
        fnum = findViewById(R.id.fnum);
        snum = findViewById(R.id.snum);
        txtview = findViewById(R.id.txtView);

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fnumber = fnum.getText().toString();
                String snumber = snum.getText().toString();
                if (fnumber.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input 1st number", Toast.LENGTH_SHORT).show();
                } else if (snumber.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input 2nd number", Toast.LENGTH_SHORT).show();
                } else {
                    int num1 = Integer.parseInt(fnum.getText().toString());
                    int num2 = Integer.parseInt(snum.getText().toString());
                    int sum = Math.addExact(num1, num2);
                    txtview.setText(String.valueOf(sum));
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtview), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
