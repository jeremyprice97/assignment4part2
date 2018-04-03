package cmsc355.assignmnet4part2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tenni_000 on 4/2/2018.
 */

public class Display extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
    }
    public void onSubmitClick(View v) {
        if(v.getId() == R.id.Bsubmit) {
            EditText synonym = (EditText) findViewById(R.id.Tsynonym);
            EditText antonym = (EditText) findViewById(R.id.Tantonym);

            String synonymStr = synonym.getText().toString();
            String antonymStr = antonym.getText().toString();

            Toast pass = Toast.makeText(Display.this , "Word pair entered into database", Toast.LENGTH_LONG);
            pass.show();

            Pairs p = new Pairs();
            p.setSynonym(synonymStr);
            p.setAntonym(antonymStr);

            helper.insertContact(p);

            Intent i = new Intent(Display.this, MainActivity.class);
            startActivity(i);

        }
    }
}
