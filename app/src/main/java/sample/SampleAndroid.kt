package sample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jetbrains.handson.mpp.mobile.createApplicationScreenMessage


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.main_text).text = createApplicationScreenMessage()
    }
}