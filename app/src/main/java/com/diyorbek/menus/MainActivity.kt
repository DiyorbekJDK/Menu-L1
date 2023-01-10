package com.diyorbek.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.showText)
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.popupMenu)



        button.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view)
            popupMenu.menuInflater.inflate(R.menu.my_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.clear -> {
                        editText.text.clear()
                        textView.text = ""
                    }
                    R.id.exit -> {
                        finish()
                    }
                }
                true
            }
            popupMenu.show()
        }

        editText.addTextChangedListener {
            textView.text = it.toString().trim()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.clear -> {
                editText.text.clear()
                textView.text = ""
            }
            R.id.exit -> {
                finish()
            }
        }
        return true
    }
}