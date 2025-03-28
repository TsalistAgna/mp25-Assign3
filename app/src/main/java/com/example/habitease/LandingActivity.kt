package com.example.habitease

import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.habitease.models.Habit
import com.example.habitease.models.User

class LandingActivity : AppCompatActivity() {
    private val habits = mutableListOf<Habit>()
    private lateinit var habitAdapter: HabitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val userName = intent.getStringExtra("user_data")
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "Welcome, $userName!"

        val etHabit = findViewById<EditText>(R.id.etHabit)
        val btnAddHabit = findViewById<Button>(R.id.btnAddHabit)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        habitAdapter = HabitAdapter(habits)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = habitAdapter

        btnAddHabit.setOnClickListener {
            val habitName = etHabit.text.toString()
            if (habitName.isNotEmpty()) {
                habits.add(Habit(habitName, false))
                habitAdapter.notifyDataSetChanged()
                etHabit.text.clear()
            } else {
                Toast.makeText(this, "Please enter a habit", Toast.LENGTH_SHORT).show()
            }
        }
    }
}