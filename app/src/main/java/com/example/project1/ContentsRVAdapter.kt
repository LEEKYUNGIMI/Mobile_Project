package com.example.project1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.QueryDocumentSnapshot


class ContentsRVAdapter(val items: MutableList<ContentModel>) : RecyclerView.Adapter<ContentsRVAdapter.ViewHolder>() {



    interface ItemClick{
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentsRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.contents_item_rv,parent,false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ContentsRVAdapter.ViewHolder, position: Int) {
        if(itemClick!=null){
            holder.itemView.setOnClickListener{v->
                itemClick?.onClick(v,position)
            }
        }
        holder.bindItem(items[position])



    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(item: ContentModel){
//            val contentTitle = itemView.findViewById<TextView>(R.id.item_explain_tv)
//            contentTitle.text = item.title

            val contentTitle =itemView.findViewById<TextView>(R.id.listTitle)
            val listPrice = itemView.findViewById<TextView>(R.id.listPrice)
            val listContent = itemView.findViewById<TextView>(R.id.listContent)
            val listStatus = itemView.findViewById<TextView>(R.id.listStatus)

//            val listImage = itemView.findViewById<ImageView>(R.id.listImage)

            contentTitle.text= item.listTitle
            listPrice.text = item.listPrice
            listContent.text  = item.listContents
            listStatus.text=item.forSale


        }
    }
}



