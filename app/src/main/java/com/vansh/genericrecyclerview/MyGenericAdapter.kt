package com.vansh.genericrecyclerview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Ganesh Junghare on 9/13/2019.
 */
abstract class MyGenericAdapter<T>(var list: List<T>?) :
    RecyclerView.Adapter<MyGenericAdapter.ViewHolder>() {

    abstract fun newView(context: Context, parent: ViewGroup): View

    abstract fun bind(t: T, view: View, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(newView(parent.context, parent))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bind(list!![position], holder.itemView, position)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemCount() = list!!.size
}