package tw.edu.ntub.im.myclass1007

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OrderFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_food)
        val btnOK = findViewById<Button>(R.id.btnFoodOK)
        val btnCancel = findViewById<Button>(R.id.btnFoodCancel)

        btnOK.setOnClickListener {
            var str = intent.getStringExtra("name")
            intent.putExtra("result", "$str, 把值傳回去啊")
            setResult(RESULT_OK, intent)
            finish()
        }

        btnCancel.setOnClickListener {
            var str = intent.getStringExtra("name")
            intent.putExtra("result", "$str, 不要把值傳回去啊")
            setResult(RESULT_CANCELED, intent)
            finish()
        }
    }
}