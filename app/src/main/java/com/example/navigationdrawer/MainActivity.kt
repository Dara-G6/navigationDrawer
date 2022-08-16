package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import com.example.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var toolBar:Toolbar
    private lateinit var headerNavBar:View
    private lateinit var tvEmail:TextView
    private lateinit var tvName:TextView
    private lateinit var imgUser:ImageView

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
            R.string.nav_drawer_open)

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

        headerNavBar = binding.navBar.getHeaderView(0)
        tvEmail = headerNavBar.findViewById(R.id.tv_email)
        tvName  = headerNavBar.findViewById(R.id.tv_userName)
        imgUser = headerNavBar.findViewById(R.id.img_user)


        // select item nav
        binding.navBar.setCheckedItem(R.id.item_profile)
        binding.navBar.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_profile ->
                {

                   binding.tvShow.text = getString(R.string.profile)
                   toolBar.title =  getString(R.string.profile)

                }
                R.id.item_contact ->
                {

                    binding.tvShow.text = getString(R.string.contact)
                    toolBar.title =  getString(R.string.contact)
                }
                R.id.item_photo   ->
                {
                    binding.tvShow.text = getString(R.string.photo)
                    toolBar.title =  getString(R.string.photo)
                }
                R.id.item_logout  ->
                {
                    binding.tvShow.text = getString(R.string.logout)
                    toolBar.title =  getString(R.string.logout)

                }
                R.id.item_send    ->
                {
                    binding.tvShow.text = getString(R.string.send)
                    toolBar.title =  getString(R.string.send)
                }
                R.id.item_share   ->
                {
                    binding.tvShow.text = getString(R.string.share)
                    toolBar.title =  getString(R.string.share)
                }
            }

            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        
    }
}