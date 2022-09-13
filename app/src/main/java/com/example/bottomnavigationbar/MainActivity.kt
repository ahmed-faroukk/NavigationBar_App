package com.example.bottomnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.UI.Home
import com.example.UI.Profile
import com.example.UI.Setting
import com.example.bottomnavigationbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private  var fragmentHome =Home()
    private  var fragmentProfile= Profile()
    private  var fragmentsetting= Setting()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(fragmentHome)
       binding.bottomNavigationView.setOnItemSelectedListener {
           when(it.itemId) {
                R.id.Home-> replaceFragment(fragmentHome)
                R.id.Profile-> replaceFragment(fragmentProfile)
                R.id.Setting->replaceFragment(fragmentsetting)

           }

           true
       }
    }

   private fun replaceFragment(fragment : Fragment){
       supportFragmentManager.beginTransaction().setCustomAnimations(
           R.anim.fromleft,  R.anim.toright,
           R.anim.toright, R.anim.fromleft).apply {
           replace(R.id.fragment , fragment)
           commit()
       }

      
   }
}