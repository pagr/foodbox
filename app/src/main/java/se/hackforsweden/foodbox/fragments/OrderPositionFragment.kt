package se.hackforsweden.foodbox.fragments

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_order_position.*
import se.hackforsweden.foodbox.R

class OrderPositionFragment : Fragment(R.layout.fragment_order_position) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView.onCreate(savedInstanceState)
        setupMaps()
    }

    private fun setupMaps() {
        if (!checkLocationPermission()) {
            requestLocationPermission()
            return
        }
        mapView.getMapAsync { map ->
            map.isMyLocationEnabled = true
            val provider = LocationServices.getFusedLocationProviderClient(requireContext())
            provider.lastLocation.addOnSuccessListener {
                Log.d("Maps", "Location $it")
                map?.animateCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        LatLng(it.latitude, it.longitude), 13F
                    )
                )
            }.addOnFailureListener {
                Log.d("Maps", "Location failed $it")
            }
        }


    }

    private fun requestLocationPermission() {
        requestPermissions(arrayOf(ACCESS_FINE_LOCATION), 0)
    }

    private fun checkLocationPermission(): Boolean {
        return (ContextCompat.checkSelfPermission(
            requireContext(), ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED)
    }

    override fun onResume() {
        mapView.onResume()
        super.onResume()
        setupMaps()
    }


    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
