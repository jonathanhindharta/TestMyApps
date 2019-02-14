package com.free.myapps.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.free.myapps.R;
import com.free.myapps.fragment.HomeFragment;
import com.free.myapps.fragment.ProfileFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.navigation)
    BottomNavigationView navigation;
    private int saveState;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.navigation_profile:
                    fragment = new ProfileFragment();

                    break;
                /*case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;*/
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new HomeFragment());
    }


    @Override
    protected void onResume() {
        super.onResume();
        navigation.setSelectedItemId(saveState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        saveState = navigation.getSelectedItemId();
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {exitYN();}

    public void exitYN(){
        AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this);
        ad.setTitle(getApplicationContext().getResources().getString(R.string.app_name));
        ad.setMessage(getApplicationContext().getResources().getString(R.string.sure_to_quit));
        ad.setPositiveButton(getApplicationContext().getResources().getString(R.string.yes),
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }});
        ad.setNegativeButton(getApplicationContext().getResources().getString(R.string.no),
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1) {
                    }});
        ad.show();
    }
}
