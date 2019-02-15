package com.example.calvin.chinatown;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;

public class ScannedBarcodeActivity extends Activity implements QRCodeView.Delegate {

    QRCodeView mQRCodeView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scannedbarcode);

        mQRCodeView = findViewById(R.id.zbarview);
        mQRCodeView.setDelegate(this);
    }

    public void onScanQRCodeSuccess(String result) {
        vibrate();
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();

        mQRCodeView.startSpot();
    }


    public void onScanQRCodeOpenCameraError() {
        Toast.makeText(this,"错误",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();//打开相机
        mQRCodeView.showScanRect();//显示扫描框
        mQRCodeView.startSpot();//开始识别二维码
        //mQRCodeView.openFlashlight();//开灯
        //mQRCodeView.closeFlashlight();//关灯
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }
}
