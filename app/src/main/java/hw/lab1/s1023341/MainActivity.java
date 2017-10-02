package hw.lab1.s1023341;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    int finish = 0;
    public void b_o_c_0(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "0");
    }
    public void b_o_c_1(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "1");
    }
    public void b_o_c_2(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "2");
    }
    public void b_o_c_3(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "3");
    }
    public void b_o_c_4(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "4");
    }
    public void b_o_c_5(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "5");
    }
    public void b_o_c_6(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "6");
    }
    public void b_o_c_7(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "7");
    }
    public void b_o_c_8(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "8");
    }
    public void b_o_c_9(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + "9");
    }
    public void b_o_c_dot(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        if(finish == 1) {
            v1.setText("");
            finish--;
        }
        v1.setText(v1.getText() + ".");
    }
    public void b_o_c_space(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        boolean last = v1.getText().toString().endsWith(" ");
        if( last ) {
        }
        else {
            v1.setText(v1.getText() + " ");
        }
    }
    public void b_o_c_add(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        boolean last = v1.getText().toString().endsWith(" ");
        if( last ) {
            v1.setText(v1.getText() + "+ ");
        }
        else{
        }
    }
    public void b_o_c_sub(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        boolean last = v1.getText().toString().endsWith(" ");
        if( last ) {
            v1.setText(v1.getText() + "- ");
        }
        else {
        }
    }
    public void b_o_c_mul(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        boolean last = v1.getText().toString().endsWith(" ");
        if( last ) {
            v1.setText(v1.getText() + "* ");
        }
        else {
        }
    }
    public void b_o_c_div(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        boolean last = v1.getText().toString().endsWith(" ");
        if( last ) {
            v1.setText(v1.getText() + "/ ");
        }
        else{
        }
    }
    public void b_o_c_clean(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        v1.setText("");
    }
    public void b_o_c_equal(View v){
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        v1.setMovementMethod(ScrollingMovementMethod.getInstance());
        String[] afterSplit = v1.getText().toString().split(" ");

        //element
        Stack<String> buffer = new Stack<>();
        int top = 0;
        Boolean jump = false;
        Boolean detect_divide = false;
        Boolean detect = false;

        //detection for dot
        for(int k = 0 ; k < afterSplit.length ; k++){
            int check_1 = afterSplit[k].indexOf(".");
            int check_2 = afterSplit[k].lastIndexOf(".");
            if( check_1 != check_2 ){
                Toast.makeText( getApplicationContext() , "Input Error", Toast.LENGTH_SHORT).show();
                v1.setText("");
                jump = true;
            }
        }

        //error detection
        if(jump){}
        else if (afterSplit.length == 0 ){}
        else {
            //operand
            String opLeft, opRight;
            BigDecimal left, right;

            for (int i = 0; i < afterSplit.length; i++) {
                switch (afterSplit[i]) {
                    case "+":
                        if( top <= 1 ){
                            Toast.makeText( getApplicationContext() , "Input Error", Toast.LENGTH_SHORT).show();
                            v1.setText("");
                            detect = true;
                            break;
                        }
                        opRight = buffer.pop();
                        opLeft = buffer.pop();
                        top -= 2;
                        left = new BigDecimal(opLeft);
                        right = new BigDecimal(opRight);
                        buffer.push(left.add(right).toString());
                        top++;
                        break;
                    case "-":
                        if( top <= 1 ){
                            Toast.makeText( getApplicationContext() , "Input Error", Toast.LENGTH_SHORT).show();
                            v1.setText("");
                            detect = true;
                            break;
                        }
                        opRight = buffer.pop();
                        opLeft = buffer.pop();
                        top -= 2;
                        left = new BigDecimal(opLeft);
                        right = new BigDecimal(opRight);
                        buffer.push(left.subtract(right).toString());
                        top++;
                        break;
                    case "*":
                        if( top <= 1 ){
                            Toast.makeText( getApplicationContext() , "Input Error", Toast.LENGTH_SHORT).show();
                            v1.setText("");
                            detect = true;
                            break;
                        }
                        opRight = buffer.pop();
                        opLeft = buffer.pop();
                        top -= 2;
                        left = new BigDecimal(opLeft);
                        right = new BigDecimal(opRight);
                        buffer.push(left.multiply(right).toString());
                        top++;
                        break;
                    case "/":
                        if( top <= 1 ){
                            Toast.makeText( getApplicationContext() , "Input Error", Toast.LENGTH_SHORT).show();
                            v1.setText("");
                            detect = true;
                            break;
                        }
                        opRight = buffer.pop();
                        top--;
                        //check division by zero
                        if( Integer.valueOf(opRight) == 0 ){
                            detect_divide = true;
                            Toast.makeText( getApplicationContext() , "Input Error", Toast.LENGTH_SHORT).show();
                            v1.setText("");
                            break;
                        }
                        opLeft = buffer.pop();
                        top--;
                        left = new BigDecimal(opLeft);
                        right = new BigDecimal(opRight);
                        //10^(-10)
                        buffer.push(left.divide(right, 10, BigDecimal.ROUND_HALF_DOWN).toString());
                        top++;
                        break;
                    default:
                        buffer.push(afterSplit[i]);
                        top++;
                        break;
                }
                if( detect_divide || detect )
                    break;
            }
            if( !detect_divide && !detect ) {
                String ans = buffer.pop();
                top--;
                if( top == 0 )
                    v1.setText(ans);
                else{}
                finish++;
            }
        }
    }
    public void nFactorial(View v) {
        TextView v1 = (TextView)findViewById(R.id.tv_output);
        v1.setMovementMethod(ScrollingMovementMethod.getInstance());
        String[] afterSplit = v1.getText().toString().split(" ");

        if( afterSplit.length > 1 ){
            Toast.makeText( getApplicationContext() , "Input Error", Toast.LENGTH_SHORT).show();
            v1.setText("");
        }

        else if( afterSplit.length == 1 ) {
            boolean check = v1.getText().toString().contains(".");
            if (v1.getText().toString() == "+" || v1.getText().toString() == "-" || v1.getText().toString() == "*" || v1.getText().toString() == "/") {
                Toast.makeText(getApplicationContext(), "Input Error", Toast.LENGTH_SHORT).show();
                v1.setText("");
            }
            else if (check){
                Toast.makeText(getApplicationContext(), "Input Error", Toast.LENGTH_SHORT).show();
                v1.setText("");
            }
            else if( v1.getText().toString() == "" ){
            }
            else {
                BigDecimal sum = BigDecimal.valueOf(1);
                int n = Integer.valueOf(afterSplit[0]);
                for (int i = 1; i <= n; i++) {
                    sum = sum.multiply(BigDecimal.valueOf(i));
                }
                v1.setText(sum.toString());
                finish++;
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
