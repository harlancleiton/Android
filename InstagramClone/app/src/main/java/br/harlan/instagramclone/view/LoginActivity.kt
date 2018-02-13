package br.harlan.instagramclone.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.harlan.instagramclone.R
import br.harlan.instagramclone.business.UserBusiness
import br.harlan.instagramclone.factory.UserFactory
import br.harlan.instagramclone.model.UserModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity {

    //region Variables and Construtor
    private lateinit var btnLogin: Button
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var tvRegistrion: TextView
    private lateinit var tvForgotPassword: TextView

    constructor() : super(R.layout.activity_login)
    //region Variables and Construtor

    override fun addEvents() {
        btnLogin.setOnClickListener {
            loginUser()
        }
        tvRegistrion.setOnClickListener{
            navigationService.navigateTo(RegistrionActivity::class.java)
        }
        tvForgotPassword.setOnClickListener {

        }
    }

    private fun loginUser() {
        var userModel: UserModel = UserFactory(edtUsername.text.toString(), edtPassword.text.toString()).getObject() as UserModel
        UserBusiness(messageService, navigationService).validateLogin(userModel)
    }

    override fun initializeComponents() {
        btnLogin = btn_login
        edtUsername = edt_usuario_login
        edtPassword = edt_senha_login
        tvRegistrion = tv_registro_login
        tvForgotPassword = tv_esqueci_senha_login
    }
}
