package br.harlan.instagramclone.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.harlan.instagramclone.singleton.MessageServiceSingleton
import br.harlan.instagramclone.singleton.NavigationServiceSingleton
import br.harlan.instagramclone.view.services.MessageService
import br.harlan.instagramclone.view.services.NavigationService

abstract class BaseActivity : AppCompatActivity {

    //region Variables
    protected var navigationService: NavigationService = NavigationServiceSingleton.getInstance(this)
    protected val messageService: MessageService = MessageServiceSingleton.getInstance(this)
    protected var view: Int
    //endregion Variables

    //region Constructor and onCreate
    constructor(@LayoutRes view: Int){
        this.view = view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view)
        title = ""
        initializeComponents()
        addEvents()
    }
    //endregion Constructor and onCreate

    //region Abstract Functions
    abstract fun initializeComponents()
    abstract fun addEvents()
    //endregion Abstract Functions
}