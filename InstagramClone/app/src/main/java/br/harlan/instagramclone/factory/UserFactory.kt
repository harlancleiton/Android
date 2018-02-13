package br.harlan.instagramclone.factory

import br.harlan.instagramclone.model.BaseModel
import br.harlan.instagramclone.model.UserModel

class UserFactory : ObjectFactory {
    private var username: String
    private lateinit var email: String
    private var password: String

    constructor(username: String, password: String){
        this.username = username
        this.password = password
        this.email = ""
    }

    constructor(username: String, email: String, password: String){
        this.username = username
        this.email = email
        this.password = password
    }

    override fun getObject(): BaseModel {
        var userModel: UserModel = UserModel()
        userModel.username = username
        userModel.email = email
        userModel.password = password
        userModel.className = userModel.CLASS_NAME_USER
        return userModel
    }
}