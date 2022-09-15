package mn.turbo.room

import androidx.room.Room
import mn.turbo.room.database.UserDatabase
import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserMigrationTest {

    @get:Rule
    val helper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        UserDatabase::class.java,
        listOf(UserDatabase.Migration2To3()),
        FrameworkSQLiteOpenHelperFactory()
    )

    @Test
    fun migration1To2_containsCorrectData() {
        var db = helper.createDatabase(DB_NAME, 1)
            .apply {
                execSQL("INSERT INTO users VALUES ('test@test.com','turbo')")
                close()
            }

        db = helper.runMigrationsAndValidate(DB_NAME, 2, true)

        db.query("SELECT * FROM users")
            .apply {
                assertThat(moveToFirst()).isTrue()
                assertThat(getLong(getColumnIndex("created"))).isEqualTo(0)
            }
    }

    @Test
    fun testAllMigrations() {
        helper.createDatabase(DB_NAME, 1).apply { close() }

        Room.databaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            UserDatabase::class.java,
            DB_NAME
        ).addMigrations(UserDatabase.migration3To4).build()
            .apply {
                openHelper.writableDatabase.close()
            }
    }
}

private const val DB_NAME = "test.db"