package com.dicoding.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvWaifus: RecyclerView
    private var list = ArrayList<Waifu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWaifus = findViewById(R.id.rv_waifus)
        rvWaifus.setHasFixedSize(true)

        list.addAll(getListWaifu())
        showRecyclerList()
    }

    private fun getListWaifu(): ArrayList<Waifu> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataBirthday = resources.getStringArray(R.array.data_birthday)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listWaifu = ArrayList<Waifu>()
        for (i in dataName.indices) {
            val waifu = Waifu (dataName[i], dataDescription[i], dataPhoto[i], dataBirthday[i])
            listWaifu.add(waifu)
        }
        return listWaifu
    }

    private fun showRecyclerList() {
        rvWaifus.layoutManager = LinearLayoutManager(this)
        val listWaifuAdapter = ListWaifuAdapter(list)
        rvWaifus.adapter = listWaifuAdapter

//        listWaifuAdapter.setOnItemClickCallback(object : ListWaifuAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Waifu) {
//                showSelectedWaifu(data)
//            }
//        })
    }

    private fun showSelectedWaifu(waifu: Waifu) {
//        Toast.makeText(this, "Kamu memilih " + waifu.name, Toast.LENGTH_SHORT).show()
//        val moveWithObjectIntent = Intent(this@MainActivity, DetailActivity::class.java)
//        moveWithObjectIntent.putExtra(DetailActivity.EXTRA_WAIFU, waifu)
//        startActivity(moveWithObjectIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvWaifus.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvWaifus.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about ->{
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

}