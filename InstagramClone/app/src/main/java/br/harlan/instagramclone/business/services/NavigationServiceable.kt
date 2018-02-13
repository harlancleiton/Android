package br.harlan.instagramclone.business.services

import android.app.Activity
import android.support.v4.app.Fragment

interface NavigationServiceable {
    fun navigateTo(cls: Class<*>)
    fun navigateTo(cls: Class<*>, closeActivity: Boolean)
    fun loadFragment(fragment: Fragment)
}