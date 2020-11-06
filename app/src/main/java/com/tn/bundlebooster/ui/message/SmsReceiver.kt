package com.tn.bundlebooster.ui.message

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsManager
import android.telephony.SmsMessage

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            val smsManager = SmsManager.getDefault()
            val bundle = intent?.extras
            val messages: ArrayList<SmsMessage> = ArrayList()
            val pduArray: Array<Any> = bundle?.get("pdus") as Array<Any>

            for (pdu in pduArray) {
                messages.add(SmsMessage.createFromPdu(pdu as ByteArray, bundle.getString("format")))
            }

            messages.forEach { smsMessage ->
                if (smsMessage.displayOriginatingAddress == "Tele2") {
                    if (smsMessage.messageBody.contains("80%") || smsMessage.messageBody.contains("100%")) {
                        smsManager.sendTextMessage("1280", null, "NOG 1GB", null, null)
                    }
                }
            }
        }
    }
}