package com.teashot.appfuture.ui.contact_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.teashot.appfuture.R
import com.teashot.appfuture.databinding.FragmentContactDetailsBinding
import com.teashot.appfuture.ui.Constants
import com.teashot.appfuture.ui.common.setGlideImage
import com.teashot.appfuture.ui.common.setTextString
import com.teashot.appfuture.ui.common.visible
import com.teashot.appfuture.ui.main.MainActivity
import com.teashot.appfuture.ui.models.Contact

class ContactDetailsFragment : Fragment() {

    companion object {

        val TAG = ContactDetailsFragment::class.simpleName
        const val TAG_CONTACT_ID = "contact_id"

        fun newInstance(contactId: String) = ContactDetailsFragment().apply {
            arguments = bundleOf(TAG_CONTACT_ID to contactId)
        }
    }

    private var _binding: FragmentContactDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contact = Contact.createDefaultContact()
        (activity as? MainActivity)?.updateToolbar(R.string.contact_details_title)
        arguments?.getString(TAG_CONTACT_ID)?.let { id ->
            initView(Constants.CONTACT_LIST.find { id == it.id })
        }
        initView(contact)
    }

    private fun initView(contact: Contact?) {
        with(binding) {
            contact?.let {
                ivAvatar.setGlideImage(null)
                tvName.text = contact.name

                tvPhone.setTextString(contact.phone)
                tvPhone2.setTextString(contact.secondPhone)
                tvPhoneTitle.visible = tvPhone.isVisible || tvPhone2.isVisible

                tvEmail.setTextString(contact.email)
                tvEmail2.setTextString(contact.secondEmail)
                tvEmailTitle.visible = tvEmail.isVisible || tvEmail2.isVisible

                tvDescription.setTextString(contact.description)
                tvDescriptionTitle.visible = tvDescription.isVisible
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
