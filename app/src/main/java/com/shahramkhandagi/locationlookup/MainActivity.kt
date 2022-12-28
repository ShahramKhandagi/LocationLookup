package com.shahramkhandagi.locationlookup

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import dev.shahramkhandagi.locationlookup.api.LocationLookup
import soup.neumorphism.NeumorphTextView


class MainActivity : AppCompatActivity() {


    // bind views
    lateinit var countryText: NeumorphTextView
    lateinit var ipText: TextView
    lateinit var latitudeText: TextView
    lateinit var longitudeText: TextView
    lateinit var zipCodeText: TextView
    lateinit var currencyText: TextView
    lateinit var timeZoneText: TextView
    lateinit var countryCodeText: TextView
    lateinit var regionText: TextView
    lateinit var regionImage: ImageView
    lateinit var cityText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()


        // usage
        val locationLookup = LocationLookup(Volley.newRequestQueue(this))
        locationLookup.getLocationData({ response ->

            val ip = response.ip
            val country = response.country!!
            val city = response.city!!
            val countryCode = response.countryCode!!
            val currency = response.currency!!
            val latitude = response.latitude!!
            val longitude = response.longitude!!
            val region = response.region!!
            val regionName = response.regionName!!
            val timezone = response.timezone!!
            val zipCode = response.zipCode!!


            countryText.text = country
            ipText.text = "Ip: $ip"
            latitudeText.text = "Latitude: $latitude"
            longitudeText.text = "Longitude: $longitude"
            zipCodeText.text = "ZipCode: $zipCode"
            currencyText.text = "Currency: $currency"
            timeZoneText.text = "TimeZone: $timezone"
            countryCodeText.text = "CountryCode: $countryCode"
            regionText.text = "Region: $region"
            cityText.text = "City: $city"

            Glide
                .with(this)
                .load("https://countryflagsapi.com/png/$countryCode")
                .into(regionImage)


        }) { error
            -> val errorMessage: String = error.toString()
        }
    }

    // binding function
    private fun bind() {
        countryText = findViewById(R.id.country_txt)
        ipText = findViewById(R.id.ip_txt)
        latitudeText = findViewById(R.id.latitude_txt)
        longitudeText = findViewById(R.id.longitude_txt)
        zipCodeText = findViewById(R.id.zipCode_txt)
        currencyText = findViewById(R.id.currency_txt)
        timeZoneText = findViewById(R.id.timezone_txt)
        countryCodeText = findViewById(R.id.countryCode_txt)
        regionText = findViewById(R.id.region_txt)
        regionImage = findViewById(R.id.region_img)
        cityText = findViewById(R.id.city_txt)
    }
}