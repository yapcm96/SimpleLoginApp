package com.example.simpleloginapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview_home)


        var listView = findViewById<ListView>(R.id.homeListView)

        listView.adapter =
            MyCustomAdapter(this) // This needs to be my custom adapter telling my list what to render
    }

    private class MyCustomAdapter(context: Context) : BaseAdapter() {

        private val hContext: Context = context
        private val names = arrayListOf<String>(
            "Superman", "Batman", "Spiderman", "Sandman", "Wonderwoman"
        )

        // Responsible for how many rows in my list
        override fun getCount(): Int {
            return names.size
        }

        // You can ignore this
        override fun getItemId(position: Int): Long {
            TODO("Not yet implemented")
        }

        // You can ignore this
        override fun getItem(position: Int): Any {
            TODO("Not yet implemented")
        }

        // Responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(hContext)
            val rowHome = layoutInflater.inflate(R.layout.row_home, parent, false)
            val element = names[position]

            val nameTextView = rowHome.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = element

            // This is necessary to avoid app crashing when clicking on listview row
            rowHome.setOnClickListener {
                Toast.makeText(hContext, "$element!", Toast.LENGTH_SHORT).show()
            }

            return rowHome
        }
    }
}