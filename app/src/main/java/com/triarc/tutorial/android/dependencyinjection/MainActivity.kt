package com.triarc.tutorial.android.dependencyinjection

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 11/1/19
 */
class MainActivity: AppCompatActivity() {

    companion object {
        const val NAME = "name"
    }

    @Inject
    lateinit var preference: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as? DependencyInjectionApplication)?.getApplicationComponent()?.inject(this)

        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        onInitialiseView()
        onInitialiseListener()
    }

    private fun onInitialiseView() {
        val name = preference.getString(NAME)
        if(name != null)
            user_name.text = name
    }

    private fun onInitialiseListener() {
        save.setOnClickListener {
            val name = input.text?.toString()
            name?.let { name ->
                preference.setString(NAME, name)
                user_name.text = name
            }
        }
    }
}
