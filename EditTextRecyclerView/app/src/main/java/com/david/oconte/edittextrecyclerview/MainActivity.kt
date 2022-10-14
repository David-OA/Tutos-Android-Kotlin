package com.david.oconte.edittextrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.david.oconte.edittextrecyclerview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private var todoList: MutableList<Todo> = mutableListOf()
    private lateinit var todoAdapter: TodoAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpLayout()
    }

    private fun setUpLayout() {
        todoList.add(Todo(""))
        binding.todoRecyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(todoList)
        binding.todoRecyclerView.adapter = todoAdapter

        todoAdapter.setOnTodoDeleteClick(object : TodoUI.TodoListener {
            override fun onTodoDeleted(position: Int) {
                todoList.removeAt(position)
                todoAdapter.notifyDataSetChanged()
            }
        })

        btn_add_todo.setOnClickListener {
            val position = if (todoList.isEmpty()) 0 else todoList.size - 1
            todoList.add(Todo(""))
            todoAdapter.notifyItemInserted(position)
            todoAdapter.notifyDataSetChanged()
        }

        btn_clear_todo.setOnClickListener {
            todoList.clear()
            todoList.add(Todo(""))
            todoAdapter.notifyDataSetChanged()
        }
    }
}