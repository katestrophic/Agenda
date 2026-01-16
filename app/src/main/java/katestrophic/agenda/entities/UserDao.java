package katestrophic.agenda.entities;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserProfile user);

    @Update
    void updateUser(UserProfile user);

    @Delete
    void deleteUser(UserProfile user);

    @Query("SELECT * FROM users")
    List<UserProfile> getAllUsers();

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    UserProfile getUserById(String id);
}
