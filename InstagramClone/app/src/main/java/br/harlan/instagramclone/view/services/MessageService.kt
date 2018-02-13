package br.harlan.instagramclone.view.services

import android.app.Activity
import android.content.Context
import android.support.annotation.NonNull
import android.widget.Toast
import br.harlan.instagramclone.business.services.MessageServiceable

class MessageService : MessageServiceable {
    //region Variables and Constructor
    var activity: Activity? = null
    var context: Context? = null

    constructor(@NonNull activity: Activity) {
        this.activity = activity
        this.context = null
    }

    constructor(@NonNull context: Context) {
        this.context = context
        this.activity = null
    }
    //endregion Variables and Constructor

    override fun newToast(mensagem: String) {
        if (context == null) {
            Toast.makeText(activity, mensagem, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, mensagem, Toast.LENGTH_LONG).show()
        }
    }

    override fun newProgressDialog(titulo: String, mensagem: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateMessageProgressDialog(mensagem: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun newAlert(titulo: String, mensagem: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}