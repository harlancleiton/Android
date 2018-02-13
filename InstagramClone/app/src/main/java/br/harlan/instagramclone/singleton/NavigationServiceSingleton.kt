package br.harlan.instagramclone.singleton

import android.app.Activity
import android.support.v4.app.FragmentManager
import br.harlan.instagramclone.view.services.NavigationService

object NavigationServiceSingleton {
    private var navigationService: NavigationService? = null

    fun getInstance(activity: Activity): NavigationService {
        if (navigationService == null) {
            navigationService = NavigationService(activity)
        } else {
            navigationService!!.activity = activity
        }
        return navigationService as NavigationService
    }

    fun getInstance(activity: Activity, fragmentManager: FragmentManager, layout: Int): NavigationService {
        if (navigationService == null) {
            navigationService = NavigationService(activity, layout, fragmentManager)
        } else {
            navigationService!!.activity = activity
            navigationService!!.fragmentManager = fragmentManager
            navigationService!!.layout = layout
        }
        return navigationService as NavigationService
    }
}