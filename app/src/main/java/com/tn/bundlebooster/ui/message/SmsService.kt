package com.tn.bundlebooster.ui.message

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.provider.Telephony

class SmsService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null;
    }

    override fun onCreate() {
        super.onCreate()

        val intentFilter = IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
        registerReceiver(SmsReceiver(), intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}