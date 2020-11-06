package com.tn.bundlebooster.ui.message


import android.content.Intent
import android.os.Bundle
import android.telephony.SmsManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tn.bundlebooster.R
import kotlinx.android.synthetic.main.fragment_message.*

class MessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val smsManager = SmsManager.getDefault()
        val smsIntent = Intent(context, SmsService::class.java)
        context?.startService(smsIntent)

        sendButton.setOnClickListener {
            smsManager.sendTextMessage("1280", null, "NOG 1GB", null, null)
        }
    }
}
