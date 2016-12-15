package com.example.framgiamaidaidien.animatingfab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.framgiamaidaidien.animatingfab.adapter.SongsAdapter;
import com.example.framgiamaidaidien.animatingfab.model.Song;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView mRecyclerView;
    private List<Song> mAlbumList;
    private SongsAdapter mSongsAdapter;
    //Animations
    Animation show_fab_1, show_fab_2, show_fab_3;
    Animation hide_fab_1, hide_fab_2, hide_fab_3;
    FloatingActionButton fab1, fab2, fab3;
    private boolean mIsShowMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAlbumList = new ArrayList<>();
        mSongsAdapter = new SongsAdapter(this, mAlbumList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mSongsAdapter);

        prepareAlbums();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsShowMenu) {
                    hideMenu();
                    mIsShowMenu = false;
                } else {
                    displayMenu();
                    mIsShowMenu = true;
                }
            }
        });

        show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
        show_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_show);
        show_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_show);
        hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);
        hide_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_hide);
        hide_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_hide);
        fab1 = (FloatingActionButton) findViewById(R.id.fab_1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab_2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab_3);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.no_image,
                R.drawable.no_image,
                R.drawable.no_image,
                R.drawable.no_image,
                R.drawable.no_image,
                R.drawable.no_image,
                R.drawable.no_image,
                R.drawable.no_image,
                R.drawable.no_image,
                R.drawable.no_image,
                R.drawable.no_image};

        Song a = new Song("Black Beatles", "Rae Sremmurd, Gucci Mane ", covers[0]);
        mAlbumList.add(a);

        a = new Song("Starboy", "The Weeknd, Daft Punk", covers[1]);
        mAlbumList.add(a);

        a = new Song("Closer", "The Chainsmokers, Halsey", covers[2]);
        mAlbumList.add(a);

        a = new Song("Side to Side", "Ariana Grande, Nicky Minaj", covers[3]);
        mAlbumList.add(a);

        a = new Song("24k Magic", "Bruno Mars", covers[4]);
        mAlbumList.add(a);

        a = new Song("Juju On That Beat (TZ Anthem)", "Zay Hilfigerrr, Zayion McCall ", covers[5]);
        mAlbumList.add(a);

        a = new Song("Let Me Love You", "DJ Snake, Justin Bieber ", covers[6]);
        mAlbumList.add(a);

        a = new Song("Don't Wanna Know", "Maroon 5, Kendrick Lamar ", covers[7]);
        mAlbumList.add(a);

        a = new Song("Heathens", "Twenty One Pilots ", covers[8]);
        mAlbumList.add(a);

        a = new Song("Broccoli", "D.R.A.M., Lil Yachty ", covers[9]);
        mAlbumList.add(a);

        mSongsAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void displayMenu() {
        //fab1
        FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParams1.rightMargin += (int) (fab1.getWidth() * 1.7);
        layoutParams1.bottomMargin += (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParams1);
        fab1.startAnimation(show_fab_1);
        fab1.setClickable(true);
        fab1.setVisibility(View.VISIBLE);
        //fab2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParams2.rightMargin += (int) (fab2.getWidth() * 1.5);
        layoutParams2.bottomMargin += (int) (fab2.getHeight() * 1.5);
        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(show_fab_2);
        fab2.setClickable(true);
        fab2.setVisibility(View.VISIBLE);
        //fab3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
        layoutParams3.rightMargin += (int) (fab3.getWidth() * 0.25);
        layoutParams3.bottomMargin += (int) (fab3.getHeight() * 1.7);
        fab3.setLayoutParams(layoutParams3);
        fab3.startAnimation(show_fab_3);
        fab3.setClickable(true);
        fab3.setVisibility(View.VISIBLE);
    }

    private void hideMenu() {
        //fab1
        FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams) fab1.getLayoutParams();
        layoutParams1.rightMargin -= (int) (fab1.getWidth() * 1.7);
        layoutParams1.bottomMargin -= (int) (fab1.getHeight() * 0.25);
        fab1.setLayoutParams(layoutParams1);
        fab1.startAnimation(hide_fab_1);
        fab1.setClickable(false);
        fab1.setVisibility(View.INVISIBLE);
        //fab2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) fab2.getLayoutParams();
        layoutParams2.rightMargin -= (int) (fab2.getWidth() * 1.5);
        layoutParams2.bottomMargin -= (int) (fab2.getHeight() * 1.5);
        fab2.setLayoutParams(layoutParams2);
        fab2.startAnimation(hide_fab_2);
        fab2.setClickable(false);
        fab2.setVisibility(View.INVISIBLE);
        //fab3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) fab3.getLayoutParams();
        layoutParams3.rightMargin -= (int) (fab3.getWidth() * 0.25);
        layoutParams3.bottomMargin -= (int) (fab3.getHeight() * 1.7);
        fab3.setLayoutParams(layoutParams3);
        fab3.startAnimation(hide_fab_3);
        fab3.setClickable(false);
        fab3.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_1:
                Toast.makeText(this, "clicked on compass", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_2:
                Toast.makeText(this, "clicked on myplace", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_3:
                Toast.makeText(this, "clicked on share", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
