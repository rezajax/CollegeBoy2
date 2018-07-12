package com.rezajax.college.boy2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        TextView mMessege = findViewById(R.id.card_text_text);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("text")!= null)
        {
            //TODO here get the string stored in the string variable and do
            // setText() on userName

            mMessege.setText(bundle.getString("text"));
        }

        if(bundle.getString("name")!= null)
        {
            toolbar.setTitle(bundle.getString("name"));
            setSupportActionBar(toolbar);
        }

        if(bundle.getString("image")!= null)
        {

            ImageView imageView = findViewById(R.id.image_header);
            imageView.setImageResource(R.drawable.plc);
        }




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "ذخیره شد", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_scrolling; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
