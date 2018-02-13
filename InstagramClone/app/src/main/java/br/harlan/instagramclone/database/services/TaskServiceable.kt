package br.harlan.instagramclone.database.services

import com.parse.ParseException
import com.parse.ParseObject

interface TaskServiceable {
    fun registeredUser(e: ParseException?)
    fun sessionClosed(e: ParseException?)
    fun sessionStarted(e: ParseException?)
    fun fileSent(e: ParseException?)
    fun recoveredPosts(objects: List<ParseObject>?, e: ParseException?)
}