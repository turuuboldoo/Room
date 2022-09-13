package mn.turbo.room.db.migration

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("select * from users where id = :userId")
    suspend fun getUserById(userId: Int): User

    @Query("select * from users where name = :userName")
    suspend fun getUserByName(userName: String): User
}