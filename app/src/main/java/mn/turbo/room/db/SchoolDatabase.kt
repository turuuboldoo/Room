package mn.turbo.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import mn.turbo.room.db.dao.SchoolDao
import mn.turbo.room.db.entity.Director
import mn.turbo.room.db.entity.School
import mn.turbo.room.db.entity.Student
import mn.turbo.room.db.entity.Subject
import mn.turbo.room.db.entity.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract val schoolDao: SchoolDao

//    companion object {
//        @Volatile
//        private var INSTANCE: SchoolDatabase? = null
//
//        fun getInstance(context: Context): SchoolDatabase {
//            synchronized(this) {
//                return INSTANCE ?: Room.databaseBuilder(
//                    context.applicationContext,
//                    SchoolDatabase::class.java,
//                    "school_db"
//                ).build().also {
//                    INSTANCE = it
//                }
//            }
//        }
//    }
}
