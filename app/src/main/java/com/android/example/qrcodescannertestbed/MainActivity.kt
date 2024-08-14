package com.android.example.qrcodescannertestbed

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start QRCodeScannerActivity when the app starts
        val intent = Intent(this, QRCodeScannerActivity::class.java)
        startActivity(intent)

        // Finish the MainActivity so it doesn't remain in the back stack
        finish()
    }
}

