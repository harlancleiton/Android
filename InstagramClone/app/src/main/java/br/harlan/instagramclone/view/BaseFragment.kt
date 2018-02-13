package br.harlan.instagramclone.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.harlan.instagramclone.singleton.MessageServiceSingleton
import br.harlan.instagramclone.singleton.NavigationServiceSingleton
import br.harlan.instagramclone.view.services.MessageService
import br.harlan.instagramclone.view.services.NavigationService

abstract class BaseFragment : Fragment {

    //region Variables
    protected lateinit var viewRoot: View
    protected var layout: Int
    protected lateinit var navigationService: NavigationService
    protected lateinit var messageService: MessageService
    //endregion Variables

    //region Constructor and onCreate
    constructor(@LayoutRes layout: Int){
        this.layout = layout
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewRoot = inflater!!.inflate(layout, container, false)
        navigationService = NavigationServiceSingleton.getInstance(activity)
        messageService = MessageServiceSingleton.getInstance(activity)
        addEvents()
        initializeComponents(viewRoot)
        return viewRoot
    }
    //endregion Constructor and onCreate

    //region Abstract Functions
    abstract fun initializeComponents(viewRoot: View)
    abstract fun addEvents()
    //endregion Abstract Functions
}