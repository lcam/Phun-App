package lcam.phunapp.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import lcam.phunapp.R;
import lcam.phunapp.model.Events;
import lcam.phunapp.presenter.GridPresenter;
import lcam.phunapp.services.ServiceGenerator;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvItems;
    private GridLayoutManager layoutManager;
    private ItemsAdapter adapter;
    int numColumn = 1;

    private GridPresenter mGridPresenter;
    private ServiceGenerator mNetworkService;
    //ArrayList<Tasks> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Phun App");
        setSupportActionBar(toolbar);

        mNetworkService = new ServiceGenerator(this);
        mGridPresenter = new GridPresenter(this, mNetworkService);

        rvItems = (RecyclerView)findViewById(R.id.rvEvents);
        getData();
        layoutManager = new GridLayoutManager(this, numColumn);
        rvItems.setLayoutManager(layoutManager);
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

    public void getData() {
        mGridPresenter.loadData();
    }

    public void updateList(List<Events> events) {
        adapter = new ItemsAdapter(getApplicationContext(), events);
        rvItems.setAdapter(adapter);
    }

    public void loadFailed() {
        Snackbar.make(rvItems, "Events could not be loaded", Snackbar.LENGTH_LONG).show();
    }
}
