package com.vansh.genericrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personList = mutableListOf<PersonBean>()
        personList.add(PersonBean("Ganesh Junghare", "8888601060"))
        personList.add(PersonBean("Yogesh J", "8883301060"))
        personList.add(PersonBean("Yogesh P", "8888603330"))
        personList.add(PersonBean("Sarita sahu", "8884403330"))

        val personRvAdapter = PersonRvAdapter(personList)
        idRvPersonal.adapter = personRvAdapter

        idFabCreateRecord.setOnClickListener {
            val alertDialog =  AlertDialog.Builder(this)
            alertDialog.setTitle("Create Record")
            alertDialog.setPositiveButton("Yes"
            ) { dialogInterface, p1 ->

                val personList = mutableListOf<PersonBean>()
                personList.add(PersonBean("s Junghare", "8888601060"))
                personRvAdapter.addAll(personList)
                dialogInterface.dismiss()
            }
            alertDialog.setNegativeButton("No"
            ) { dialogInterface, p1 ->
                dialogInterface.dismiss()
            }
            alertDialog.show()
        }
    }
}
