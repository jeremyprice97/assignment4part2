package cmsc355.assignmnet4part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClickFind(View v) {
        if (v.getId() == R.id.Bfind) {

            Intent i = new Intent(MainActivity.this, results.class);
            
            startActivity(i);
        }
    }
    public void onButtonClickVal(View v) {
        if (v.getId() == R.id.Bval) {
            Intent i = new Intent(MainActivity.this, Display.class);
            startActivity(i);
        }
    }
}