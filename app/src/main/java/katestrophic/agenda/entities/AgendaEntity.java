package katestrophic.agenda.entities;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;
import java.util.UUID;

public abstract class AgendaEntity {
    @PrimaryKey @NonNull
    protected final String id;
    protected String name;
    protected String navPath; // e.g. "Notes/Calculus/Week1"

    public AgendaEntity(String name, String navPath) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.navPath = navPath;
    }

    @NonNull public String getId() { return id; }
    public String getName() { return name; }
    public String getNavPath() { return navPath; }

    public void setName(String name) { this.name = name; }
    public void setNavPath(String navPath) { this.navPath = navPath; }
}