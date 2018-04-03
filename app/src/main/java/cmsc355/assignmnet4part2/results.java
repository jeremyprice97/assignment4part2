package cmsc355.assignmnet4part2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by tenni_000 on 4/2/2018.
 */

public class results extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        String antonym = getIntent().getStringExtra("Antonym");

        TextView antonymDisp = findViewById(R.id.TVantonym);
        antonymDisp.setText(antonym);
    }
}
