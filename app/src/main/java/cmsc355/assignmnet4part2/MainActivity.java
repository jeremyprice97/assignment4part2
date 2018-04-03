package cmsc355.assignmnet4part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClickFind(View v) {
        if (v.getId() == R.id.Bfind) {
            EditText a = (EditText)findViewById(R.id.Tword);
            String str = a.getText().toString();

            String antonym = helper.searchSynonym(str);

            if(str.equals(antonym)) {
                Intent i = new Intent(MainActivity.this, results.class);
                i.putExtra("Antonym", antonym);
                startActivity(i);
            }
            else {
                Toast pass = Toast.makeText(MainActivity.this , "No matching antonym found", Toast.LENGTH_SHORT);
                pass.show();
            }
        }
    }
    public void onButtonClickVal(View v) {
        if (v.getId() == R.id.Bval) {
            Intent i = new Intent(MainActivity.this, Display.class);
            startActivity(i);
        }
    }
}