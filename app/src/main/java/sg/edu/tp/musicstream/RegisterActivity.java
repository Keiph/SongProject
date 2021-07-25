package sg.edu.tp.musicstream;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText userName,email,password,confirmPassword;
    TextView toLoginPage;
    Button registerBtn;
    FirebaseAuth mAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setting resources
        setContentView(R.layout.activity_register_page);
        userName = findViewById(R.id.userName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);
        toLoginPage=findViewById(R.id.toLoginPage);
        registerBtn=findViewById(R.id.registerBtn);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = userName.getText().toString().trim();
                String inputEmail = email.getText().toString().trim();
                String inputPassword = password.getText().toString().trim();
                String inputConfirmPassword = confirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(inputUsername)){
                    userName.setError("Please make an Username");
                    return;
                }

                if (TextUtils.isEmpty(inputEmail)){
                    email.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(inputPassword)){
                    password.setError("Password is Required");
                    return;
                }
                if (TextUtils.isEmpty(inputConfirmPassword)){
                    confirmPassword.setError("Please Confirm Password");
                }

                if (inputPassword.length() < 6){
                    password.setError("Password must have more than 6 characters long");
                    return;
                }
                if (!inputConfirmPassword.equals(inputPassword)){ //password is a string data type != does not work for string. Take Note
                    confirmPassword.setError("Make sure your password is match");
                    return;
                }
                // line 56-82 we can either do nested if (cuz got multiple criteria) or we can do if and do a return to make sure required fills are dealt with
                // another way is if...else if and from progress bar else (cuz all criteria are met then goes to else)

                progressBar.setVisibility(View.VISIBLE);

                //user registering into firebase
                mAuth.createUserWithEmailAndPassword(inputEmail,inputPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(RegisterActivity.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

}
