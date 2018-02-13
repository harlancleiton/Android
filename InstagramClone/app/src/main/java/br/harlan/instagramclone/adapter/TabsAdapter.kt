package br.harlan.instagramclone.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.content.ContextCompat
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ImageSpan
import br.harlan.instagramclone.R
import br.harlan.instagramclone.view.HomeFragment
import br.harlan.instagramclone.view.UserFragment
import br.harlan.instagramclone.view.services.NavigationService

class TabsAdapter : FragmentStatePagerAdapter {

    private var context: Context
    //private val titleAbas: Array<String> = arrayOf("HOME", "USUÁRIOS")
    private val iconAbas: IntArray = intArrayOf(R.drawable.ic_home, R.drawable.ic_user)
    private var iconSize: Int = 0
    private val navigationService: NavigationService

    constructor(fragmentManager: FragmentManager, context: Context, navigationService: NavigationService) : super(fragmentManager) {
        this.context = context
        val escala: Float = context.resources.displayMetrics.density
        iconSize = ((36 * escala).toInt())
        this.navigationService = navigationService
    }

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = UserFragment()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        //return titleAbas[position]
        val drawable: Drawable = ContextCompat.getDrawable(context, iconAbas[position])
        drawable.setBounds(0, 0, iconSize, iconSize)
        val imageSpan: ImageSpan = ImageSpan(drawable)
        val spannableString: SpannableString = SpannableString(" ")
        spannableString.setSpan(imageSpan, 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableString
    }

    override fun getCount(): Int {
        return iconAbas.count()
    }
}