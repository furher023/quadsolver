package com.example.quadsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // to print x^2 using superscript tag of HTML
        ((TextView)findViewById(R.id.x2)).setText(Html.fromHtml("x<sup><small>2</small></sup>"));
    }
    // function called upon pressing the button; Note:- this kind of approach applicable only in main activity
    public void calc(View view) {
        double a, b, c;
        EditText val,val1,val2; //initializing variables of EditText to store information from edittext
        val = findViewById(R.id.a); // Locating the edit text
        a = Double.parseDouble(val.getText().toString()); // fetching text from EditText ; converting to string and then double
        val1 = findViewById(R.id.b);// findViewById() to locate the EditText
        b = Double.parseDouble(val1.getText().toString()); //getText() to fetch text ;toString() typecast to string
        val2 = findViewById(R.id.c);
        c = Double.parseDouble(val2.getText().toString());
        String res="Roots are:";
        ((TextView)findViewById(R.id.answer)).setText(res);//setText() to set the text in TextView
        solve(a, b, c);
    }
    //Function to calculate roots of quadratic equation and set its roots in TextView
    public void solve(double a,double b,double c) {


        double d;


        d = Math.pow(b, 2) - (4 * a * c);
        if (d < 0) {
            /* Toast formation
            Context context = getApplicationContext();
            CharSequence text = "Roots are Imaginary!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show(); */
            String response="Imaginary!!";
            TextView output1 = findViewById(R.id.root_1);
            output1.setText(response);
            TextView output2 = findViewById(R.id.root_2);
            output2.setText(response);


        } else if (d == 0) {
            double r;
            r = (-1 * b) / (2 * a);
            TextView output1 =  findViewById(R.id.root_1);
            output1.setText(String.valueOf(r)); //String.valueOf() explicit conversion to string
            TextView output2 =  findViewById(R.id.root_2);
            output2.setText(String.valueOf(r));
        } else {
            double r1, r2;
            r1 = ((-1 * b) + Math.sqrt(d)) / (2 * a);
            r2 = ((-1 * b) - Math.sqrt(d)) / (2 * a);
            TextView output1 =  findViewById(R.id.root_1);
            output1.setText(String.valueOf(r1));
            TextView output2 =  findViewById(R.id.root_2);
            output2.setText(String.valueOf(r2));
        }


    }

}
