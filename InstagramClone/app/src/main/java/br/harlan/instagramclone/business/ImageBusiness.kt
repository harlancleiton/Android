package br.harlan.instagramclone.business

import android.graphics.Bitmap
import br.harlan.instagramclone.business.services.MessageServiceable
import br.harlan.instagramclone.business.services.NavigationServiceable
import br.harlan.instagramclone.database.FileDatabase
import br.harlan.instagramclone.factory.ImageFactory
import br.harlan.instagramclone.model.ImageModel
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser
import java.io.ByteArrayOutputStream
import java.io.IOException

class ImageBusiness : BaseBusiness {

    constructor(messageService: MessageServiceable, navigationService: NavigationServiceable)
            : super(messageService, navigationService)

    fun shareImage(imageBitmap: Bitmap) {
        try {
            var imageModel: ImageModel = ImageFactory().getObject() as ImageModel
            var stream: ByteArrayOutputStream = ByteArrayOutputStream()
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            var byteAray: ByteArray = stream.toByteArray()
            var parseFile: ParseFile = ParseFile(imageModel.fileName, byteAray)
            var parseObject: ParseObject = ParseObject(imageModel.className)
            parseObject.put("userId", ParseUser.getCurrentUser().objectId)
            parseObject.put("image", parseFile)
            FileDatabase(taskService).sendFile(parseObject)
        } catch (e: IOException) {
            taskService.newError("Erro ao recuperar imagem: " + e.message)
        }
    }
}