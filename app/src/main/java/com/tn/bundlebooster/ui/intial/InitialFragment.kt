package com.tn.bundlebooster.ui.intial


import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fondesa.kpermissions.extension.listeners
import com.fondesa.kpermissions.extension.permissionsBuilder
import com.tn.bundlebooster.R
import es.dmoral.toasty.Toasty

class InitialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_initial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val request =
            permissionsBuilder(Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS).build()

        request.send()

        request.listeners {
            onAccepted {
                findNavController().navigate(R.id.action_initialFragment_to_messageFragment)
            }
            onDenied {
//                Toasty.warning(requireContext(), "SMS permission is necessary for this app to work!", Toast.LENGTH_LONG).duration
                request.send()
            }
            onPermanentlyDenied {
                Toasty.error(requireContext(), "SMS permission is necessary for this app to work!", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

}
