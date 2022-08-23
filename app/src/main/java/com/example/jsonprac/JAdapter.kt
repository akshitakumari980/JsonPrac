package com.example.jsonprac

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jsonprac.model.ModelUser

class JAdapter : RecyclerView.Adapter<JViewHolder>() {
    var users = mutableListOf<ModelUser>()

    fun setUserList(users: List<ModelUser>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
//        val binding: ViewDataBinding? = DataBindingUtil.inflate(
//            LayoutInflater.from(parent.context),
//            viewTypeToLayout[viewType],
//            parent,
//            false
//        )
        return JViewHolder(view)
    }

    override fun onBindViewHolder(holder: JViewHolder, position: Int) {
        val user = users[position]
        holder.bindView(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}

class JViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewUserName: TextView = itemView.findViewById(R.id.textViewUserName)
    private val textViewUserEmail: TextView = itemView.findViewById(R.id.textViewUserEmail)
    private val imageViewAvatar: ImageView = itemView.findViewById(R.id.T5R)
    fun bindView(modelUser: ModelUser) {
        textViewUserName.text = modelUser.name
        textViewUserEmail.text = modelUser.email

        Glide.with(itemView.context)
            .load(
                "https://www.industrialempathy.com/img/remote/ZiClJf-1920w.jpg")
            .into(imageViewAvatar)


    }
}