package com.example.assessmentforlesson

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
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
    private lateinit var randomBTN: Button

    @SuppressLint("MissingInflatedId")
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
        randomBTN = findViewById(R.id.randomBTN)
        randomBTN.setOnClickListener(this::OnClick)
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
        if (textET.text.toString().toInt() >= 1 && textET.text.toString().toInt() <= 5) {
            when (item.itemId) {
                ITEM_ON -> {
                    when (textET.text.toString().toInt()) {
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
        } else if (textET.text.toString().toInt() > 5 || textET.text.toString().toInt() <= 50) {
            when (item.itemId) {
                ITEM_ON -> {
                    when  (textET.text.toString().toInt()) {
                        in 6..10 -> textET.setBackgroundColor(getColor(R.color.red))
                        in 11..20 -> textET.setBackgroundColor(getColor(R.color.orange))
                        in 21..30-> textET.setBackgroundColor(getColor(R.color.yellow))
                        in 31..40-> textET.setBackgroundColor(getColor(R.color.green))
                        in 41..50-> textET.setBackgroundColor(getColor(R.color.blue))
                        else -> textET.setBackgroundColor(Color.TRANSPARENT)
                    }
                }

                ITEM_OFF -> {
                    finish()
                }

                else -> return super.onContextItemSelected(item)
            }
        }
        return true
    }

    fun OnClick(view: View?) {
        when(view?.id) {
            R.id.randomBTN -> {
                textET.text.clear()
                textET.text.append((1..50).random().toString())
            }
        }
    }
}