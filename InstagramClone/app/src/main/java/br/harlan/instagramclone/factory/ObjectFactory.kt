package br.harlan.instagramclone.factory

import br.harlan.instagramclone.model.BaseModel

abstract class ObjectFactory {
    abstract fun getObject(): BaseModel
}