package me.ruyeo.pageranimation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class PagerAdapter: RecyclerView.Adapter<PagerAdapter.VH>() {

    private val dif = AsyncListDiffer(this, ITEM_DIFF)

    inner class VH(view: View): RecyclerView.ViewHolder(view){
        var image = view.findViewById<ImageView>(R.id.img_bg)
        var title = view.findViewById<TextView>(R.id.tv_title)

        fun bind(){
            val pager = dif.currentList[adapterPosition]
            image.setImageResource(pager.image)
            title.text = pager.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context)
            .inflate(R.layout.pager_item,parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind()

    override fun getItemCount(): Int = dif.currentList.size

    fun submitData(list: List<Pager>){
        dif.submitList(list)
    }

    companion object{
        private val ITEM_DIFF = object : DiffUtil.ItemCallback<Pager>(){
            override fun areItemsTheSame(oldItem: Pager, newItem: Pager): Boolean =
                oldItem.title == newItem.title && oldItem.image == newItem.image

            override fun areContentsTheSame(oldItem: Pager, newItem: Pager): Boolean =
                oldItem.title == newItem.title && oldItem.image == newItem.image
        }
    }
}