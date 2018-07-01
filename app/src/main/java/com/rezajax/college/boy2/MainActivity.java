package com.rezajax.college.boy2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.rezajax.college.boy2.Downloader.CatParser;
import com.rezajax.college.boy2.Downloader.JSONDownloader;
import com.rezajax.college.boy2.Fragment.AccountFragment;
import com.rezajax.college.boy2.Fragment.HomeFragment;
import com.rezajax.college.boy2.Fragment.SettingFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String url_cat = "http://rezajax.ir/boy2/get_cat.php";
    private final String url_powerpoint = "";

    ViewPager viewPager;
    TabLayout tabLayout;

    private int[] tabIcons = {
            R.drawable.ic_home,
            R.drawable.ic_account,
            R.drawable.ic_exit
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view); //initializes list of items in navigationdrawer
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(0).setChecked(true);//sets "Main" as checked
        onNavigationItemSelected(navigationView.getMenu().getItem(0)); //run Main fragment

        MenuItem nav_home = findViewById(R.id.nav_home);
       // applyFontToMenuItem(nav_home);

        TextView tx = findViewById(R.id.name_cat);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/AdobeArabic-Regular.ttf");
//        tx.setTypeface(font);

        //make_category_list();
        //setupTabIcons();
    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/irsans.ttf");
//        Typeface font = getResources().getFont(R.font.irsans);
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    @Override
    protected void onResume() {
        super.onResume();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int id) {
        Fragment fragment = null;

        switch (id) {
            case R.id.nav_home:
                fragment = new HomeFragment();

//                HomeFragment fm = new HomeFragment() ;
//                fm.make_category_list();

                make_category_list();
                break;
            case R.id.nav_account:
                fragment = new AccountFragment();
                break;
            case R.id.nav_setting:
                Intent intent = new Intent(MainActivity.this , SettingActivity.class);
                MainActivity.this.startActivity(intent);

                fragment = new SettingFragment();
                viewPager = findViewById(R.id.viewpager);
                /*
                setupViewPager(viewPager);
                tabLayout = findViewById(R.id.tabs);
                tabLayout.setupWithViewPager(viewPager);
                */
                break;

            case R.id.nav_exit:
                finish();
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.nav_container , fragment);
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_account) {

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        displaySelectedScreen(id);
        return true;
    }


    public void make_category_list () {



        Thread t1 = new Thread(
            new Runnable() {
                @Override
                public void run() {

                    JSONDownloader downloader = new JSONDownloader();
                    String tmp = downloader.downloadURL( url_cat );

                    CatParser catParser = new CatParser();

                    List<HashMap<String , Object>> cats;
                    cats = catParser.parse( tmp );

                    String[] from = {"name" , "sum" }; //"name" , "PowerPoint" , "learn" , "sum"
                    int[] to = { R.id.name_cat, R.id.amount_cat };

                    final SimpleAdapter myAdapter = new SimpleAdapter(
                            getBaseContext() , cats , R.layout.cat_list_row , from , to
                    );

                    final ListView lv = (ListView) findViewById(R.id.category_list);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            lv.setAdapter(myAdapter);

                        }
                    });


                }
            }
        );


        t1.start();


    }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "ONE");
        adapter.addFragment(new SettingFragment(), "TWO"); //line 2 is problem title AppBar
        adapter.addFragment(new SettingFragment(), "THREE");
        adapter.addFragment(new AccountFragment(), "FOUR");
        adapter.addFragment(new AccountFragment(), "FIVE");
        adapter.addFragment(new AccountFragment(), "SIX");
        adapter.addFragment(new AccountFragment(), "SEVEN");
        adapter.addFragment(new AccountFragment(), "EIGHT");
        adapter.addFragment(new HomeFragment(), "NINE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}


