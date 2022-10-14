package com.david.oconte.edittextrecyclerview

interface TodoUI {
    interface TodoSaved {
        fun onTodoTitleUpdated(position: Int, title: String)
    }

    interface TodoListener {

        fun onTodoDeleted(position: Int)
    }
}