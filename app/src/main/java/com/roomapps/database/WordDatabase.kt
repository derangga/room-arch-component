package com.roomapps.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/** TODO: 3. Buat database WordDb
 * tambahkan anotasi @Database.
 * Pada block entities adalah array of class yang memiliki anotasi @Entity
 */
@Database(entities = [Word::class], version = 2, exportSchema = false)
abstract class WordDatabase: RoomDatabase(){

    abstract fun wordDao(): WordDao

    companion object{
        @Volatile
        private var INSTANCE: WordDatabase? = null

        fun getDatabase(context: Context): WordDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "WordDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}