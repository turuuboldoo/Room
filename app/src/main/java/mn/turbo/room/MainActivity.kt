package mn.turbo.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import mn.turbo.room.database.dao.UserDao
import mn.turbo.room.database.entity.School
import mn.turbo.room.database.entity.User
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            userDao.getSchools().forEach(::println)
        }

//        (1..10).forEach { number ->
//            lifecycleScope.launch {
//                userDao.insertSchool(
//                    School(
//                        name = "school_$number"
//                    )
//                )
//            }
//        }
    }

}
