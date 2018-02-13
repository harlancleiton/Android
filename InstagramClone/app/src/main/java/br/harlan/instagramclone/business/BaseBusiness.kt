package br.harlan.instagramclone.business

import br.harlan.instagramclone.business.services.MessageServiceable
import br.harlan.instagramclone.business.services.NavigationServiceable
import br.harlan.instagramclone.business.services.TaskService
import br.harlan.instagramclone.singleton.TaskServiceSingleton

abstract class BaseBusiness(messageService: MessageServiceable, navigationService: NavigationServiceable) {
    val taskService: TaskService = TaskServiceSingleton.getInstance(messageService, navigationService)
}
