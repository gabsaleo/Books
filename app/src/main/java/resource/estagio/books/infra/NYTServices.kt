package resource.estagio.books.infra

import resource.estagio.books.model.Book
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("list") list: String = ""
    ): Call<List<Book>>
}