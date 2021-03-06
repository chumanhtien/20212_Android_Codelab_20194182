package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText MSSV;
    EditText HoTen;
    EditText CCCD;
    EditText SDT;
    EditText Email;
    CalendarView NgaySinh;
    EditText QueQuan;
    EditText NoiO;
    Button register;
    CheckBox confirm;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MSSV = (EditText) findViewById(R.id.mssv);
        HoTen = (EditText)findViewById(R.id.ten);
        CCCD = (EditText) findViewById(R.id.cccd);
        SDT = (EditText) findViewById(R.id.sdt);
        Email = (EditText) findViewById(R.id.email);
        NgaySinh = (CalendarView) findViewById(R.id.ngaysinh);
        QueQuan = (EditText) findViewById(R.id.quequan);
        NoiO = (EditText) findViewById(R.id.noio);
        register = (Button) findViewById(R.id.register);
        confirm = (CheckBox) findViewById(R.id.check_cf);
        confirm.setChecked(false);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }

    boolean isEmpty(EditText text){
        String data = text.getText().toString();
        if (data.length() == 0) return true;
        else
            return false;
    }

    boolean isEmail(EditText text){
        String email = text.getText().toString().trim();
        return email.matches(emailPattern);
    }

    void checkDataEntered(){
        int c = 0;
        if (!confirm.isChecked()){
            Toast t = Toast.makeText(this, "B???n ph???i ?????ng ?? v???i ??i???u kho???n s??? d???ng!", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        if (isEmpty(MSSV)) {
            MSSV.setError("B???n ch??a nh???p MSSV!");
            c++;
        }
        if (isEmpty(HoTen)) {
            HoTen.setError("B???n ch??a nh???p H??? t??n!");
            c++;
        }
        if (isEmpty(CCCD)) {
            CCCD.setError("B???n ch??a nh???p CCCD!");
            c++;
        }
        if (isEmpty(SDT)) {
            SDT.setError("B???n ch??a nh???p SDT!");
            c++;
        }
        if (!isEmail(Email)) {
            Email.setError("B???n ch??a nh???p Email ho???c Email kh??ng h???p l???");
            c++;
        }

        if (c == 0){
            Toast t = Toast.makeText(this, "Nh???p d??? li???u th??nh c??ng! C???m ??n", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        else {
            Toast t = Toast.makeText(this, "Nh???p d??? li???u KH??NG th??nh c??ng!", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
    }

}