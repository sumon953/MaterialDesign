
package org.proverbio.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.proverbio.android.material.R;

/**
 * @author Juan Pablo Proverbio <proverbio8@gmail.com>
 */
public class DetailActivity extends BaseActivity
{
    public static final String SHARED_VIEW = "shared_view";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ImageView image = (ImageView) findViewById(R.id.image);
        ViewCompat.setTransitionName(image, SHARED_VIEW);
        Picasso.with(this).load(getIntent().getStringExtra(SHARED_VIEW)).into(image);
    }

    @Override
    protected int getLayoutResource()
    {
        return R.layout.activity_detail;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Launches an activity with a transition from the shared view
     * @param activity
     * @param transitionView
     * @param url
     */
    public static void launch(AppCompatActivity activity, View transitionView, String url)
    {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionView, SHARED_VIEW);
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(SHARED_VIEW, url);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
}
