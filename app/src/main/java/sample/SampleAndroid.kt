package sample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pandiandcode.mpp.cardsagainsthumanity.presenter.MainGamePresenter
import com.pandiandcode.mpp.cardsagainsthumanity.presenter.View


class MainActivity : AppCompatActivity(), View {

    lateinit var presenterMain: MainGamePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        presenterMain = MainGamePresenter()
        presenterMain.view = this
        presenterMain.start()
    }

    override fun showState(json: String) {
        findViewById<TextView>(R.id.main_text).text = json
    }
}