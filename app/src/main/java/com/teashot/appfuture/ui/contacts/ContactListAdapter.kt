package com.teashot.appfuture.ui.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teashot.appfuture.databinding.ItemContactBinding
import com.teashot.appfuture.ui.base.BaseAdapter
import com.teashot.appfuture.ui.common.setGlideImage
import com.teashot.appfuture.ui.models.Contact

class ContactListAdapter(items: MutableList<Contact>, onItemClickListener: OnItemClickListener) :
    BaseAdapter<Contact, ContactListAdapter.ContactViewHolder>(items, onItemClickListener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactListAdapter.ContactViewHolder {
        return ContactViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(getItem(position))
    }

    inner class ContactViewHolder constructor(binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val ivAvatar = binding.ivAvatar
        private val tvName = binding.tvName
        private val tvPhone = binding.tvPhone

        fun bind(contact: Contact?) {
            contact?.let {
                ivAvatar.setGlideImage(it.photo)
                tvName.text = it.name
                tvPhone.text = it.phone
            }
        }
    }
}
