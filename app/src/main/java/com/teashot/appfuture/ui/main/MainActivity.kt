package com.teashot.appfuture.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.teashot.appfuture.R
import com.teashot.appfuture.ui.contact_details.ContactDetailsFragment
import com.teashot.appfuture.ui.contacts.ContactListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            supportFragmentManager.commit {
                add(R.id.fragmentContainer, ContactListFragment())
            }
        supportActionBar?.hide()
    }

    fun openContactDetails(contactId: String) {
        supportFragmentManager.commit {
            replace(
                R.id.fragmentContainer,
                ContactDetailsFragment.newInstance(contactId)
            ).addToBackStack(ContactDetailsFragment.TAG)
        }
    }

    fun updateToolbar(titleId: Int) {
        findViewById<TextView>(R.id.toolbar_title)?.setText(titleId)
    }
}
