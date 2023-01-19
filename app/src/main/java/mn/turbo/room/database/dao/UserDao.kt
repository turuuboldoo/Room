package mn.turbo.room.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mn.turbo.room.database.entity.School
import mn.turbo.room.database.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("select * from users")
    suspend fun getUsers(): List<User>

    @Query("select * from users where name = :userName")
    suspend fun getUserByName(userName: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Query("select * from schools")
    suspend fun getSchools(): List<School>
}
