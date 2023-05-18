package com.example.myapplication

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import com.example.myapplication.Alphabet
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.myapplication.R
import android.widget.TextView
import androidx.core.view.ViewCompat.setBackgroundTintList
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList

// Extends the Adapter class to RecyclerView.Adapter
// and implement the unimplemented methods
class Adapter(var context: Context, var arrayList: ArrayList<Alphabet>,var click: OnClick) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflating the Layout(Instantiates list_item.xml layout file into View object)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        // Passing view to ViewHolder
        return ViewHolder(view)
    }

    // Binding data to the into specified position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TypeCast Object to int type
//		int res = (int) images.get(position);
        holder.tvText.text = arrayList[position].name
        if (selectedPosition == position) {


            holder.itemView.tvText.setBackgroundResource(R.drawable.round_more_dark)
            holder.itemView.tvText.setTextColor(Color.parseColor("#ffffff"));

        } else {

            holder.itemView.tvText.setBackgroundResource(R.drawable.round_more_light)
                   holder.itemView.tvText.setTextColor(Color.parseColor("#000000"));

        }
        holder.itemView.setOnClickListener {
            click.onClik(position)
            if (selectedPosition >= 0)
                notifyItemChanged(selectedPosition);
            selectedPosition = holder.getAdapterPosition();
            notifyItemChanged(selectedPosition);

        }


    }

    override fun getItemCount(): Int {
        // Returns number of items currently available in Adapter
        return arrayList.size
    }

    // Initializing the Views
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvText: TextView

        init {
            tvText = view.findViewById<View>(R.id.tvText) as TextView
        }
    }
    fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}