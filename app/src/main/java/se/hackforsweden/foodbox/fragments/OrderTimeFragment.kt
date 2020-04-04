package se.hackforsweden.foodbox.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_order_time.*
import se.hackforsweden.foodbox.R
import se.hackforsweden.foodbox.adapter.TimeAdapter

class OrderTimeFragment : Fragment(R.layout.fragment_order_time) {

    private val timeAdapter: TimeAdapter by lazy {
        TimeAdapter() {
            //On item click
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        times.adapter = timeAdapter
        timeAdapter.submitList(
            listOf(
                "11:00-11:30",
                "12:00-12:30",
                "13:00-13:30",
                "14:00-14:30",
                "15:00-15:30",
                "16:00-16:30",
                "17:00-17:30",
                "18:00-18:30",
                "19:00-19:30",
                "20:00-20:30"
            )
        )
    }
}
