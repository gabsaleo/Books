package resource.estagio.books.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_book.view.*
import resource.estagio.books.R
import resource.estagio.books.model.Book

class BooksAdapter(
        private val books: List<Book>
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false);
        return BooksViewHolder(itemView);
    }

    override fun getItemCount()= books.count()

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(books[position])
    }


    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val title = itemView.title
        private val author = itemView.author

        fun bindView( book: Book){
            title.text = book.title
            author.text = book.author
        }
    }
}