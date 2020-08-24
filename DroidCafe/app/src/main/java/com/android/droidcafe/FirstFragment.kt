package com.android.droidcafe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {


    companion object{
        val MESSAGE = "OrderMessage"
    }

    var orderMessage:String = ""

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        donut.setOnClickListener {
            orderMessage = getString(R.string.donut_order_message)
            displayToast(getString(R.string.donut_order_message))
        }

        froyo.setOnClickListener {
            orderMessage = getString(R.string.froyo_order_message)
            displayToast(getString(R.string.froyo_order_message))
        }

        ice_cream.setOnClickListener {
            orderMessage = getString(R.string.ice_cream_order_message)
            displayToast(getString(R.string.ice_cream_order_message))
        }

        fab.setOnClickListener {
            setFragmentResult(MESSAGE, bundleOf("bundleKey" to orderMessage))
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    fun displayToast(message: String?) {
        Toast.makeText(
            context, message,
            Toast.LENGTH_SHORT
        ).show()
    }


}