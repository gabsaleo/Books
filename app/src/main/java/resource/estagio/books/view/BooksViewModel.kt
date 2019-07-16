package resource.estagio.books.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import resource.estagio.books.model.Book

class BooksViewModel : ViewModel() {

    val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData();

    fun getBooks(){
        booksLiveData.value = createFakeBooks();
    }
    fun createFakeBooks(): List<Book> {
        return listOf(
            Book("Title", "Author 1"),
            Book("Title 2", "Author 2"),
            Book("Title 3", "Author 3")
        )
    }


}