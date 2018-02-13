package br.harlan.instagramclone.model

import java.io.File

class ImageModel : BaseModel() {
    val CLASS_NAME_IMAGE: String = "Images"
    val IMAGE_BASE_NAME: String = "InstagramClone"
    val FORMAT_IMAGE_PNG: String = "png"
    val FORMAT_IMAGE_JPG: String = "jpg"
    lateinit var name: String
    lateinit var format: String
    lateinit var fileName: String
    lateinit var file: File
}