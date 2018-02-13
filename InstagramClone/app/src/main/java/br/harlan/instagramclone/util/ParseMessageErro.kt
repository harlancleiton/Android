package br.harlan.instagramclone.util

object ParseMessageErro {

    var hashMapErro: HashMap<Int, String> = HashMap()

    fun loadCodes() {
        hashMapErro.put(1, "Ocorreu um erro interno do servidor.")
        hashMapErro.put(209, "Sessão já iniciada.")
        hashMapErro.put(101, "Usuário ou senha inválida.")
        hashMapErro.put(202, "Usuário já cadastrado.")
        hashMapErro.put(203, "Email já cadastrado.")
    }
}