package org.atctech.lowinternettv.activities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import org.atctech.lowinternettv.R;
import org.atctech.lowinternettv.fragments.HomePage_One;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomePage_One homePage_one = new HomePage_One();
        getSupportFragmentManager().beginTransaction().replace(R.id.main,homePage_one).commitAllowingStateLoss();

        HomePage_One homePage_2 = new HomePage_One();
        getSupportFragmentManager().beginTransaction().replace(R.id.recently_viewed_fragment,homePage_2).commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
