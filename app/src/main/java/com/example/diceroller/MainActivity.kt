package com.example.diceroller

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity



class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val label = arrayOf<String>("C","C++","Java",".Net","Kotlin","Ruby","Rails","Python","Java Script","Php","Ajax","Perl","Hadoop")
        val subtitle = arrayOf<String>(
            "C programming is considered as the base for other programming languages",
            "C++ is an object-oriented programming language.",
            "Java is a programming language and a platform.",
            ".NET is a framework which is used to develop software applications.",
            "Kotlin is a open-source programming language, used to develop Android apps and much more.",
            "Ruby is an open-source and fully object-oriented programming language.",
            "Ruby on Rails is a server-side web application development framework written in Ruby language.",
            "Python is interpreted scripting  and object-oriented programming language.",
            "JavaScript is an object-based scripting language.",
            "PHP is an interpreted language, i.e., there is no need for compilation.",
            "AJAX allows you to send and receive data asynchronously without reloading the web page.",
            "Perl is a cross-platform environment used to create network and server-side applications.",
            "Hadoop is an open source framework from Apache written in Java."
        )
        val time = arrayOf<String>("12:34 PM","12:34 PM","12:34 PM","12:34 PM","12:34 PM","12:34 PM","12:34 PM","12:34 PM","12:34 PM","12:34 PM","12:34 PM","12:34 PM","12:34 PM")


        val myListAdapter = MyListAdapter(this,label,time,subtitle)
        val listView:ListView = findViewById(R.id.listview_1)
        listView.adapter=myListAdapter
    }

    class MyListAdapter(private val context: Activity, private val lable: Array<String>, private val time: Array<String>, private val subtitle: Array<String>)
        : ArrayAdapter<String>(context, R.layout.listview_item, lable) {

        override fun getView(position: Int, view: View?, parent: ViewGroup): View {
            val inflater = context.layoutInflater
            val rowView = inflater.inflate(R.layout.listview_item, null, true)

            val titleText = rowView.findViewById(R.id.label) as TextView
            val avatar = rowView.findViewById(R.id.avatar) as TextView
            val timeText = rowView.findViewById(R.id.time) as TextView
            val subtitleText = rowView.findViewById(R.id.subtitle) as TextView

            avatar.text = lable[position].first().uppercase()
            titleText.text = lable[position]
            timeText.text = time[position]
            subtitleText.text = subtitle[position]

            return rowView
        }
    }
}
