package com.hkm.gogosushi.main;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.hkm.gogosushi.R;
import com.hkm.longmenu.Bind;
import com.hkm.longmenu.LongMenuComponent;
import com.hkm.longmenu.menuitem;

/**
 * Created by hesk on 5/19/2015.
 */
public abstract class setup extends AppCompatActivity {
    protected void setupMenu() {
        LongMenuComponent fragment_byID = (LongMenuComponent) getFragmentManager().findFragmentById(R.id.menu);
        Bind b = new Bind(80, this);
        b.setItemHeight(90);
        b.setPattern(Bind.Pattern.GREEN);
        b.setIconPadding(0f);
        b.setWithSeparator(false);
        b.setResIdCompanyLogo(R.drawable.icoshlogo);
        b.setAddListMenu(new menuitem(R.drawable.home128, "Home"));
        b.setAddListMenu(new menuitem(R.drawable.helpquestionmark128, "Help"));
        b.setAddListMenu(new menuitem(R.drawable.paperplane128, "Paper"));
        b.setAddListMenu(new menuitem(R.drawable.settings128, "Settings"));
        b.setAddListMenu(new menuitem(R.drawable.gift128, "Settings"));
        b.setAddListMenu(new menuitem(R.drawable.roundbubbleheart128, "Settings"));
        b.setAddListMenu(new menuitem(R.drawable.wifi128, "Settings"));
        b.setAddListMenu(new menuitem(R.drawable.user128, "Settings"));
        b.setAddListMenu(new menuitem(R.drawable.diamond28, "Settings", menubig.class));
        b.setAddListMenu(new menuitem(R.drawable.controllerconsole128, "Settings"));
        b.setAddListMenu(new menuitem(R.drawable.paperplane128, "Paper"));
        b.setAddListMenu(new menuitem(R.drawable.settings128, "Settings"));
        b.setAddListMenu(new menuitem(R.drawable.gift128, "Settings"));
        b.setAddListMenu(new menuitem(R.drawable.roundbubbleheart128, "Settings"));
        b.setAddListMenu(new menuitem(R.drawable.wifi128, "Settings"));
        fragment_byID.init(b);
    }

    protected void slidcontent() {

    }

    protected abstract int getLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        setupMenu();
        slidcontent();
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
}
