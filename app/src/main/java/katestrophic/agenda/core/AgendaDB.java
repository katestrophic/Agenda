package katestrophic.agenda.core;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import katestrophic.agenda.entities.SectionDao;
import katestrophic.agenda.entities.SectionEntity;
import katestrophic.agenda.entities.UserDao;
import katestrophic.agenda.entities.UserProfile;
import katestrophic.agenda.utils.Constants;
import katestrophic.agenda.entities.Converter;

@Database(entities = {UserProfile.class, SectionEntity.class}, version = 1, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class AgendaDB extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract SectionDao sectionDao();

    private static volatile AgendaDB INSTANCE;

    public static AgendaDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AgendaDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AgendaDB.class, Constants.LOCAL_DB_NAME)
                            .fallbackToDestructiveMigration() // Useful during development
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}