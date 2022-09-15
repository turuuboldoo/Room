package mn.turbo.room.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import mn.turbo.room.database.dao.UserDao
import mn.turbo.room.database.entity.School
import mn.turbo.room.database.entity.User

@Database(
    version = 4,
    entities = [User::class, School::class],
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = UserDatabase.Migration2To3::class)
    ]
)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    @RenameColumn(tableName = "users", fromColumnName = "created", toColumnName = "createdAt")
    class Migration2To3 : AutoMigrationSpec

    companion object {
        val migration3To4: Migration = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS schools (name CHAR NOT NULL PRIMARY KEY)"
                )
            }
        }
    }

}
