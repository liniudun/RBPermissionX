package com.nnweather.rbpermissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.permissionx.niudundev.RBPermissionX
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //点击
        button.setOnClickListener {
            RBPermissionX.request(this,Manifest.permission.CALL_PHONE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) { allGranted,deniedList ->
                if (allGranted){
                    Toast.makeText(this,"All permission are granted", Toast.LENGTH_SHORT).show()
                    call()
                }else{
                    Toast.makeText(this,"You denied $deniedList", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun call(){
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10010")
            startActivity(intent)
        }catch (e:SecurityException){
            e.printStackTrace()
        }
    }
}