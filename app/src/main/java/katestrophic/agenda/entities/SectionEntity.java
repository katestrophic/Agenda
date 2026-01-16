package katestrophic.agenda.entities;

import androidx.room.Entity;
import java.util.ArrayList;

@Entity(tableName = "sections")
public class SectionEntity extends AgendaEntity {
    private String colorHex;
    private String details;

    // store paths like: ["Notes", "Notes/Calc", "Assignments/Drafts"]
    private ArrayList<String> directoryNav;

    // CONSTRUCTOR
    public SectionEntity(String name, String colorHex, String details) {
        super(name, ""); // Section is the root, navPath is empty
        this.colorHex = colorHex;
        this.details = details;
        this.directoryNav = new ArrayList<>();
    }

    // GETTERS
    public String getColorHex() { return colorHex; }
    public String getDetails() { return details; }
    public ArrayList<String> getDirectoryNav() { return directoryNav; }

    // SETTERS
    public void setColorHex(String colorHex) { this.colorHex = colorHex; }
    public void setDetails(String details) { this.details = details; }
    public void setDirectoryMap(ArrayList<String> directoryNav) { this.directoryNav = directoryNav; }

    public void addDirectoryPath (String directoryPath){ directoryNav.add(directoryPath); }
}