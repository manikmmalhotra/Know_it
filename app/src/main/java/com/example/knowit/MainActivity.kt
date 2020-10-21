package com.example.knowit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.knowit.fragments.fragfour
import com.example.knowit.fragments.fragone
import com.example.knowit.fragments.fragthree
import com.example.knowit.fragments.fragtwo
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            //fragone for home
            //fragtwo for search
            //fragthree for saved collections
            //fragfour for categories
            R.id.home -> {
                println("home pressed")
                replaceFragment(fragone())
                return@OnNavigationItemSelectedListener true
            }
            R.id.category -> {
                println("category pressed")
                replaceFragment(fragtwo())
                return@OnNavigationItemSelectedListener true
            }
            R.id.search -> {
                println("search")
                replaceFragment(fragthree())
                return@OnNavigationItemSelectedListener true
            }
            R.id.saved -> {
                println("saved Collection")
                replaceFragment(fragfour())
                return@OnNavigationItemSelectedListener true
            }
        }

        false

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigation) as BottomNavigationView

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(fragone()) //ie home
    }


    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment) //activity_main
        fragmentTransaction.commit()
    }
}

