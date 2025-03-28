package com.example.habitease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.habitease.models.Habit

class HabitAdapter(private val habits: MutableList<Habit>) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    class HabitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvHabitName: TextView = view.findViewById(R.id.tvHabitName)
        val cbHabit: CheckBox = view.findViewById(R.id.cbHabit)
        val btnDelete: Button = view.findViewById(R.id.btnDeleteHabit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_habit_adapter, parent, false)
        return HabitViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = habits[position]
        holder.tvHabitName.text = habit.name
        holder.cbHabit.isChecked = habit.isCompleted

        holder.cbHabit.setOnClickListener {
            habit.isCompleted = !habit.isCompleted
            notifyItemChanged(position)
        }

        holder.btnDelete.setOnClickListener {
            habits.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = habits.size
}