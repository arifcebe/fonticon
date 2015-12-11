package com.arifcebe.sampleicontext;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vinexs.mdicon.MaterialIcon;

public class MainActivity extends AppCompatActivity {

    private MaterialIcon md;
    private ImageView imgView;
    private TextView tv;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        md = new MaterialIcon(this);
        md.setTheme(MaterialIcon.THEME_FREE);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgView = (ImageView) findViewById(R.id.imgView);
        tv = (TextView) findViewById(R.id.hellos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgView.setImageDrawable(MaterialIcon.getDrawable(MainActivity.this,
                        getResources().getString(R.string.ic_3d_rotation),
                        getResources().getColor(R.color.colorPrimary)));

                tv.setBackground(MaterialIcon.getDrawable(MainActivity.this,
                        getResources().getString(R.string.ic_account_box),
                        getResources().getColor(R.color.colorAccent)));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        loadIconFont(menu);
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

    private void loadIconFont(Menu menu){
        menu.clear();
        md.setColor(getResources().getColor(R.color.colorAccent));

       /* MenuItem item1 = menu.add("title 1")
                .setIcon(md.getDrawable(getResources().getString(R.string.ic_account_circle)));
        item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        MenuItem item2 = menu.add("title 2")
                .setIcon(md.getDrawable(getResources().getString(R.string.ic_account_box)));
        item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);*/
        MenuItem test1 = menu.add("Material Icon").setIcon(
                md.getMenuDrawable(getResources().getString(R.string.ic_account_circle)));
        test1.setShowAsAction( MenuItem.SHOW_AS_ACTION_ALWAYS );

        MenuItem test2 = menu.add("Material Icon").setIcon(
                md.getMenuDrawable(getResources().getString(R.string.ic_account_box)));
        test2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

    }
}
