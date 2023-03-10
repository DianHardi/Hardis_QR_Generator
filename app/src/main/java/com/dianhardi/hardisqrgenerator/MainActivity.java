package com.dianhardi.hardisqrgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private Button btnCreate;
    private ImageView ivQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        btnCreate = findViewById(R.id.btnCreate);
        ivQRCode = findViewById(R.id.ivQRCode);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etInput.getText().toString().trim();

                MultiFormatWriter writer = new MultiFormatWriter();

                try {
                    BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 300, 300);

                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                    ivQRCode.setImageBitmap(bitmap);

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
