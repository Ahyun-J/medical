package com.example.carebout

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class MainActivity : AppCompatActivity() {

    var medicalNoteTab = MedicalNoteTab()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dailycare = Dailycare()
        var tab: TabLayout = findViewById<TabLayout>(R.id.mainTab)

        var selected: Fragment? = medicalNoteTab

        supportFragmentManager.beginTransaction().replace(R.id.mainFrame, selected!!).commit()

        tab.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position

                if (position == 0) {
                    selected = medicalNoteTab
                } else if (position == 1) {
                    selected = medicalNoteTab
                } else if (position == 2) {
//                    dailycare.unSelectBorn(dailycare.views)
                    selected = medicalNoteTab
                } else if (position == 3) {
                    selected = medicalNoteTab
                }
                supportFragmentManager.beginTransaction().replace(R.id.mainFrame, selected!!).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }
}