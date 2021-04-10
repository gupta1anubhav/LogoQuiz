package com.example.logoquizapp

class LogoListingFetcherImpl(private val service: LogoListingService) {
    suspend fun getSdkResponseData(map: HashMap<String, String>): ArrayList<LogoListingItem> {
        return service.getSdkResponse()
    }
}