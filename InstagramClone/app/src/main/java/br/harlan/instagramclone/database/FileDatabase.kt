package br.harlan.instagramclone.database

import android.widget.Toast
import br.harlan.instagramclone.database.services.TaskServiceable
import com.parse.ParseException
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.SaveCallback

class FileDatabase : BaseDatabase {
    constructor(taskService: TaskServiceable) : super(taskService)

    fun sendFile(parseObject: ParseObject){
        parseObject.saveInBackground(SaveCallback { e: ParseException? ->
            taskService.fileSent(e)
        })
    }
}