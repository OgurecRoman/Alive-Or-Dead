package com.example.alive_or_dead

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cells: ArrayList<Cell> = arrayListOf()
        val list_cells: RecyclerView = findViewById(R.id.cells)
        val but_add: Button = findViewById(R.id.but_add)

        var num: Int
        var adapter: CellAdapter
        var count_alive: Int = 0
        var count_dead: Int = 0
        var index: Int

        but_add.setOnClickListener(
            View.OnClickListener {
                num = (0..1).random()
                if (num == 0) {
                    count_dead++
                    count_alive = 0
                    cells.add(Cell("Мёртвая", "или прикидывается", "dead"))
                } else {
                    count_alive++
                    count_dead = 0
                    cells.add(Cell("Живая", "и шевелится!", "alive"))
                }

                if (count_alive == 3){
                    cells.add(Cell("Жизнь", "Ку-ку!", "life"))
                    count_alive = 0
                }

                if (count_dead == 3){
                    count_dead = 0
                    index = cells.count() - 4
                    if (index >= 0){
                        if (cells[index].name == "Жизнь")
                            cells[index] = Cell("Умер", "жалко :(", "skull")
                    }
                }

                adapter = CellAdapter(cells)
                list_cells.adapter = adapter
            }
        )
    }
}