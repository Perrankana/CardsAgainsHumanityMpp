package sample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pandiandcode.mpp.cardsagainsthumanity.createApplicationScreenMessage
import com.pandiandcode.mpp.cardsagainsthumanity.presenter.RecipePresenter
import com.pandiandcode.mpp.cardsagainsthumanity.presenter.View


class MainActivity : AppCompatActivity(), View {

    lateinit var presenter: RecipePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        presenter = RecipePresenter()
        presenter.view = this
        presenter.start()
    }

    override fun showState(json: String) {
        findViewById<TextView>(R.id.main_text).text = json
    }
}