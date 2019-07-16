package resource.estagio.books.view.books

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import resource.estagio.books.data.RetrofitClient
import resource.estagio.books.data.response.BookBodyResponse
import resource.estagio.books.data.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData();

    fun getBooks() {
        RetrofitClient.service.getBooks().enqueue(object : Callback<BookBodyResponse> {

            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for (results in bookBodyResponse.bookResult) {
                            val book = Book(
                                    title = results.bookDetails[0].title,
                                    author = results.bookDetails[0].author,
                                    description = results.bookDetails[0].description
                            )
                            books.add(book)
                        }
                    }
                    booksLiveData.value = books
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }

        })


    }


}