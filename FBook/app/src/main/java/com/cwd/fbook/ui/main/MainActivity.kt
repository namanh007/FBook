package com.cwd.fbook.ui.main

import android.support.v4.app.ActivityCompat
import android.support.v4.view.MenuItemCompat.getActionView
import android.content.Context.SEARCH_SERVICE
import android.app.SearchManager
import android.R.menu
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.cwd.fbook.R


/**
 *  @Project: FBook
 *  @CreatedBy: CWD Huy 2018-06-15
 *  @Description: ...
 *  All Right Reserved.
 */

class MainActivity : AppCompatActivity() {

    var toolbar : Toolbar ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        var drawable : Drawable = ContextCompat.getDrawable(this, R.drawable.ic_home)!!
        toolbar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolbar)
        toolbar?.setNavigationIcon(drawable)
    }
    override fun onCreateOptionsMenu(menu: Menu) : Boolean{
        val menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.menu_main,menu)

        val searchItem =menu.findItem(R.id.action_search)
        val searchManager = this@MainActivity.getSystemService(Context.SEARCH_SERVICE) as SearchManager

        var searchView: SearchView? = null
        if (searchItem != null) {
            searchView = searchItem!!.getActionView() as SearchView
        }
        if (searchView != null) {
            searchView!!.setSearchableInfo(searchManager.getSearchableInfo(this@MainActivity.getComponentName()))
        }
        return super.onCreateOptionsMenu(menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item )
        var id = item?.itemId
        if(id == R.id.action_search){
            fun Context.toast(message: CharSequence) =
                    Toast.makeText(this, "search", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
