package com.app.mayurn.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mayurn.affirmations.R
import com.app.mayurn.affirmations.model.Affirmations

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmations] data object.
 */
//The ItemAdapter needs information on how to resolve the string resources.
// This, and other information about the app, is stored in a Context object instance that you can pass into an ItemAdapter instance.
class ItemAdapter(private val context: Context, private val dataset: List<Affirmations>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    //Now, we need to create view holder, for more refer to recycler view notes in Mayur's Kotlin Folder
    //a view holder represents a single list item view.
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    //following are implemented methods for class ItemAdapter caz it extends abstract class Adapter
    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout =
            LayoutInflater.from(parent.context) //The layout inflater knows how to inflate an XML layout into a hierarchy of view objects.
                .inflate(
                    R.layout.list_item,
                    parent,
                    false
                ) //we given false to attach to root, caz RecyclerView take care of this when its time.
        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //his method is called by the layout manager in order to replace the contents of a list item view.
        val item = dataset[position] //finding right position of in affirmation list.
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)    //don't worry here for order caz we take care in list_item.xml
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size //basically we returning size to function here
}