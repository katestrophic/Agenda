package katestrophic.agenda.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.UUID;

@Entity(tableName = "users")
public class UserProfile {
    @PrimaryKey @NonNull @ColumnInfo(name = "id") private final String id;
    @ColumnInfo(name = "username") private String username;
    @ColumnInfo(name = "password") private String passcode;
    @ColumnInfo(name = "sections") private ArrayList<String> sectionIds;


    // CONSTRUCTORS
    public UserProfile(@NonNull String id, String username, String passcode, ArrayList<String>sectionIds){
        this.id = UUID.fromString(id).toString();
        this.username = username;
        this.passcode = passcode;
        this.sectionIds = sectionIds != null ? sectionIds : new ArrayList<>();
    }
    @Ignore
    public UserProfile(String username, String passcode){
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.passcode = passcode;
        this.sectionIds = new ArrayList<>();
    }

    // GETTERS
    @NonNull public String getId(){ return id; }
    public String getUsername(){ return username; }
    public String getPasscode(){ return passcode; }
    public ArrayList<String> getSectionIds(){ return sectionIds; }

    // SETTERS
    private void setPasscode(String passcode){ this.passcode = passcode; }
    private void setUsername(String username){ this.username = username; }

    private void addSection(String sectionId){
        if (!sectionIds.contains(sectionId)){
            sectionIds.add(sectionId);
        }
    }
    private void removeSection(String sectionId){ sectionIds.remove(sectionId); }
}