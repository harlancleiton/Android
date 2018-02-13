package br.harlan.instagramclone.singleton

import br.harlan.instagramclone.business.services.MessageServiceable
import br.harlan.instagramclone.business.services.NavigationServiceable
import br.harlan.instagramclone.business.services.TaskService

object TaskServiceSingleton {
    private var taskService: TaskService? = null

    fun getInstance(messageService: MessageServiceable, navigationService: NavigationServiceable): TaskService {
        if (taskService == null)
            taskService = TaskService(messageService, navigationService)
        return taskService as TaskService
    }
}