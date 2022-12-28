package dev.shahramkhandagi.locationlookup.models

import com.google.gson.annotations.SerializedName

class Fields {

    @SerializedName("query")
    var ip: String? = null

    var city: String? = null
    var region: String? = null
    var regionName: String? = null
    var country: String? = null
    var countryCode: String? = null
    var currency: String? = null
    var timezone: String? = null

    @SerializedName("lon")
    var longitude: Double? = null

    @SerializedName("lat")
    var latitude: Double? = null

    @SerializedName("zip")
    var zipCode: String? = null
}