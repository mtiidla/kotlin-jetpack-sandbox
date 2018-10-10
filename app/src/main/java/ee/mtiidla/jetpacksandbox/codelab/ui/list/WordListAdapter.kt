package ee.mtiidla.jetpacksandbox.codelab.ui.list

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import ee.mtiidla.jetpacksandbox.R
import ee.mtiidla.jetpacksandbox.codelab.data.Word

class WordListAdapter(private val listener: (Word) -> Unit) : Adapter<ViewHolder>() {

    private var words: List<Word> = listOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        return WordViewHolder(LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item_word, viewGroup, false), listener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        (viewHolder.itemView as TextView).text = words[position].word
    }

    override fun getItemCount(): Int = words.size

    fun setItems(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    private inner class WordViewHolder(itemView: View, listener: (Word) -> Unit) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { listener.invoke(words[adapterPosition]) }
        }
    }

}
