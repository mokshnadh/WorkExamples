package androidproject.nicedays;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;
    private ImageView imageView;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imageView = (ImageView)findViewById(R.id.imageButton3);
        editTextEmail = (EditText) findViewById(R.id.editText3);
        editTextPassword = (EditText)findViewById(R.id.editText2);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);
        textViewSignUp = (TextView)findViewById(R.id.textViewSignUp);


        buttonSignIn.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
        }
    }

    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String Password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            //stopping the function executing on further
            return;
        }
        if (TextUtils.isEmpty(Password)) {
            //password is empty
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            //stopping the function executing on further
            return;
        }
        //if validations are ok
        //we will first show a progressbar

        progressDialog.setMessage("Signing In PleaseWait....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            //start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {

        if (view == buttonSignIn){
            userLogin();
        }
        if (view == textViewSignUp){
            finish();
            startActivity(new Intent(this, MainActivity.class));

        }

    }
}
