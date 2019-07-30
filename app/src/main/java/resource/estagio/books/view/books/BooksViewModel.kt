package resource.estagio.books.view.books

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import resource.estagio.books.R
import resource.estagio.books.data.RetrofitClient
import resource.estagio.books.data.response.BookBodyResponse
import resource.estagio.books.data.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData();
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData();

    fun getBooks() {
        RetrofitClient.service.getBooks().enqueue(object : Callback<BookBodyResponse> {

            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                when {
                    response.isSuccessful -> {
                        val books: MutableList<Book> = mutableListOf()

                        response.body()?.let { bookBodyResponse ->
                            for (results in bookBodyResponse.bookResult) {
                                val book = results.bookDetails[0].getBookDetailModel()
                                books.add(book)
                            }
                        }
                        booksLiveData.value = books
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_BOOKS, null)
                    }
                    response.code() == 401 ->
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_401)

                    else -> viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_401)
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.books_error_500)
            }

        })


    }

    companion object {
        private const val VIEW_FLIPPER_BOOKS = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }


}