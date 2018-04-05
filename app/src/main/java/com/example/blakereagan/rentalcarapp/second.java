package com.example.blakereagan.rentalcarapp;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class second extends ListActivity {
    List<cars> carList = new ArrayList<cars>() ;

    public static final String KEY_Number = "a";
    public static final String KEY_Name = "b";
    public static final String KEY_Brand = "c";
    public static final String KEY_Color = "d";
    public static final String KEY_Cost = "e";
    public static final String KEY_Url = "f";
   // final SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_second);

        carList.add(new cars(1, "Spider",
                "Ferrari", "Blue",
                100.79, R.drawable.spider, "https://auto.ferrari.com/en_US/sports-cars-models/car-range/488-spider"));
        carList.add(new cars(2, "Senna",
                "McLaren", "Orange",
                110.89, R.drawable.mclaren, "http://cars.mclaren.com/ultimate-series/mclaren-senna"));
        carList.add(new cars(3, "Huracan",
                "Lamborghini", "White",
                120.88, R.drawable.lambo, "https://www.lamborghini.com/en-en/models/huracan"));
        carList.add(new cars(4, "GranTurismo",
                "Massarati", "Black",
                130.45, R.drawable.massarati, "http://www.maseratiusa.com/maserati/us/en/models/granturismo"));
        carList.add(new cars(5, "Mulsanne",
                "Bentley", "Black",
                140.78, R.drawable.bentley, "https://www.bentleymotors.com/en/models/mulsanne/mulsanne.html"));

        setListAdapter(new ArrayAdapter<cars>(second.this,
                R.layout.activity_second, R.id.textView, carList));


    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        final SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        String sName = carList.get(position).getName();

        int intid = carList.get(position).getId();
        String sid = Integer.toString(intid);


        String brand = carList.get(position).getBrand();

        String color = carList.get(position).getColor();

        SharedPreferences.Editor editor = pref.edit();

        double dblcost = carList.get(position).getRentalcost();
        //String rent = Double.toString(dblcost);

        String url = carList.get(position).getUrl();


        editor.putString(second.KEY_Name, sName);
        editor.putString(second.KEY_Number, sid);
        editor.putString(second.KEY_Brand, brand);
        editor.putString(second.KEY_Color, color);
     //   editor.putString(second.KEY_Cost, rent);
        editor.putFloat(second.KEY_Cost,(float) dblcost);
        editor.putString(second.KEY_Url, url);

        editor.commit();


        startActivity(new Intent(second.this, third.class));
    }

}
