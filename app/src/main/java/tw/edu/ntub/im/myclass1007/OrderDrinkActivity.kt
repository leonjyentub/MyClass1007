package tw.edu.ntub.im.myclass1007

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OrderDrinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_drink)
        val btnOK = findViewById<Button>(R.id.btnFoodOK)
        btnOK.setOnClickListener {
            var str = intent.getStringExtra("name")
            intent.putExtra("result", "$str, 把值傳回去啊")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}