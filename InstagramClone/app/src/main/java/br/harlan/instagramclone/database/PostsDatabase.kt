package br.harlan.instagramclone.database

import br.harlan.instagramclone.database.services.TaskServiceable
import com.parse.ParseException
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser

class PostsDatabase : BaseDatabase {

    constructor(taskService: TaskServiceable) : super(taskService)

    fun getPosts() {
        var parseQuery: ParseQuery<ParseObject> = ParseQuery.getQuery("Images")
        parseQuery.whereEqualTo("userId", ParseUser.getCurrentUser().objectId)
        parseQuery.orderByDescending("createdAt")
        parseQuery.findInBackground { objects: List<ParseObject>?, e: ParseException? ->
            taskService.recoveredPosts(objects, e)
        }
    }
}