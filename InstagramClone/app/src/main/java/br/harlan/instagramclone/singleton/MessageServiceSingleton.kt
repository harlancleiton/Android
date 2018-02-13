package br.harlan.instagramclone.singleton

import android.app.Activity
import android.content.Context
import br.harlan.instagramclone.view.services.MessageService

object MessageServiceSingleton {

    private var messageService: MessageService? = null

    fun getInstance(activity: Activity): MessageService {
        if (messageService == null)
            messageService = MessageService(activity)
        return messageService as MessageService
    }

    fun getInstance(context: Context): MessageService {
        if (messageService == null)
            messageService = MessageService(context)
        return messageService as MessageService
    }
}