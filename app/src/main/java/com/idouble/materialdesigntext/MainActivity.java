package com.idouble.materialdesigntext;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Picture picture;
    private List<Picture> pictureList = new ArrayList<> ();
    private PictureAdapter pictureAdapter;
    private RecyclerView recyclerView;
    private Picture[] pictures = {new Picture ("兔兔",R.drawable.a)
            ,new Picture ("兔兔",R.drawable.b),new Picture ("兔兔",R.drawable.c)
            ,new Picture ("兔兔",R.drawable.d),new Picture ("兔兔",R.drawable.e)
            ,new Picture ("兔兔",R.drawable.e),new Picture ("兔兔",R.drawable.f)
            ,new Picture ("兔兔",R.drawable.g),new Picture ("兔兔",R.drawable.h)
            ,new Picture ("兔兔",R.drawable.i),new Picture ("兔兔",R.drawable.j)
            ,new Picture ("兔兔",R.drawable.l),new Picture ("兔兔",R.drawable.m)
            ,new Picture ("兔兔",R.drawable.n),new Picture ("兔兔",R.drawable.o)
            ,new Picture ("兔兔",R.drawable.p),new Picture ("兔兔",R.drawable.q)
            ,new Picture ("兔兔",R.drawable.r),new Picture ("兔兔",R.drawable.s)
            ,new Picture ("兔兔",R.drawable.t)};
    private SwipeRefreshLayout swipeRefreshLayout;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        initPicture();
        recyclerView = (RecyclerView)findViewById (R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager (this,2);
        recyclerView.setLayoutManager (layoutManager);
        pictureAdapter = new PictureAdapter (pictureList);
        recyclerView.setAdapter (pictureAdapter);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById (R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources (R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener (new SwipeRefreshLayout.OnRefreshListener () {
            @Override
            public void onRefresh() {
                refreshPicture();
            }
        });
        Toolbar toolbar = (Toolbar)findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        NavigationView navigationView = (NavigationView)findViewById (R.id.nav_view);
        mDrawerLayout = (DrawerLayout)findViewById (R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar ();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled (true);
            actionBar.setHomeAsUpIndicator (R.drawable.ic_launcher_foreground);
        }
        navigationView.setCheckedItem (R.id.nav_call);
        navigationView.setNavigationItemSelectedListener (new NavigationView.OnNavigationItemSelectedListener () {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();

                return true;
            }
        });
        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById (R.id.fab);
        floatingActionButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (MainActivity.this,"FaB clicked ",Toast.LENGTH_SHORT).show ();
                 Snackbar.make (v,"Data deleted",Snackbar.LENGTH_SHORT)
                        .setAction ("Undo", new View.OnClickListener () {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText (MainActivity.this,"Data restored",Toast.LENGTH_SHORT).show ();

                            }
                        }).show ();
            }
        });


    }

    private void refreshPicture() {
        new Thread (new Runnable () {
            @Override
            public void run() {
                try {
                    Thread.sleep (2000);
                }catch (InterruptedException e){
                    e.printStackTrace ();
                }
                runOnUiThread (new Runnable () {
                    @Override
                    public void run() {
                        initPicture ();
                        pictureAdapter.notifyDataSetChanged ();
                        swipeRefreshLayout.setRefreshing (false);
                    }
                });
            }
        }).start ();
    }

    private void initPicture() {

        pictureList.clear ();

        for (int i = 0; i < 30; i++){
            Random random = new Random ();
            int index = random.nextInt (pictures.length);
            pictureList.add (pictures[index]);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater ().inflate (R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId ()){
           case R.id.backup:
               Toast.makeText (this,"You clicked Backup",Toast.LENGTH_SHORT).show ();
               break;
           case R.id.delete:
               Toast.makeText (this,"You clicked delete",Toast.LENGTH_SHORT).show ();
               break;
           case R.id.settings:
               Toast.makeText (this,"You clicked settings",Toast.LENGTH_SHORT).show ();
               break;
           case android.R.id.home:
               mDrawerLayout.openDrawer (GravityCompat.START);
               break;
               default:
                   break;
       }
       return true;
    }
}
