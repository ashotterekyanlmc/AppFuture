package com.teashot.appfuture.ui.base


import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH> {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var items: MutableList<T>? = null
    private var listener: OnItemClickListener? = null
    private var debounceClick: Long = 0

    constructor(items: MutableList<T>?) {
        this.items = items
    }

    constructor(items: MutableList<T>?, listener: OnItemClickListener) {
        this.items = items
        this.listener = listener
    }

    constructor(items: MutableList<T>?, listener: OnItemClickListener, debounceClick: Long?) {
        this.items = items
        this.listener = listener
        this.debounceClick = debounceClick ?: 0
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        listener?.let { listener ->
            holder.itemView.setOnClickListener {
                listener.onItemClick(holder.bindingAdapterPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun getItem(position: Int): T? {
        return if (this.items?.size ?: 0 >= position) {
            this.items?.get(position)
        } else {
            null
        }
    }

    fun getItems(): MutableList<T>? {
        return this.items
    }

    fun addItem(item: T, position: Int) {
        this.items?.add(position, item)
        notifyItemInserted(position)
    }

    fun removeItem(position: Int) {
        if (this.items?.size ?: 0 >= position) {
            this.items?.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun updateItem(item: T, position: Int) {
        this.items?.set(position, item)
        notifyItemChanged(position)
    }

    fun clearItems() {
        this.items?.clear()
        notifyDataSetChanged()
    }

    fun updateItems(input: List<T>?) {
        if (input == null)
            return
        if (this.items != null) {
            this.items?.clear()
        } else {
            this.items = mutableListOf()
        }
        this.items?.addAll(input)
        notifyDataSetChanged()
    }

    open fun insertItem(item: T) {
        if (this.items != null) {
            this.items?.add(item)
        } else {
            this.items = mutableListOf()
            this.items?.add(item)
        }
        items?.let {
            notifyItemInserted(it.size - 1)
        }
    }

    fun insertItems(input: List<T>?) {
        if (input == null)
            return
        if (this.items == null) {
            this.items = mutableListOf()
        }

        this.items?.clear()
        this.items?.addAll(input)
    }

    fun insertItemsWithoutClear(input: List<T>?) {
        if (input == null)
            return
        if (this.items == null) {
            this.items = mutableListOf()
        }

        this.items?.addAll(input)
        items?.let {
            notifyItemRangeInserted(0, input.size - 1)
        }
    }

    fun setDebounce(debounceClick: Long) {
        this.debounceClick = debounceClick
    }

}