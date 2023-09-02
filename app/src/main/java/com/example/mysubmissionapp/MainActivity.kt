package com.example.mysubmissionapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMembers: RecyclerView
    private val list = ArrayList<Member>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMembers = findViewById(R.id.rv_members)
        rvMembers.setHasFixedSize(true)

        list.addAll(getListMembers())
        showRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(aboutIntent)
        return super.onOptionsItemSelected(item)
    }

    private fun getListMembers(): ArrayList<Member> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataNameJp = resources.getStringArray(R.array.data_name_jp)
        val dataDebut = resources.getStringArray(R.array.data_debut)
        val dataBirthday = resources.getStringArray(R.array.data_birthday)
        val dataHeight = resources.getStringArray(R.array.data_height)
        val dataUnit = resources.getStringArray(R.array.data_unit)

        val listMember = ArrayList<Member>()
        for (i in dataName.indices) {
            val member = Member(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataNameJp[i], dataDebut[i], dataHeight[i], dataBirthday[i], dataUnit[i])
            listMember.add(member)
        }
        return listMember
    }

    private fun showRecycleList() {
        rvMembers.layoutManager = LinearLayoutManager(this)
        val listMemberAdapter = ListMemberAdaptor(list)
        rvMembers.adapter = listMemberAdapter
    }
}