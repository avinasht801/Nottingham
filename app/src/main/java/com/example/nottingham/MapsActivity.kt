package com.example.nottingham

import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
//import com.example.mapapp.databinding.ActivityMapsBinding
import com.example.nottingham.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var fusedLocationProviderClient: FusedLocationProviderClient? = null
    private var currentLocation: Location?= null
    val REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        fetchLocation()
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*  val mapFragment = supportFragmentManager
              .findFragmentById(R.id.map) as SupportMapFragment
          mapFragment.getMapAsync(this)*/
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val latlng = LatLng(currentLocation!!.latitude,currentLocation!!.longitude)

        val markerOptions= MarkerOptions().position(latlng).title("You are here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)

        )



        mMap.animateCamera(CameraUpdateFactory.newLatLng(latlng))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,15f))
        mMap.addMarker(markerOptions)


        val hucknall = LatLng(53.036166522, -1.190665904)
        mMap.addMarker(MarkerOptions().position(hucknall).title("Hucknall Tram Stop"))
        val phoenix = LatLng(	52.988882, -1.207023)
        mMap.addMarker(MarkerOptions().position(phoenix).title("Phoenix Park Tram Stop"))
        val butler = LatLng(53.028786, 	-1.188458)
        mMap.addMarker(MarkerOptions().position(butler).title("Butler's Hill Tram Stop"))
        val cinder = LatLng(52.988983, -1.20072)
        mMap.addMarker(MarkerOptions().position(cinder).title("Cinderhill Tram Stop"))
        val highbury = LatLng(	52.989826, 	-1.189665)
        mMap.addMarker(MarkerOptions().position(highbury).title("Highbury vale Tram Stop"))
        val david = LatLng(	52.984875, -1.182161)
        mMap.addMarker(MarkerOptions().position(david).title("David Lane Tram Stop"))
        val basford = LatLng(52.981648, -1.17829)
        mMap.addMarker(MarkerOptions().position(basford).title("Basford Tram Stop"))
        val wilkinson = LatLng(	52.971803, 	-1.178015)
        mMap.addMarker(MarkerOptions().position(wilkinson).title("Wilkinson Street Tram Stop"))
        val shipstone = LatLng(	52.971546, 	-1.173463)
        mMap.addMarker(MarkerOptions().position(shipstone).title("Shipstone Street Tram Stop"))
        val beaconsfield = LatLng(	52.970233, -1.170793)
        mMap.addMarker(MarkerOptions().position(beaconsfield).title("Beaconsfield Tram Stop"))
        val noel = LatLng(52.966749, -1.168745)
        mMap.addMarker(MarkerOptions().position(noel).title("Noel Street Tram Stop"))
        val radford = LatLng(	52.96958, -1.17367)
        mMap.addMarker(MarkerOptions().position(radford).title("Radford Road Tram Stop"))
        val hyson = LatLng(	52.96628, -1.171032)
        mMap.addMarker(MarkerOptions().position(hyson).title("Hyson Green Tram Stop"))
        val forest = LatLng(52.965111, -1.167243)
        mMap.addMarker(MarkerOptions().position(forest).title("The Forest Tram Stop"))
        val hschool = LatLng(52.96261, -1.161857)
        mMap.addMarker(MarkerOptions().position(hschool).title("High School Tram Stop"))
        val ntu= LatLng(52.958252, 	-1.155644)
        mMap.addMarker(MarkerOptions().position(ntu).title("Nottingham Trent University Tram Stop"))
        val royal = LatLng(	52.955124, 	-1.152029)
        mMap.addMarker(MarkerOptions().position(royal).title("Royal Centre Tram Stop"))
        val omarket = LatLng(52.953043, -1.150119)
        mMap.addMarker(MarkerOptions().position(omarket).title("Old Market Square Tram Stop"))
        val lace = LatLng(		52.952956, 	-1.145537)
        mMap.addMarker(MarkerOptions().position(lace).title("Lace Market Tram Stop"))
        val nstation = LatLng(	52.947596, -1.145225)
        mMap.addMarker(MarkerOptions().position(nstation).title("Nottingham Station Tram Stop"))
        val queen = LatLng(	52.942761, 	-1.150395)
        mMap.addMarker(MarkerOptions().position(queen).title("Queens Walk Tram Stop"))
        val meadows = LatLng(		52.939072, -1.153726)
        mMap.addMarker(MarkerOptions().position(meadows).title("Meadows Embankment Tram Stop"))
        val wvillage = LatLng(	52.935742, -1.155725)
        mMap.addMarker(MarkerOptions().position(wvillage).title("Wilford Village Tram Stop"))
        val wlane = LatLng(	52.925911, 	-1.156214)
        mMap.addMarker(MarkerOptions().position(wlane).title("Wilford Lane Tram Stop"))
        val compton = LatLng(52.91907, -1.157507)
        mMap.addMarker(MarkerOptions().position(compton).title("Compton Acres Tram Stop"))
        val ruddington = LatLng(		52.91907, -1.157507)
        mMap.addMarker(MarkerOptions().position(ruddington).title("Ruddington Lane Tram Stop"))
        val schurch = LatLng(52.910729, -1.170413)
        mMap.addMarker(MarkerOptions().position(schurch).title("Southchurch Drive Tram Stop"))
        val rivergreen = LatLng(52.906876, 	-1.174768)
        mMap.addMarker(MarkerOptions().position(rivergreen).title("Rivergreen Tram Stop"))
        val cliftonc = LatLng(		52.903736, -1.177014)
        mMap.addMarker(MarkerOptions().position(cliftonc).title("Clifton Centre Tram Stop"))
        val trinity = LatLng(		52.897014, 	-1.181259)
        mMap.addMarker(MarkerOptions().position(trinity).title("Holy Trinity Tram Stop"))
        val summer = LatLng(		52.896925, 	-1.18792)
        mMap.addMarker(MarkerOptions().position(summer).title("Summerwood Lane Tram Stop"))
        val cliftons = LatLng(		52.896652, 	-1.192697)
        mMap.addMarker(MarkerOptions().position(cliftons).title("Clifton South Tram Stop"))
        val west = LatLng(		52.943345, 	-1.156679)
        mMap.addMarker(MarkerOptions().position(west).title("Meadows Way West Tram Stop"))
        val ng2 = LatLng(		52.941814, 	-1.16522)
        mMap.addMarker(MarkerOptions().position(ng2).title("NG2 Tram Stop"))
        val gregory = LatLng(		52.943875, 	-1.177041)
        mMap.addMarker(MarkerOptions().position(gregory).title("Gregory Street Tram Stop"))
        val medical = LatLng(		52.942554, -1.183748)
        mMap.addMarker(MarkerOptions().position(medical).title("Queens Medical Centre Tram Stop"))
        val uon = LatLng(	52.937402, -1.188184)
        mMap.addMarker(MarkerOptions().position(uon).title("University of Nottingham Tram Stop"))
        val middle = LatLng(		52.927848, 	-1.209061)
        mMap.addMarker(MarkerOptions().position(middle).title("Middle Street Tram Stop"))
        val beeston = LatLng(		52.92508, 	-1.21457)
        mMap.addMarker(MarkerOptions().position(beeston).title("Beeston Street Tram Stop"))
        val chilwell = LatLng(		52.922699, -1.220206)
        mMap.addMarker(MarkerOptions().position(chilwell).title("Chilwell Road Tram Stop"))
        val central = LatLng(	52.921237, -1.223084)
        mMap.addMarker(MarkerOptions().position(central).title("High Road-Central College Tram Stop"))
        val cator = LatLng(		52.922636, -1.231485)
        mMap.addMarker(MarkerOptions().position(cator).title("Cator Lane Tram Stop"))
        val bramcote = LatLng(		52.921562, -1.236216)
        mMap.addMarker(MarkerOptions().position(bramcote).title("Bramcote Lane Tram Stop"))
        val eskdale = LatLng(		52.920357, 	-1.243123)
        mMap.addMarker(MarkerOptions().position(eskdale).title("Eskdale Drive Tram Stop"))
        val inham = LatLng(	52.919576, -1.25146)
        mMap.addMarker(MarkerOptions().position(inham).title("Inham Road Tram Stop"))
        val toton = LatLng(	52.918437, -1.262343)
        mMap.addMarker(MarkerOptions().position(toton).title("Toton Lane Tram Stop"))




    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_CODE -> {
                if(grantResults.size > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    fetchLocation()
                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


    }
    private fun fetchLocation(){
        val task = fusedLocationProviderClient!!.lastLocation

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),101)
            return
        }
        task.addOnSuccessListener {location->
            if(location!=null){
                currentLocation=  location
                val supportMapFragment = (supportFragmentManager.findFragmentById(R.id.map)as SupportMapFragment)
                supportMapFragment!!.getMapAsync(this@MapsActivity)
            }
        }

    }
}