package br.harlan.instagramclone.business

import br.harlan.instagramclone.business.services.MessageServiceable
import br.harlan.instagramclone.business.services.NavigationServiceable
import br.harlan.instagramclone.database.UserDatabase
import br.harlan.instagramclone.model.UserModel
import com.parse.ParseUser

class UserBusiness : BaseBusiness {

    constructor(messageService: MessageServiceable, navigationService: NavigationServiceable) :
            super(messageService, navigationService)

    fun registrionUser(userModel: UserModel) {
        if (validadeRegistrionUser(userModel))
            UserDatabase(taskService).registrionUser(userModel)
        else
            taskService.newError("Houve um erro ao validar os dados digitados")
    }

    fun validateLogin(userModel: UserModel) {
        if(validadeLoginUser(userModel))
            UserDatabase(taskService).validateLogin(userModel)
        else
            taskService.newError("Houve um erro ao validar os dados digitados")
    }

    fun userLogOut() {
        if (isUserConnected())
            UserDatabase(taskService).userLogOut()
        else
            taskService.newError("Usuário não se encontra logado.")
    }

    private fun validadeLoginUser(userModel: UserModel): Boolean {
        if (!userModel!!.username.isEmpty() || !userModel.password.isEmpty())
            return true
        else
            return false
    }

    private fun validadeRegistrionUser(userModel: UserModel): Boolean {
        if (!userModel!!.username.isEmpty() || !userModel!!.email.isEmpty() || !userModel.password.isEmpty())
            return true
        else
            return false
    }

    private fun isUserConnected(): Boolean {
        if (ParseUser.getCurrentUser() != null)
            return true
        else
            return false
    }
}