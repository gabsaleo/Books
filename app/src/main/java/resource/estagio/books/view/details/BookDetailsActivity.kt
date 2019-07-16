package resource.estagio.books.view.details

import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_details.*
import resource.estagio.books.R

class BookDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        bookTitle.text = intent.getStringExtra(EXTRA_TITLE)
        bookDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)

    }
    companion object{

        private const val  EXTRA_TITLE= "EXTRA_TITLE"
        private const val  EXTRA_DESCRIPTION= "EXTRA_DESCRIPTION"

        fun getIntent(context: Context, title: String, description: String): Intent{
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION , description)
            }
        }
    }
}
