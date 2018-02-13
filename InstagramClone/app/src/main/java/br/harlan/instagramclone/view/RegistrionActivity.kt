package br.harlan.instagramclone.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.harlan.instagramclone.R
import br.harlan.instagramclone.business.UserBusiness
import br.harlan.instagramclone.factory.UserFactory
import br.harlan.instagramclone.model.UserModel
import kotlinx.android.synthetic.main.activity_registrion.*

class RegistrionActivity : BaseActivity {

    //region Variables and Constructor
    private lateinit var btnRegistrion: Button
    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var tvLogin: TextView
    private lateinit var tvForgotPassword: TextView

    constructor() : super(R.layout.activity_registrion)
    //endregion Variables and Constructor

    override fun addEvents() {
        btnRegistrion.setOnClickListener {
            registrionUser()
        }
        tvLogin.setOnClickListener {
            navigationService.navigateTo(LoginActivity::class.java)
        }
        tvForgotPassword.setOnClickListener {

        }
    }

    private fun registrionUser() {
        var userModel: UserModel = UserFactory(edtName.text.toString(), edtEmail.text.toString(), edtPassword.text.toString()).getObject() as UserModel
        UserBusiness(messageService, navigationService).registrionUser(userModel)
    }

    override fun initializeComponents() {
        btnRegistrion = btn_registrion
        edtName = edt_usuario_registrion
        edtEmail = edt_email_registrion
        edtPassword = edt_senha_registrion
        tvLogin = tv_login_registro
        tvForgotPassword = tv_esqueci_senha_registro
    }
}