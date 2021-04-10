package com.example.logoquizapp

interface LogoListingService {
    // dummy api
    @POST
    suspend fun getSdkResponse(): ArrayList<LogoListingItem>
}