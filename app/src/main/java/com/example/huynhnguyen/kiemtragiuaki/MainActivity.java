package com.example.huynhnguyen.kiemtragiuaki;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editMa,editTen,editChiMoi,editChiSoCu;
    private RadioButton rdGiaDinh,rdHanhChinh,rdSanXuat;
    private Button btnThem,btnXoa;
    private ArrayList<String> arr;
    private ListView listView;
    private ArrayAdapter arradp;
    int vitri=0;
    public static final String MA="MA";
    public static final String TEN="TEN";
    public static final String CSM="CSM";
    public static final String CSC="CSC";
    public static final String TIENDIEN="TIENDIEN";
    public static final String BUNDLE="BUNDLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMa=(EditText) findViewById(R.id.editMaKH);
        editTen=(EditText) findViewById(R.id.editTenKH);
        editChiMoi=(EditText) findViewById(R.id.editChiSoMoi);
        editChiSoCu=(EditText) findViewById(R.id.editChiSoCu);
        rdGiaDinh=(RadioButton) findViewById(R.id.rdgiadinh);
        rdHanhChinh=(RadioButton) findViewById(R.id.rdhanhchinh);
        rdSanXuat=(RadioButton) findViewById(R.id.rddonvisanxuat);
        btnThem=(Button) findViewById(R.id.btnThem);
        btnXoa=(Button) findViewById(R.id.btnXoa);
        listView=(ListView) findViewById(R.id.listview);
        arr = new ArrayList<String>();
        arradp = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(arradp);
        String ma=editMa.getText().toString().trim();
        String name=editTen.getText().toString().trim();
        String csm=editChiMoi.getText().toString().trim();
        String csc=editChiSoCu.getText().toString().trim();
        String tiendienkh=String.valueOf(TienDien());

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma=editMa.getText().toString().trim();
                String name=editTen.getText().toString().trim();
                String csm=editChiMoi.getText().toString().trim();
                String csc=editChiSoCu.getText().toString().trim();
                String tiendienkh=String.valueOf(TienDien());
                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(ma) || TextUtils.isEmpty(csm)|| TextUtils.isEmpty(csc)) {
                    Toast.makeText(MainActivity.this,"Vui long nhap day du thong tin",Toast.LENGTH_SHORT).show();
                }
                else {
                    String s="Mã:"+ma+"; Tên:"+name+"; CsMoi:"+csm+"; CsCu:"+csc+"; TienDien:"+TienDien();
                    arr.add(s);
                    arradp.notifyDataSetChanged();
                }


            }
        });
        registerForContextMenu(listView);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editChiMoi.setText("");
                editChiSoCu.setText("");
                editTen.setText("");
                editMa.setText("");
                editMa.requestFocus();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                vitri=position;
            }
        });
       
    }
    private int TienDien(){
        int tienDien = 0;
        if(rdHanhChinh.isChecked()==true)
        {
            String chiSoMoi=editChiMoi.getText().toString().trim();
            String chiSoCu=editChiSoCu.getText().toString().trim();
            int loai1;
            loai1= Integer.parseInt(chiSoMoi)-  Integer.parseInt(chiSoCu);
            if(loai1<=50)
            {
                tienDien =  loai1*1550;
            }
            if(loai1>50 && loai1<=100)
            {
                tienDien =  loai1*1600;
            }
            if(loai1>100)
            {
                tienDien =  loai1*1670;
            }
        }
        else{
            if(rdSanXuat.isChecked()==true)
            {
                String chiSoMoi=editChiMoi.getText().toString().trim();
                String chiSoCu=editChiSoCu.getText().toString().trim();
                int loai2;
                loai2= Integer.parseInt(chiSoMoi)-  Integer.parseInt(chiSoCu);
                if(loai2<=50)
                {
                    tienDien =  loai2*1400;
                }
                if(loai2>50 && loai2<=100)
                {
                    tienDien =  loai2*1500;
                }
                if(loai2>100)
                {
                    tienDien =  loai2*1550;
                }
            }
            if(rdGiaDinh.isChecked()==true)
            {
                String chiSoMoi=editChiMoi.getText().toString().trim();
                String chiSoCu=editChiSoCu.getText().toString().trim();
                int loai3;
                loai3= Integer.parseInt(chiSoMoi)-  Integer.parseInt(chiSoCu);
                if(loai3<=50)
                {
                    tienDien =  loai3*1450;
                }
                if(loai3>50 && loai3<=100)
                {
                    tienDien =  loai3*1500;
                }
                if(loai3>100)
                {
                    tienDien =  loai3*1750;
                }
            }
        }
        return tienDien;
    }
    public void guidulieu(String makh,String tenkh,String csmkh,String csckh,String tiendienkh){
        
        Intent intent=new Intent(MainActivity.this,ChiTietActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString(MA,makh);
        bundle.putString(TEN,tenkh);
        bundle.putString(CSM,csmkh);
        bundle.putString(CSC,csckh);
        bundle.putString(TIENDIEN,tiendienkh);
        intent.putExtra(BUNDLE,bundle);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //t lam switch
        switch (item.getItemId())
        {
            case R.id.mnXoa:
                //cho nay lam gi khi nhan zo chu xoa day..lam gi thi ghi vao
                arr.remove(vitri); // m lay vi tri chua .. co su kien khi nhan vao listview chua chua..nhan vao moi lay dc vi tri
                //khong lay duoc ten de hien thi len editText...t tao cai contact rieng lamf`..de t xem lai cai arr nay`..  nho"lay dc mak..t lay 1 ln rout dd
                arradp.notifyDataSetChanged();
                break;
            case R.id.mnChiTiet:
                String ma=editMa.getText().toString().trim();
                String name=editTen.getText().toString().trim();
                String csm=editChiMoi.getText().toString().trim();
                String csc=editChiSoCu.getText().toString().trim();
                String tiendienkh=String.valueOf(TienDien());
                //cho nay m cho pt send du lieu qua...la no chuyen qua layout moi

                guidulieu(ma,name,csm,csc,tiendienkh);
                break;
        }
        return super.onContextItemSelected(item);
    }
}

