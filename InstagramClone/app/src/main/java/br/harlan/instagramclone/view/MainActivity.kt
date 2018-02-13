package br.harlan.instagramclone.view

import android.os.Bundle
import br.harlan.instagramclone.R
import com.parse.Parse
import com.parse.ParseInstallation
import com.parse.ParseUser

class MainActivity : BaseActivity {

    //region Constructor and onCreator
    constructor() : super(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Parse.initialize(this)
        ParseInstallation.getCurrentInstallation().saveInBackground()
        checkLogin()
    }
    //endregion Constructor and onCreator

    private fun checkLogin() {
        if(ParseUser.getCurrentUser() != null)
            navigationService.navigateTo(HomeActivity::class.java)
        else
            navigationService.navigateTo(LoginActivity::class.java)
    }

    override fun addEvents() {}

    override fun initializeComponents() {}

}