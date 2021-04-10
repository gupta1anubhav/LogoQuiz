package com.example.logoquizapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LogoListingItem(
    @Expose @SerializedName("imgUrl") val url: String?,
    @Expose @SerializedName("name") val name: String?
) : Serializable