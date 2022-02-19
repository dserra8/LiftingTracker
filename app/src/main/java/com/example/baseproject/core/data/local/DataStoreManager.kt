package com.example.baseproject.core.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.*
import com.example.leagueapp1.util.DispatcherProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOError
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "Manager"

//Create data class to emit
/**
 * data clas Example(val num: Int)
 */

@Singleton
class DataStoreManager @Inject constructor(
    @ApplicationContext val context: Context,
    private val dispatcher: DispatcherProvider
) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = "preferences",
        scope = CoroutineScope(dispatcher.io)
    )

    val flow = context.dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.e(TAG, "Error reading preferences: ", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            // emit new values in a data class, get them from preferences variable

            /**
             * val example = preferences[PreferenceKeys.example]
             * Example(example)
             */

        }

    //update values
    suspend fun update(num: Int) {
        context.dataStore.edit { preferences ->

        }
    }

    //create object for Preference Keys
    /**
     * private object PreferenceKeys{
     *      val example = stringPreferencesKey("example")
     * }
     */

}