package com.example.navigationdrawer.UI.HomeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ActivityMainBinding
import com.example.navigationdrawer.databinding.NavHeaderBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var toolBar:Toolbar
    private lateinit var bindingNavHeaderBinding: NavHeaderBinding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // init toolbar
        toolBar = binding.toolbar
        toolBar.title =getString(R.string.profile)
        setSupportActionBar(toolBar)

        // toggle
        val toggle = ActionBarDrawerToggle(
            this
            ,binding.drawerLayout,
            toolBar,
            R.string.nav_drawer_open,
            R.string.nav_drawer_open
        )

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // init navbar
        initNav()

    }

    // back button
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else
        {
            super.onBackPressed()
        }

    }


    private fun initNav(){

        bindingNavHeaderBinding = NavHeaderBinding.bind(binding.navBar.getHeaderView(0))



        // select item nav
        binding.navBar.setCheckedItem(R.id.item_profile)
        binding.navBar.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_profile ->
                {
                   toolBar.title =  getString(R.string.profile)

                }
                R.id.item_setting ->
                {

                    toolBar.title =  getString(R.string.setting)
                }
                R.id.item_photo ->
                {

                    toolBar.title =  getString(R.string.photo)
                }
                R.id.item_logout ->
                {

                    toolBar.title =  getString(R.string.logout)

                }
            }

            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        
        
    }
}