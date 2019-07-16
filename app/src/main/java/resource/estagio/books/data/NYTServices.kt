package resource.estagio.books.data

import resource.estagio.books.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {


    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String= "y6KGBvdQnbWrEctffKqFGUmGkGxtJFgo",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}