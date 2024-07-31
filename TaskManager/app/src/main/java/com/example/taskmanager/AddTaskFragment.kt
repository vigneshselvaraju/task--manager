package com.example.taskmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class AddTaskFragment : Fragment() {

    private lateinit var taskNameEditText: EditText
    private lateinit var categorySpinner: Spinner
    private lateinit var addButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)
        taskNameEditText = view.findViewById(R.id.taskNameEditText)
        categorySpinner = view.findViewById(R.id.categorySpinner)
        addButton = view.findViewById(R.id.addButton)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.category_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            categorySpinner.adapter = adapter
        }

        addButton.setOnClickListener {
            // Handle adding task
            Toast.makeText(requireContext(), "Task Added", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
