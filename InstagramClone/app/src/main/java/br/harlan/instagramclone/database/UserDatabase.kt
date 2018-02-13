package br.harlan.instagramclone.database

import br.harlan.instagramclone.database.services.TaskServiceable
import br.harlan.instagramclone.model.UserModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.parse.ParseException
import com.parse.ParseUser

class UserDatabase : BaseDatabase {

    constructor(taskService: TaskServiceable) : super(taskService)

    fun registrionUser(userModel: UserModel) {
        val parseUser: ParseUser = ParseUser()
        parseUser.username = userModel.username
        parseUser.email = userModel.email
        parseUser.setPassword(userModel.password)
        parseUser.signUpInBackground { e: ParseException? ->
            taskService.registeredUser(e)
        }
    }

    fun validateLogin(userModel: UserModel) {
        ParseUser.logInInBackground(userModel.username, userModel.password) { user: ParseUser?, e: ParseException? ->
            taskService.sessionStarted(e)
        }
    }

    fun userLogOut() {
        ParseUser.logOutInBackground { e: ParseException? ->
            taskService.sessionClosed(e)
        }
    }
}