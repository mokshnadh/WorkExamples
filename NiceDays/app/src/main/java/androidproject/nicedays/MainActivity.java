/**
 *
 */
package androidproject.nicedays;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button2;
    private EditText editText3;
    private EditText editText2;
    private TextView textViewSignIn;
    private ImageView imageView;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
        }

        progressDialog = new  ProgressDialog(this);

        imageView = (ImageView)findViewById(R.id.imageButton);
        button2 = (Button) findViewById(R.id.buttonSignIn);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText2 = (EditText) findViewById(R.id.editText2);
        textViewSignIn = (TextView) findViewById(R.id.textView);


        button2.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);


    }

    private void registerUser() {
        String email = editText3.getText().toString().trim();
        String PassWord = editText2.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            //stopping the function executing on further
            return;
        }
        if (TextUtils.isEmpty(PassWord)) {
            //password is empty
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            //stopping the function executing on further
            return;
        }
        progressDialog.setMessage("Registering User....");
        progressDialog.show();
        //if validations are ok
        //we will first show a progressbar
        firebaseAuth.createUserWithEmailAndPassword(email,PassWord)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        } else {
                            Toast.makeText(MainActivity.this,"Fail To Register,Please Try Again",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }



    @Override
    public void onClick(View view) {
        if (view == button2) {
            registerUser();
        }

        if (view == textViewSignIn) {
            //will open login activity here
            startActivity(new Intent(this, LoginActivity.class));

        }


    }
}

