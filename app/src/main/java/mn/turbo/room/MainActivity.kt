package mn.turbo.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import mn.turbo.room.db.SchoolDatabase
import mn.turbo.room.db.entity.Director
import mn.turbo.room.db.entity.School
import mn.turbo.room.db.entity.Student
import mn.turbo.room.db.entity.Subject
import mn.turbo.room.db.entity.relations.StudentSubjectCrossRef
import mn.turbo.room.db.migration.UserDatabase
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var schoolDb: SchoolDatabase

    @Inject
    lateinit var userDb: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val schoolDao = schoolDb.schoolDao
        val userDao = userDb.userDao

        val directors = listOf(
            Director("Mike Litoris", "Jake Wharton School"),
            Director("Jack Goff", "Kotlin School"),
            Director("Chris P. Chicken", "JetBrains School")
        )
        val schools = listOf(
            School("Jake Wharton School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        val subjects = listOf(
            Subject("Dating for programmers"),
            Subject("Avoiding depression"),
            Subject("Bug Fix Meditation"),
            Subject("Logcat for Newbies"),
            Subject("How to use Google")
        )
        val students = listOf(
            Student("Beff Jezos", "2", "Kotlin School"),
            Student("Mark Suckerberg", "5", "Jake Wharton School"),
            Student("Gill Bates", "8", "Kotlin School"),
            Student("Donny Jepp", "1", "Kotlin School"),
            Student("Hom Tanks", "2", "JetBrains School")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Beff Jezos", "Dating for programmers"),
            StudentSubjectCrossRef("Beff Jezos", "Avoiding depression"),
            StudentSubjectCrossRef("Beff Jezos", "Bug Fix Meditation"),
            StudentSubjectCrossRef("Beff Jezos", "Logcat for Newbies"),
            StudentSubjectCrossRef("Mark Suckerberg", "Dating for programmers"),
            StudentSubjectCrossRef("Gill Bates", "How to use Google"),
            StudentSubjectCrossRef("Donny Jepp", "Logcat for Newbies"),
            StudentSubjectCrossRef("Hom Tanks", "Avoiding depression"),
            StudentSubjectCrossRef("Hom Tanks", "Dating for programmers")
        )

        lifecycleScope.launch {
            directors.forEach { schoolDao.insertDirector(it) }
            schools.forEach { schoolDao.insertSchool(it) }
            subjects.forEach { schoolDao.insertSubject(it) }
            students.forEach { schoolDao.insertStudent(it) }
            studentSubjectRelations.forEach { schoolDao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = schoolDao.getSchoolAndDirectorWithSchoolName("Kotlin School")
            Log.w("123123", "$schoolWithDirector")

            val schoolWithStudents = schoolDao.getSchoolWithStudents("Kotlin School")
            Log.w("123123", "$schoolWithStudents")

        }

        lifecycleScope.launch {
            val user = userDao.getUserById(1)
            Log.w("123123", "$user")
        }
    }

}
