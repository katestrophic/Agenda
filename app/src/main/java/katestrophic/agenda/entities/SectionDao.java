package katestrophic.agenda.entities;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface SectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSection(SectionEntity section);

    @Update
    void updateSection(SectionEntity section);

    @Delete
    void deleteSection(SectionEntity section);

    @Query("SELECT * FROM sections")
    List<SectionEntity> getAllSections();

    @Query("SELECT * FROM sections WHERE id = :id LIMIT 1")
    SectionEntity getSectionById(String id);
}
