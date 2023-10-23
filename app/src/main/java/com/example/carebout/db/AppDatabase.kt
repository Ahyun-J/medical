package com.example.carebout.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.carebout.db.Clinic
import com.example.carebout.db.ClinicDao
import com.example.carebout.db.DailyTodo
import com.example.carebout.db.Inoculation
import com.example.carebout.db.InoculationDao
import com.example.carebout.db.Medicine
import com.example.carebout.db.MedicineDao
import com.example.carebout.db.TodoDao

@Database(entities = [DailyTodo::class, Medicine::class, Clinic::class, Inoculation::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTodoDao() : TodoDao
    abstract fun getMedicineDao() : MedicineDao
    abstract fun getClinicDao() : ClinicDao
    abstract fun getInocDao() : InoculationDao

    companion object{
        val databaseName = "carebout_db"
        var appDatabase : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase? {
            if(appDatabase == null) {
                appDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return appDatabase
        }
    }

}