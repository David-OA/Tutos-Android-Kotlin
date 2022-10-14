package com.david.oconte.edittextrecyclerview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class TodoAdapter(

    private val todoList: MutableList<Todo>
) : RecyclerView.Adapter<TodoViewHolder>(), TodoUI.TodoSaved {

    private lateinit var todoListener: TodoUI.TodoListener

    fun setOnTodoDeleteClick(listener: TodoUI.TodoListener) {
        todoListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_layout, parent, false)
        return TodoViewHolder(view, todoListener, this)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(todoViewHolder: TodoViewHolder, position: Int) {
        todoViewHolder.bindTodo(todoList[position])
    }

    override fun onTodoTitleUpdated(position: Int, title: String) {
        todoList[position].title = title
    }

}