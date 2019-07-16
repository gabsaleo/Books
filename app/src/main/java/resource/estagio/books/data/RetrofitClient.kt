package resource.estagio.books.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    private fun initRetrofit(): Retrofit{
         return Retrofit.Builder()
             .baseUrl("https://api.nytimes.com/svc/books/v3/")
             .addConverterFactory(MoshiConverterFactory.create())
             .build()
    }
    val service: NYTServices = initRetrofit().create(NYTServices::class.java)

}