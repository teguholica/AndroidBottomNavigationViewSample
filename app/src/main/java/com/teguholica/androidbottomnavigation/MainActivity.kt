package com.teguholica.androidbottomnavigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var toolbar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar

        val layoutParams = bottomNavigation.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationBehavior()

        loadFragment(StoreFragment())

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_shop -> {
                    toolbar?.title = "Shop"
                    loadFragment(StoreFragment())
                }
                R.id.navigation_gifts -> {
                    toolbar?.title = "My Gifts"
                    loadFragment(GiftsFragment())
                }
                R.id.navigation_cart -> {
                    toolbar?.title = "Cart"
                    loadFragment(CartFragment())
                }
                R.id.navigation_profile -> {
                    toolbar?.title = "Profile"
                    loadFragment(ProfileFragment())
                }
                else -> {
                    toolbar?.title = "Unknown"
                }
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.vContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
