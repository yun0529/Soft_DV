package com.gnu.softdv.config

import com.gnu.softdv.config.ApplicationClass.Companion.HEADER_TOKEN
import com.gnu.softdv.config.ApplicationClass.Companion.sDB
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HAccessTokenInterceptor : Interceptor{
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String? = sDB.getString(HEADER_TOKEN, null)
        if (jwtToken != null) {
            builder.addHeader("HEADER_TOKEN", jwtToken)
        }
        return chain.proceed(builder.build())
    }
}