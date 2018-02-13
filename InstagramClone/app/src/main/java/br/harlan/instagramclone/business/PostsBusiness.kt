package br.harlan.instagramclone.business

import android.widget.ArrayAdapter
import br.harlan.instagramclone.business.services.MessageServiceable
import br.harlan.instagramclone.business.services.NavigationServiceable
import br.harlan.instagramclone.database.PostsDatabase
import com.parse.ParseObject

class PostsBusiness : BaseBusiness {

    constructor(messageService: MessageServiceable, navigationService: NavigationServiceable)
            : super(messageService, navigationService)

    fun getPosts(parseObjects: ArrayList<ParseObject>, adapterParseObjects: ArrayAdapter<ParseObject>) {
        PostsDatabase(taskService).getPosts()
        taskService.waitForResult(parseObjects, adapterParseObjects)
    }
}