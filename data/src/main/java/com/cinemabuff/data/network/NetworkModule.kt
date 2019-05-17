package com.cinemabuff.data.network

import com.cinemabuff.data.BuildConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single<OkHttpClient>(DEFAULT_NAMESPACE) { provideDefaultOkhttpClient() }
    single<Retrofit>(DEFAULT_NAMESPACE) { provideRetrofit(get(DEFAULT_NAMESPACE)) }
    single<TmdbApi> { provideTmdbService(get(DEFAULT_NAMESPACE)) }

}

fun provideDefaultOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}

fun provideTmdbService(retrofit: Retrofit): TmdbApi = retrofit.create(TmdbApi::class.java)

const val DEFAULT_NAMESPACE = "default"