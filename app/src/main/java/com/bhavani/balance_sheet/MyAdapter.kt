package com.bhavani.balance_sheet

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataList: List<Data>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val monthTextView: TextView = itemView.findViewById(R.id.month)
        val obEditText: EditText = itemView.findViewById(R.id.opBal)
        val cbEditText: EditText = itemView.findViewById(R.id.cloBal)
        val amountTextView: TextView = itemView.findViewById(R.id.amount)
        val salesTextView: TextView = itemView.findViewById(R.id.sales)
        val totalTextView: TextView = itemView.findViewById(R.id.total)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.monthTextView.text = data.month

        //listener for the obEditText and cbEditText
        val obTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                // ...
            }

            override fun onTextChanged(s: CharSequence?,
                                       start: Int,
                                       before: Int,
                                       count: Int
            ) {
                // Getting the values of obEditText and cbEditText
                val ob = holder.obEditText.text.toString().toIntOrNull() ?: 0
                val cb = holder.cbEditText.text.toString().toIntOrNull() ?: 0

                val amount = ob + cb
                val sales = amount * cb

                // Updating the amountTextView and salesTextView
                holder.amountTextView.text = amount.toString()
                holder.salesTextView.text = sales.toString()

                // Updating the totalTextView
                val total = amount + sales
                holder.totalTextView.text = total.toString()
            }

            override fun afterTextChanged(s: Editable?) {
                // ...
            }
        }

        holder.obEditText.addTextChangedListener(obTextWatcher)
        holder.cbEditText.addTextChangedListener(obTextWatcher)
    }

    override fun getItemCount() = dataList.size
}





