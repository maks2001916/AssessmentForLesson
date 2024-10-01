package com.example.assessmentforlesson

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object{
        const val ITEM_ON = 111
        const val ITEM_OFF = 112
    }

    private lateinit var textET: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textET = findViewById(R.id.textET)
        registerForContextMenu(textET)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add( Menu.NONE, ITEM_ON, Menu.NONE, getString(R.string.color_quality))
        menu?.add(Menu.NONE, ITEM_OFF, Menu.NONE, getString(R.string.exit))
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            ITEM_ON -> {
                when(textET.text.toString().toInt()){
                    1 -> textET.setBackgroundColor(getColor(R.color.orange))
                    2 -> textET.setBackgroundColor(getColor(R.color.yellow))
                    3 -> textET.setBackgroundColor(getColor(R.color.green))
                    4 -> textET.setBackgroundColor(getColor(R.color.blue))
                    5 -> textET.setBackgroundColor(getColor(R.color.red))
                    else -> textET.setBackgroundColor(Color.TRANSPARENT)
                }
            }
            ITEM_OFF -> {
                finish()
            }
            else -> return super.onContextItemSelected(item)
        }
        return true
    }
}