package sri.copypaste.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sri.copypaste.R
import sri.copypaste.model.Clipping

class ClipRecyclerViewAdapter(private val context: Context, private val clippings : List<Clipping>) : RecyclerView.Adapter<ClipRecyclerViewAdapter.ClipViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClipViewHolder {
        return ClipViewHolder(LayoutInflater.from(context).inflate(R.layout.clip_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return clippings.size
    }

    override fun onBindViewHolder(holder: ClipViewHolder, position: Int) {
        var clipping = clippings[position]
        holder.clipText.text = clipping.text
        holder.timeStamp.text = clipping.timestamp.toString()
    }

    class ClipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var clipText: TextView = view.findViewById(R.id.clip_text)
        var timeStamp: TextView = view.findViewById(R.id.timestamp)
    }
}