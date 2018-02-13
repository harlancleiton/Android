package br.harlan.instagramclone.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import br.harlan.instagramclone.R
import br.harlan.instagramclone.adapter.SlidingTabLayout
import br.harlan.instagramclone.adapter.TabsAdapter
import br.harlan.instagramclone.business.ImageBusiness
import br.harlan.instagramclone.business.UserBusiness
import kotlinx.android.synthetic.main.activity_home.*
import java.io.File

class HomeActivity : BaseActivity {

    //region Variables and onCreateOptionsMenu
    private lateinit var toolbar: Toolbar
    private lateinit var slidingTabLayout: SlidingTabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var tabsAdapter: TabsAdapter

    constructor() : super(R.layout.activity_home)

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }
    //endregion Variables and onCreateOptionsMenu

    //region ActionsMenu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sair -> UserBusiness(messageService, navigationService).userLogOut()
            R.id.action_configuracoes -> messageService.newToast("Configurações")
            R.id.action_compartilhar -> navigationService.openGallery()
            R.id.action_direct -> navigationService.navigateTo(HomeActivity::class.java)
        }
        return true
    }
    //endregion ActionsMenu

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            var imageBitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, data.data)
            ImageBusiness(messageService, navigationService).shareImage(imageBitmap)
        }
    }

    override fun addEvents() {

    }

    override fun initializeComponents() {
        toolbar = toolbar_home as Toolbar
        toolbar.setLogo(R.drawable.instagramlogo)
        setSupportActionBar(toolbar)
        slidingTabLayout = sliding_tab_home
        viewPager = view_pager_home
        tabsAdapter = TabsAdapter(supportFragmentManager, this, navigationService)
        viewPager.adapter = tabsAdapter
        slidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_item_tab)
        slidingTabLayout.setDistributeEvenly(true)
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.darkerGray))
        slidingTabLayout.setViewPager(viewPager)
    }
}
