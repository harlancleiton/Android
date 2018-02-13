package br.harlan.instagramclone.view.services

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.support.annotation.IdRes
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Toast
import br.harlan.instagramclone.business.services.NavigationServiceable

class NavigationService : NavigationServiceable {

    //region Variables and Constructor
    var activity: Activity
    var fragmentManager: FragmentManager? = null
    var layout: Int? = null

    constructor(@NonNull activity: Activity) {
        this.activity = activity
    }

    constructor(@NonNull activity: Activity, @IdRes layout: Int, @NonNull fragmentManager: FragmentManager) {
        this.activity = activity
        this.layout = layout
        this.fragmentManager = fragmentManager
    }
    //endregion Variables and Constructor

    override fun navigateTo(cls: Class<*>) {
        if (activity != null) {
            activity.startActivity(Intent(activity, cls))
            activity.finish()
        }
    }

    override fun navigateTo(cls: Class<*>, closeActivity: Boolean) {
        if (activity != null) {
            activity.startActivity(Intent(activity, cls))
            if (closeActivity)
                activity.finish()
        }
    }

    override fun loadFragment(@NonNull fragment: Fragment) {
        if (fragmentManager != null || layout != null)
            fragmentManager!!.beginTransaction().replace(layout!!, fragment).commit()
        else
            Toast.makeText(activity, "Erro ao mudar o contexto da aplicação", Toast.LENGTH_LONG).show()
    }

    fun openGallery(){
        val intent: Intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        activity.startActivityForResult(intent, 1)
    }
}