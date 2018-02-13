package br.harlan.instagramclone.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.harlan.instagramclone.R
import com.parse.ParseUser

class ListViewUsersAdapter : ArrayAdapter<ParseUser> {

    private lateinit var mContext: Context
    private lateinit var parseUsers: ArrayList<ParseUser>

    constructor(context: Context, parseUsers: ArrayList<ParseUser>)
            : super(context, 0, parseUsers) {
        this.mContext = context
        this.parseUsers = parseUsers
    }

    @SuppressLint("WrongConstant")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if(convertView != null)
            view = convertView
        else {
            //var inflater: LayoutInflater = mContext.getSystemService(context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val inflater = context.getSystemService("layout_inflater") as LayoutInflater
            view = inflater.inflate(R.layout.row_list_view_home, parent, false)
        }

        return view
    }

}