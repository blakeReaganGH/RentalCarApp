package com.example.blakereagan.rentalcarapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

import java.text.DecimalFormat;

public class third extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        final TextView txtid = (TextView)findViewById(R.id.textView2);
        final TextView txtname = (TextView)findViewById(R.id.textView3);
        final TextView txtbrand = (TextView)findViewById(R.id.textView4);
        final TextView txtcolor = (TextView)findViewById(R.id.textView5);
        final TextView txtcost = (TextView)findViewById(R.id.textView6);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(third.this);

        String name = pref.getString(second.KEY_Name, " ");
        txtname.setText("Name: "+name);

        String idd = pref.getString(second.KEY_Number, " ");
        txtid.setText("Id: "+idd);

        String brand = pref.getString(second.KEY_Brand, " ");
        txtbrand.setText("Brand: "+brand);

        String color = pref.getString(second.KEY_Color, " ");
        txtcolor.setText("Color: "+color);

        final float fltInterest = pref.getFloat(second.KEY_Cost, 0);
        txtcost.setText("Rental Cost Per Day: $"+fltInterest);

        final String url = pref.getString(second.KEY_Url, " ");

        Button totcost = findViewById(R.id.button);
        totcost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText year = findViewById(R.id.editText);
                int intNumberOfYears = Integer.parseInt(year.getText().toString());
                double totCost = fltInterest * intNumberOfYears;

                if (intNumberOfYears > 30)
                {
                    Toast toast1 = Toast.makeText(third.this, "Call the number: 1-800-777-2222",Toast.LENGTH_LONG);
                    toast1.show();
                }
                else{

                    DecimalFormat formatter = new DecimalFormat("$###,###.##");

                    Toast toast = Toast.makeText(third.this, "Total Rent Cost: "+formatter.format(totCost),Toast.LENGTH_LONG);
                    toast.show();

                }

            }

        });
        Button info = findViewById(R.id.button2);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  Toast toast2 = Toast.makeText(third.this, url,Toast.LENGTH_LONG);
              //  toast2.show();

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));


            }

        });

    }
}
