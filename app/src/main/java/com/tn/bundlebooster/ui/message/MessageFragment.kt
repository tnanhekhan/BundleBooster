package com.tn.bundlebooster.ui.message


import android.os.Bundle
import android.telephony.SmsManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tn.bundlebooster.R
import kotlinx.android.synthetic.main.fragment_message.*

/**
 * A simple [Fragment] subclass.
 */
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
        
        sendButton.setOnClickListener {
            val phoneNo = "1280"
            val message = messageEditText.text.toString()
            val amount = messageNumberEditText.text.toString().toInt()

            for (i in 1..amount) {
                smsManager.sendTextMessage(phoneNo, null, message, null, null)
            }
        }
    }
}
