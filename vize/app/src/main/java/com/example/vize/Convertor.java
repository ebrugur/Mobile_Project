package com.example.vize;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Convertor extends AppCompatActivity {
    // Decimal
    EditText edtDecimalInput;
    Button btnDecimal;
    TextView tvBinary, tvOctal, tvHexadecimal;

    // Megabyte
    EditText edtMegabyteInput;
    Button btnMegabyte;
    TextView tvKilobyte, tvByte, tvKibibyte, tvBit;

    // Celsius
    EditText edtCelsiusInput;
    Button btnCelsius;
    TextView tvFahrenheit, tvKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        //Decimal
        edtDecimalInput = findViewById(R.id.edt_decimal_input);
        btnDecimal = findViewById(R.id.btn_decimal);
        tvBinary = findViewById(R.id.tv_binary);
        tvOctal = findViewById(R.id.tv_octal);
        tvHexadecimal = findViewById(R.id.tv_hexadecimal);

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertDecimal();
            }
        });

        //Megabyte
        edtMegabyteInput = findViewById(R.id.edt_megabyte_input);
        btnMegabyte = findViewById(R.id.btn_megabyte);
        tvKilobyte = findViewById(R.id.tv_kilobyte);
        tvByte = findViewById(R.id.tv_byte);
        tvKibibyte = findViewById(R.id.tv_kibibyte);
        tvBit = findViewById(R.id.tv_bit);

        btnMegabyte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertMegabyte();
            }
        });

        //Celsius
        edtCelsiusInput = findViewById(R.id.edt_celsius_input);
        btnCelsius = findViewById(R.id.btn_celsius);
        tvFahrenheit = findViewById(R.id.tv_fahrenheit);
        tvKelvin = findViewById(R.id.tv_kelvin);

        btnCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCelsius();
            }
        });
    }

    private void convertDecimal() {
        String dec = edtDecimalInput.getText().toString();

        if (!dec.isEmpty()) {
            try {
                int decimal = Integer.parseInt(dec);

                //Decimal-binary, octal, hexadecimal
                String binary = Integer.toBinaryString(decimal);
                String octal = Integer.toOctalString(decimal);
                String hexadecimal = Integer.toHexString(decimal);

                tvBinary.setText("Binary: " + binary);
                tvOctal.setText("Octal: " + octal);
                tvHexadecimal.setText("Hexadecimal: " + hexadecimal);
            } catch (NumberFormatException e) {
                clearResults();
                showToast("Decimal dönüşümü için geçersiz giriş");
            }
        } else {
            clearResults();
            showToast("Lütfen Decimal değeri girin");
        }
    }
    private void convertMegabyte() {
        String megaByteText = edtMegabyteInput.getText().toString();

        if (!megaByteText.isEmpty()) {
            try {
                double megabyte = Double.parseDouble(megaByteText);

                // Megabyte'ı kilobyte, byte, kibibyte ve bit
                double kilobyte = megabyte * 1024;
                double byteValue = kilobyte * 1024;
                double kibibyte = byteValue * 8;
                double bit = kibibyte * 1024;

                tvKilobyte.setText("Kilobyte: " + kilobyte);
                tvByte.setText("Byte: " + byteValue);
                tvKibibyte.setText("Kibibyte: " + kibibyte);
                tvBit.setText("Bit: " + bit);
            } catch (NumberFormatException e) {
                clearResults();
                showToast("Megabyte dönüşümü için geçersiz giriş");
            }
        } else {
            clearResults();
            showToast("Lütfen Megabyte değeri girin");
        }
    }

    private void convertCelsius() {
        String celsiusText = edtCelsiusInput.getText().toString();

        if (!celsiusText.isEmpty()) {
            try {
                double celsius = Double.parseDouble(celsiusText);

                // Celsius sıcaklığı Fahrenheit ve Kelvin
                double fahrenheit = (celsius * 9 / 5) + 32;
                double kelvin = celsius + 273.15;

                tvFahrenheit.setText("Fahrenheit: " + fahrenheit);
                tvKelvin.setText("Kelvin: " + kelvin);
            } catch (NumberFormatException e) {
                clearResults();
                showToast("Celsius dönüşümü için geçersiz giriş");
            }
        } else {
            clearResults();
            showToast("Lütfen Celsius sıcaklığı girin");
        }
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void clearResults() {
        tvBinary.setText("");
        tvOctal.setText("");
        tvHexadecimal.setText("");
        tvKilobyte.setText("");
        tvByte.setText("");
        tvKibibyte.setText("");
        tvBit.setText("");
        tvFahrenheit.setText("");
        tvKelvin.setText("");
    }
}

