package br.harlan.instagramclone.business.services

interface MessageServiceable {
    fun newToast(mensagem: String)
    fun newProgressDialog(titulo: String, mensagem: String)
    fun updateMessageProgressDialog(mensagem: String)
    fun closeProgressDialog()
    fun newAlert(titulo: String, mensagem: String)
}