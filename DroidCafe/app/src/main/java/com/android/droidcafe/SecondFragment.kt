package com.android.droidcafe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(),AdapterView.OnItemSelectedListener {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("OrderMessage"){
            resultKey, bundle ->
            val result = bundle.getString("bundleKey")
            order_textview.text = result
        }

        val spinner = view.findViewById<Spinner>(R.id.label_spinner)
        if(spinner!=null)
            spinner.onItemSelectedListener = this

        val adapter = context?.let { ArrayAdapter.createFromResource(it,R.array.labels_array,R.layout.support_simple_spinner_dropdown_item) }

        if (adapter != null) {
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        }

        if(spinner!=null)
            spinner.adapter = adapter
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val spinnerLabel = p0?.getItemAtPosition(p2).toString()
        displayToast(spinnerLabel)
    }

    private fun displayToast(spinnerLabel: String) {
        Toast.makeText(context,spinnerLabel,Toast.LENGTH_SHORT).show()
    }
}