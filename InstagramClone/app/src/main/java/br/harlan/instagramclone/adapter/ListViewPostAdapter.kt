package br.harlan.instagramclone.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import br.harlan.instagramclone.R
import com.parse.ParseObject
import com.squareup.picasso.Picasso

class ListViewPostAdapter : ArrayAdapter<ParseObject> {

    private val mContext: Context
    private var parseObjects: ArrayList<ParseObject>

    constructor(context: Context, parseObjects: ArrayList<ParseObject>)
            : super(context, 0, parseObjects) {
        this.mContext = context
        this.parseObjects = parseObjects
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
        if(parseObjects.size > 0) {
            val imageView = view.findViewById<View>(R.id.image_row_list_home) as ImageView
            val parseObject: ParseObject = parseObjects.get(position)
            parseObject.getParseFile("image")
            Picasso.with(context).load(parseObject.getParseFile("image").file).into(imageView)
            //Picasso.with(context).load(parseObject.getParseFile("image").url).fit().into(imageView)
        }
        return view;
    }
}