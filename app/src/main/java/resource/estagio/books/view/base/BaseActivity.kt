package resource.estagio.books.view.base

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import resource.estagio.books.R

open class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, titleId : Int, showBackButton : Boolean = false){
        toolbar.title = getString(titleId)
        setSupportActionBar(toolbar)
        if(showBackButton){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

}