package com.tratagroup.demotest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.person_list_item.view.*
import java.util.zip.Inflater

/**
 * Created by Ganesh Junghare on 9/13/2019.
 */
class PersonRvAdapter(var personList : MutableList<PersonBean>):MyGenericAdapter<PersonBean>(personList) {

    override fun newView(context: Context, parent: ViewGroup) = LayoutInflater.from(context).inflate(R.layout.person_list_item, parent, false)

    override fun bind(t: PersonBean, view: View, position: Int) {
        view.idTvPersonName.text = t.name
        view.idTvPersonContact.text = t.contact

        view.idIvDelete.setOnClickListener {
            personList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun addAll(updatedPersonList : MutableList<PersonBean>){
        val position = personList.size
        personList.addAll(position, updatedPersonList)
        notifyItemInserted(position)
    }
}