package br.harlan.instagramclone.view


import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import br.harlan.instagramclone.R
import br.harlan.instagramclone.adapter.ListViewPostAdapter
import br.harlan.instagramclone.business.PostsBusiness
import com.parse.ParseObject

class HomeFragment : BaseFragment {

    lateinit var listView: ListView
    lateinit var parseObjects: ArrayList<ParseObject>
    lateinit var adapterParseObjects: ArrayAdapter<ParseObject>

    constructor() : super(R.layout.fragment_home)

    override fun addEvents() {

    }

    override fun initializeComponents(viewRoot: View) {
        listView = viewRoot.findViewById(R.id.list_view_fragment_home)
        parseObjects = ArrayList()
        adapterParseObjects = ListViewPostAdapter(activity, parseObjects)
        listView.adapter = adapterParseObjects
        PostsBusiness(messageService, navigationService).getPosts(parseObjects, adapterParseObjects)
    }
}