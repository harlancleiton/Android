package br.harlan.instagramclone.business.services

import android.widget.ArrayAdapter
import br.harlan.instagramclone.business.PostsBusiness
import br.harlan.instagramclone.database.PostsDatabase
import br.harlan.instagramclone.database.UserDatabase
import br.harlan.instagramclone.database.services.TaskServiceable
import br.harlan.instagramclone.view.HomeActivity
import br.harlan.instagramclone.view.LoginActivity
import com.parse.ParseException
import com.parse.ParseObject

class TaskService : TaskServiceable {

    //region Variables and Constructor
    private var messageService: MessageServiceable? = null
    private var navigationService: NavigationServiceable? = null
    private lateinit var parseObjects: ArrayList<ParseObject>
    private lateinit var adapterParseObjects: ArrayAdapter<ParseObject>

    constructor(messageService: MessageServiceable, navigationService: NavigationServiceable) {
        this.messageService = messageService
        this.navigationService = navigationService
    }
    //endregion Variables and Constructor

    fun newError(mensagem: String) {
        messageService!!.newToast(mensagem)
    }

    //region AuthenticationFunctions
    override fun registeredUser(e: ParseException?) {
        if (e == null) {
            messageService!!.newToast("Usuário cadastrado com sucesso")
            UserDatabase(this).userLogOut()
            navigationService!!.navigateTo(LoginActivity::class.java, true)
        } else
            messageService!!.newToast("Erro ao cadastrar usuário: " + e.code + e.message)
    }

    override fun sessionClosed(e: ParseException?) {
        if (e == null) {
            messageService!!.newToast("Usuário deslogado com sucesso")
            navigationService!!.navigateTo(LoginActivity::class.java)
        } else
            messageService!!.newToast("Erro ao deslogar usuário: " + e.code + e.message)
    }

    override fun sessionStarted(e: ParseException?) {
        if (e == null) {
            messageService!!.newToast("Usuário logado com sucesso")
            navigationService!!.navigateTo(HomeActivity::class.java)
        } else
            messageService!!.newToast("Erro ao realizar login do usuário: " + e.code + e.message)
    }
    //endregion AuthenticationFunctions

    override fun fileSent(e: ParseException?) {
        if (e == null) {
            messageService!!.newToast("Enviado com sucesso.")
            PostsDatabase(this).getPosts()
        } else
            messageService!!.newToast("Ocorreu um erro ao enviar o arquivo.\nErro " + e.code + " - " + e.message)

    }

    override fun recoveredPosts(objects: List<ParseObject>?, e: ParseException?) {
        if (objects!!.size > 0) {
            parseObjects.clear()
            for (parseObject: ParseObject in objects)
                parseObjects.add(parseObject)
            adapterParseObjects.notifyDataSetChanged()
        }
    }

    fun waitForResult(parseObjects: ArrayList<ParseObject>, adapterParseObjects: ArrayAdapter<ParseObject>) {
        this.parseObjects = parseObjects
        this.adapterParseObjects = adapterParseObjects
    }
}