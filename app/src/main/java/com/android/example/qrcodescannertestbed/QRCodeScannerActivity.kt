package com.android.example.qrcodescannertestbed

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


class QRCodeScannerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf<String>(Manifest.permission.CAMERA),
                    QRCodeScannerActivity.Companion.PERMISSION_REQUEST_CAMERA
                )
            } else {
                initQRCodeScanner()
            }
        } else {
            initQRCodeScanner()
        }
    }

    private fun initQRCodeScanner() {
        // Initialize QR code scanner here
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == QRCodeScannerActivity.Companion.PERMISSION_REQUEST_CAMERA) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initQRCodeScanner()
            } else {
                Toast.makeText(this, "Camera permission is required", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    companion object {
        private const val PERMISSION_REQUEST_CAMERA = 1
    }
}