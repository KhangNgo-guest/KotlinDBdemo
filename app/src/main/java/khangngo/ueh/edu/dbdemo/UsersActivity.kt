package khangngo.ueh.edu.dbdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_users.*

class UsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        val db = DBHandling(this)
        btnRegister.setOnClickListener { 
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()
            db.addUser(email, password)
        }
        
        btnLogin.setOnClickListener { 
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()
            var ret = db.getUser(email, password)
            if (ret){
                Toast.makeText(this, "Thông tin chính xác", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Thông tin không hợp lệ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}