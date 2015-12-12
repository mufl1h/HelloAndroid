package hello.example.com.firebase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

import adapter.ChatAdapter;
import hello.example.com.firebase.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText inputMessage;
    private ChatAdapter adapter1;
    private List<User> chatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Firebase.setAndroidContext(this);
        Firebase fb = new Firebase("https://fiery-inferno-5811.firebaseio.com/Tes");

        List<User> lsUser = new ArrayList<>();
        lsUser.add(new User("muflih1", "muflih1@kulina.id"));
        lsUser.add(new User("muflih2", "muflih2@kulina.id"));
        lsUser.add(new User("muflih3", "muflih3@kulina.id"));
        lsUser.add(new User("muflih4", "muflih4@kulina.id"));
        for(User u : lsUser){
            fb.push().setValue(u);
        }
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
