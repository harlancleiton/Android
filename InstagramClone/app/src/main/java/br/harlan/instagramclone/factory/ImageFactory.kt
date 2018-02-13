package br.harlan.instagramclone.factory

import br.harlan.instagramclone.model.BaseModel
import br.harlan.instagramclone.model.ImageModel
import br.harlan.instagramclone.util.CurrentDateTime

class ImageFactory : ObjectFactory() {

    override fun getObject(): BaseModel {
        var imageModel: ImageModel = ImageModel()
        //imageModel.file = file
        imageModel.format = imageModel.FORMAT_IMAGE_JPG
        imageModel.name = imageModel.IMAGE_BASE_NAME
        imageModel.fileName = imageModel.name + "_" + CurrentDateTime.currentDateTime + "." + imageModel.format
        imageModel.className = imageModel.CLASS_NAME_IMAGE
        return imageModel
    }
}