
![](https://raw.githubusercontent.com/ShahramKhandagi/LocationLookup/master/app/src/main/res/drawable/locationlookupbanner.png)


# LocationLookup
[![Android](https://img.shields.io/badge/Android-LocationLookup-blue.svg?style=flat)](https://android-arsenal.com/details/1/2366)
[![Version](https://img.shields.io/badge/version-1.0.0-green.svg)](https://shields.io/)
[![Donate](https://img.shields.io/badge/donate-Buy%20Coffee-yellow)](https://www.buymeacoffee.com/shahramkhaE)


A Simple library for Android to get Location info like
 - Country
 - CountryCode
 - Region
 - RegionName
 - City
 - ZipCode
 - Latitude
 - Longitude
 - Timezone
 - Currency
 - Ip \
And this information is taken from the [IP-API-JSON](http://ip-api.com/json) using [Volley](https://google.github.io/volley/)

# How to Implement
To get a Git project into your build:
> Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories: <br/>
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
    
> Step 2. Add the dependency

Add it in your root app.gradle at the end of repositories: <br/>
```gradle
dependencies {
	...
    implementation 'com.github.ShahramKhandagi:LocationLookup:1.0.0'

    // Volley to make networking
    implementation 'com.android.volley:volley:1.2.1'

}
```
# Usage
It is very easy to use, like this:
```kotlin

val locationLookup = LocationLookup(Volley.newRequestQueue(this))
locationLookup.getLocationData({ response ->


    // get ip
    val ip = response.ip

    // get country
    val country = response.country!!

    // get city
    val city = response.city!!

    // and etc...
    val countryCode = response.countryCode!!
    val currency = response.currency!!
    val latitude = response.latitude!!
    val longitude = response.longitude!!
    val region = response.region!!
    val regionName = response.regionName!!
    val timezone = response.timezone!!
    val zipCode = response.zipCode!!


 }) { error
    -> val errorMessage: String = error.toString()
 }
```
---
## 🙏 Support

Don't forget to leave a star ⭐️





