package com.example.logoquizapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.coroutines.CoroutineContext

class LogoListingViewModel(private val fetcher: LogoListingFetcherImpl) : ViewModel(), CoroutineScope {

    private val coroutineContext: CoroutineContext = viewModelScope.coroutineContext + Dispatchers.Default

    //make them ovverridenn
    //expose only LiveData not MutableLiveData
    val logoListingResponsePageDataLD: MutableLiveData<List<LogoListingItem>> = MutableLiveData()

    override suspend fun getSdkResponseData(): ArrayList<LogoListingItem> {
        val queryMap = hashMapOf<String, String>()
        return fetcher.getSdkResponseData(queryMap)
    }

    override fun loadPage() {
        // show a loading state by communccating to view using live data

        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            logAndPrintException(throwable)
            doOnError()
        }
        launch(exceptionHandler) {
            withContext(Dispatchers.IO) {
                val sdkResponseData = getSdkResponseData()
                handleSdkResponseResult(sdkResponseData)
            }
        }
    }

    private fun handleSdkResponseResult(list: ArrayList<LogoListingItem>) {
        //remove loading state
        logoListingResponsePageDataLD.value = list
    }

    private fun doOnError() {
        // show something went wrong state
    }
}