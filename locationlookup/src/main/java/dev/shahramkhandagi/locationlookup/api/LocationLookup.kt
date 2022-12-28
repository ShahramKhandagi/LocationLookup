package dev.shahramkhandagi.locationlookup.api

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import dev.shahramkhandagi.locationlookup.models.Fields
import dev.shahramkhandagi.locationlookup.objects.RequestObject


class LocationLookup(requestQueue: RequestQueue) {
    private val requestRow: RequestQueue

    init {
        requestRow = requestQueue
    }

    // getting location information
    fun getLocationData(
        responseListener: Response.Listener<Fields>,
        errorListener: Response.ErrorListener?
    ) {
        val requestToGetData =
            RequestObject(
                Request.Method.GET, URL, Fields::class.java, null, responseListener, errorListener
            )
        requestRow.add(requestToGetData)
    }

    // get url
    companion object {
        private const val URL =
            "http://ip-api.com/json/?fields=country,countryCode,region,regionName,city,zip,lat,lon,timezone,currency,query"
    }
}