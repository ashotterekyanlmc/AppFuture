package com.teashot.appfuture.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teashot.appfuture.R
import com.teashot.appfuture.databinding.FragmentContactListBinding
import com.teashot.appfuture.ui.Constants
import com.teashot.appfuture.ui.base.BaseAdapter
import com.teashot.appfuture.ui.main.MainActivity
import com.teashot.appfuture.ui.models.Contact

class ContactListFragment : Fragment(), BaseAdapter.OnItemClickListener {

    companion object {
        val TAG = ContactListFragment::class.simpleName
    }

    private var _binding: FragmentContactListBinding? = null
    private val binding get() = _binding!!

    private var adapter: ContactListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.updateToolbar(R.string.contact_list_title)
        val contactList = Constants.CONTACT_LIST
        adapter = ContactListAdapter(contactList, this)
        binding.rvContacts.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        adapter?.getItem(position)?.id?.let { contactId ->
            (activity as? MainActivity)?.openContactDetails(contactId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
