package se.hackforsweden.foodbox.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_start.*
import se.hackforsweden.foodbox.R

class StartFragment : Fragment(R.layout.fragment_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnOrder.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_orderPositionFragment)
        }
        btnCook.setOnClickListener {
            Toast.makeText(requireContext(),"Not implemented",Toast.LENGTH_SHORT).show()
        }
    }
}
