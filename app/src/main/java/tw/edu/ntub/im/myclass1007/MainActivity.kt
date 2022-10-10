package tw.edu.ntub.im.myclass1007

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    /**
     * https://developer.android.com/training/basics/intents/result
     * 首先註冊一個 callBack 回來要處理的 API，registerForActivityResult()，就是取代以前的 onActivityResult()的用法。
     */
    var orderDrinkLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val myData: Intent? = result.data
                if (myData != null) {
                    Log.d("twoActivities", "MY_DATA:" + myData.getStringExtra("result"))
                }
            }
        }

    var orderFoodLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val myData: Intent? = result.data
            if (myData != null) {
                Log.d("twoActivities", "MY_DATA:" + myData.getStringExtra("result"))
            }
        }else{
            Log.d("twoActivities", "已取消")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOrderDrink: Button = findViewById(R.id.btnDrink)
        val btnOrderFood = findViewById<Button>(R.id.btnFood)

        btnOrderDrink.setOnClickListener {
            val myit = Intent(this, OrderDrinkActivity::class.java).apply{
                this.putExtra("name", "林ㄚ杰")
                this.putExtra("number", 30)
            }
            //startActivityForResult(it, 9999) 被棄用是怎樣啦
            orderDrinkLauncher.launch(myit)
        }
        btnOrderFood.setOnClickListener {
            val myit = Intent(this, OrderFoodActivity::class.java).apply{
                this.putExtra("name", "林ㄚ杰")
            }
            orderFoodLauncher.launch(myit)
        }
    }
}