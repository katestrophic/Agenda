package katestrophic.agenda;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.Executors;
import katestrophic.agenda.core.AgendaDB;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Run on background thread to prevent "Application Not Responding" (ANR)
        Executors.newSingleThreadExecutor().execute(() -> {
            AgendaDB db = AgendaDB.getDatabase(this);
            int count = db.userDao().getUserCount();

            final Intent intent;
            if (count == 0) {
                // No users? Go to account setup
                //intent = new Intent(Launcher.this, CreateAccountActivity.class);
            } else {
                // Users exist? Go to profile selection
                //intent = new Intent(Launcher.this, LandingActivity.class);
            }

            // UI operations must run on the Main Thread
            runOnUiThread(() -> {
                //startActivity(intent);
                finish(); // Destroy launcher so user can't "Back" into it
            });
        });
    }
}