package com.example.huynhnguyen.kiemtragiuaki;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HuynhNguyen on 11/18/2017.
 */

public class ChiTietActivity extends AppCompatActivity {
    private TextView txtMa,txtTen,txtCsm,txtCsc,txtTienDien;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_layout);
        anhxa();
        Intent intent=getIntent();
          Bundle bundle= intent.getBundleExtra(MainActivity.BUNDLE);
          String ma=bundle.getString(MainActivity.MA);
          String ten=bundle.getString(MainActivity.TEN);
          String csm=bundle.getString(MainActivity.CSM);
          String csc=bundle.getString(MainActivity.CSC);
          String tiendien=bundle.getString(MainActivity.TIENDIEN);
          txtMa.setText(ma);
          txtTen.setText(ten);
          txtCsm.setText(csm);
          txtCsc.setText(csc);
          txtTienDien.setText(tiendien);

    }
    private void anhxa(){
         txtMa=(TextView) findViewById(R.id.txtMa);
         txtTen=(TextView) findViewById(R.id.txtTenn);
         txtCsm=(TextView) findViewById(R.id.txtChiSoMoi);
         txtCsc=(TextView) findViewById(R.id.txtCHiSoCu);
         txtTienDien=(TextView) findViewById(R.id.txtTienDien);

    }
}
