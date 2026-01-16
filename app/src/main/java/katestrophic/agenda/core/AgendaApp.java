package katestrophic.agenda.core;

import android.app.Application;
import java.io.File;
import katestrophic.agenda.utils.Constants;

public class AgendaApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 1. Initialize the Database Singleton
        AgendaDB.getDatabase(this);

        // 2. Ensure the global root directory exists
        File root = new File(getFilesDir(), Constants.DEFAULT_ROOT_PATH);
        if (!root.exists()) {
            root.mkdirs();
        }
    }
}