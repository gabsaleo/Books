package resource.estagio.books.data.response

import com.squareup.moshi.JsonClass
import resource.estagio.books.data.model.Book

@JsonClass(generateAdapter = true)
data class BookDetailsResponse (

    val title: String,
    val author: String,
    val description: String
){
    fun getBookDetailModel() = Book(
        title = this.title,
        author = this.author,
        description = this.description
    )
}
