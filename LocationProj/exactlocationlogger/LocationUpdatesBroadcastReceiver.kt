package com.google.android.gms.location.sample.exactlocationlogger

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.android.gms.location.LocationResult
import com.opencsv.CSVWriter
import java.io.File
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Receiver for handling location updates.
 */


class LocationUpdatesBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG, "Signal received")
        if (intent != null) {
            val action = intent.action
            if (ACTION_PROCESS_UPDATES == action) {
                val result = LocationResult.extractResult(intent)
                if (result != null) {
                    val locations = result.locations
                    val newloc = locations[0]
                    //--------------test code----------------------------
                    Log.i(TAG, "writing...")
                    val file = File(context.filesDir, "text")
                    val gpxfile = File(file, "exact.csv")

                    val current = LocalDateTime.now()
                    val formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm")
                    val formatted = current.format(formatter)

                    val writer = CSVWriter(FileWriter(gpxfile,true),
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END)

                    // feeding in array of data
                    val data = arrayOf<String>(
                        formatted,
                        newloc.latitude.toString(),
                        newloc.longitude.toString(),
                    )

                    writer.writeNext(data)
                    writer.close()
                    //---------------------------------------------------
                    Log.i(TAG, "write complete.")












                }
            }
        }







    }


    /**
     * Old test code attempting to make the background service run. Most of this is now unused.
     */
    companion object {
        private const val TAG = "LUBroadcastReceiver"
        const val ACTION_PROCESS_UPDATES =
            "com.google.android.gms.location.sample.locationupdatespendingintent.action" +
                    ".PROCESS_UPDATES"
        lateinit var wrfile : File




    }
}