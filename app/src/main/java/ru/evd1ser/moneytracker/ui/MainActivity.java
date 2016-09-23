package ru.evd1ser.moneytracker.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ru.evd1ser.moneytracker.R;
import ru.evd1ser.moneytracker.ui.fragments.CategoriesFragment;
import ru.evd1ser.moneytracker.ui.fragments.ExpensesFragment;
import ru.evd1ser.moneytracker.ui.fragments.SettingsFragment;
import ru.evd1ser.moneytracker.ui.fragments.StatisticsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    /**
     * homework 2
     */
    private Toolbar toolbar;

    private void setupActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    private void setupDrawerLayout() {
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawerLayout != null;
        drawerLayout.addDrawerListener(toggle);
        //drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
        setTitle(getString(R.string.app_name));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        setupActionBar();
        setupDrawerLayout();
        if (savedInstanceState == null){
            replaceFragment(new ExpensesFragment());
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.main_container, new ExpensesFragment(),
//                            ExpensesFragment.class.getSimpleName())
//                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.drawer_expenses) {
            setTitle(R.string.nav_drawer_expenses);

            navigationView.setCheckedItem(R.id.drawer_expenses);

            replaceFragment(new ExpensesFragment());

        } else if (id == R.id.drawer_categories) {
            setTitle(R.string.nav_drawer_categories);

            navigationView.setCheckedItem(R.id.drawer_categories);

            replaceFragment(new CategoriesFragment());


        } else if (id == R.id.drawer_statistics) {

            setTitle(R.string.nav_drawer_statistics);

            navigationView.setCheckedItem(R.id.drawer_statistics);

            replaceFragment(new StatisticsFragment());

        } else if (id == R.id.drawer_settings) {

            setTitle(R.string.nav_drawer_settings);

            navigationView.setCheckedItem(R.id.drawer_settings);

            replaceFragment(new SettingsFragment());

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * homework 1
     */


//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d(LOG_TAG, "onStart");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d(LOG_TAG, "onResume");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d(LOG_TAG, "onStop");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d(LOG_TAG, "onRestart");
//    }
    private void replaceFragment(Fragment fragment) {
        String backStackName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStackName, 0);

        if (! fragmentPopped && manager.findFragmentByTag(backStackName) == null) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.main_container, fragment, backStackName);
            ft.addToBackStack(backStackName);
            ft.commit();
        }
    }
}
