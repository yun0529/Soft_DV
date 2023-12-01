package com.gnu.softdv

import android.util.Log
import com.gnu.softdv.config.ApplicationClass
import com.gnu.softdv.config.HAccessTokenInterceptor
import com.gnu.softdv.src.search.result.SearchFragmentInterface
import com.gnu.softdv.src.search.result.SearchService
import com.gnu.softdv.src.search.result.model.SearchResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface SearchInterface{
    @GET("app/search") // Get 메소드로 API 호출
    fun getSearch(@Query("input") input : String // Query Params 형태의 데이터를 서버로 송신
    ): Call<SearchResponse> // SearchResponse 형태로 응답을 받음
}

class RetrofitTest : SearchFragmentInterface{
    private lateinit var retrofit: Retrofit
    private lateinit var api: SearchInterface

    @Before
    fun setUp() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            // 로그캣에 okhttp.OkHttpClient 로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(HAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(ApplicationClass.API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(SearchInterface::class.java)
    }

    @Test
    fun getExchangeRateListApiTest() {
        api.getSearch(input = "사슴벌레")

    }

    override fun onGetSearchSuccess(response: SearchResponse) {
        assertTrue(response.isSuccess)
        assertNotNull(response.result)
    }

    override fun onGetSearchFailure(message: String) {
        Log.d("Error", message)
    }

}