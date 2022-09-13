package mn.turbo.room.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mn.turbo.room.common.Constants
import mn.turbo.room.db.SchoolDatabase
import mn.turbo.room.db.migration.MIGRATION_1_2
import mn.turbo.room.db.migration.MIGRATION_2_3
import mn.turbo.room.db.migration.UserDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): SchoolDatabase {
        return Room
            .databaseBuilder(
                app.applicationContext,
                SchoolDatabase::class.java,
                Constants.SCHOOL_DATABASE_NAME
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserDatabase {
        return Room
            .databaseBuilder(
                app.applicationContext,
                UserDatabase::class.java,
                Constants.USER_DATABASE_NAME
            )
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .build()
    }

}