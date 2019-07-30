package resource.estagio.books.view.books

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.toolbar.*
import resource.estagio.books.R
import resource.estagio.books.view.base.BaseActivity
import resource.estagio.books.view.details.BookDetailsActivity

class BooksActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        setupToolbar(toolbarMain, R.string.books_title)

        val viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)
        viewModel.booksLiveData.observe(this, Observer {
            it?.let { books ->
                with(recyclerView) {
                    layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books) { book ->
                        val intent = BookDetailsActivity.getIntent(this@BooksActivity, book.title, book.description)
                        this@BooksActivity.startActivity(intent)
                    }
                }
            }
        })
        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { view_Flipper ->
                viewFlipper.displayedChild = view_Flipper.first

                view_Flipper.second?.let { errorMessage ->
                    textError.text = getString(errorMessage)
                }
            }
        })


        viewModel.getBooks();


    }


}
