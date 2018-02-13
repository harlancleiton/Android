package br.harlan.instagramclone.database

import br.harlan.instagramclone.database.services.TaskServiceable

abstract class BaseDatabase (taskService: TaskServiceable) {
    val taskService:TaskServiceable = taskService
}