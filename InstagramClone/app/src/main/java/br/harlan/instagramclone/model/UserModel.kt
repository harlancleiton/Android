package br.harlan.instagramclone.model

class UserModel : BaseModel() {
    val CLASS_NAME_USER:String = "Users"
    lateinit var username: String
    lateinit var email: String
    lateinit var password: String
}