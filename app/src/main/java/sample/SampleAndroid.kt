package sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.ui.platform.setContent
import com.pandiandcode.mpp.cardsagainsthumanity.presenter.MainGamePresenter
import com.pandiandcode.mpp.cardsagainsthumanity.presenter.MainGameView


class MainActivity : AppCompatActivity(), MainGameView {

    lateinit var presenterMain: MainGamePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenterMain = MainGamePresenter()
        presenterMain.mainGameView = this
        presenterMain.start("Hola Juego", "Rocío")
    }

    override fun showState(json: String) {
        setContent {
            Text(json)
        }
    }
}