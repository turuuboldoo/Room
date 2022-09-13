package mn.turbo.room.db.migration

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 3, entities = [User::class])
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}
