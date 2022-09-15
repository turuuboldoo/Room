package mn.turbo.room.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mn.turbo.room.common.Constants
import mn.turbo.room.database.UserDatabase
import mn.turbo.room.database.dao.UserDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserDatabase {
        return Room
            .databaseBuilder(
                app.applicationContext,
                UserDatabase::class.java,
                Constants.USER_DATABASE_NAME
            )
            .addMigrations(UserDatabase.migration3To4)
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(
        database: UserDatabase
    ): UserDao {
        return database.userDao
    }
}