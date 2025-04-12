package com.example.th;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private StringBuilder currentInput = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txtResult);

        // Khởi tạo các nút số và toán tử
        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide,
                R.id.btnDot, R.id.btnPercent
        };

        for (int id : buttonIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(v -> {
                String text = ((Button) v).getText().toString();
                if (text.equals("X")) text = "*"; // thay thế "X" bằng "*"
                if (text.equals("%")) text = "/100"; // chuyển % thành chia 100
                currentInput.append(text);
                txtResult.setText(currentInput.toString());
            });
        }

        // Xử lý nút DEL
        findViewById(R.id.btnDel).setOnClickListener(v -> {
            currentInput.setLength(0);  // Xóa hết nội dung
            txtResult.setText("");
        });

        // Xử lý nút =
        findViewById(R.id.btnEqual).setOnClickListener(v -> {
            String expression = currentInput.toString();
            try {
                double result = evaluateExpression(expression);

                String formattedResult = String.format("%.3f", result);
                txtResult.setText(formattedResult);
                currentInput = new StringBuilder(String.valueOf(result)); // cho phép tiếp tục tính toán
            } catch (Exception e) {
                txtResult.setText("Error");
                currentInput = new StringBuilder();
            }
        });
    }

    // Hàm xử lý tính toán biểu thức
    private double evaluateExpression(String expression) {
        // Loại bỏ khoảng trắng thừa
        expression = expression.replaceAll("\\s", "");

        // Kiểm tra nếu biểu thức rỗng
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Empty expression");
        }

        // Chuyển các toán tử cơ bản và % thành toán tử đúng
        expression = expression.replace("%", "/100");

        // Thực hiện tính toán trực tiếp
        try {
            return evalBasic(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    // Hàm thực hiện tính toán cơ bản
    private double evalBasic(String expression) {
        double result = 0;
        char operator = '+';
        double number = 0;
        int length = expression.length();

        for (int i = 0; i < length; i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder num = new StringBuilder();
                while (i < length && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i));
                    i++;
                }
                number = Double.parseDouble(num.toString());
                i--; // chỉnh lại chỉ số
            }

            if (i == length - 1 || "+-*/".indexOf(ch) >= 0) {
                switch (operator) {
                    case '+':
                        result += number;
                        break;
                    case '-':
                        result -= number;
                        break;
                    case '*':
                        result *= number;
                        break;
                    case '/':
                        if (number == 0) {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        result /= number;
                        break;
                }
                operator = ch;
                number = 0;
            }
        }

        return result;
    }
}
