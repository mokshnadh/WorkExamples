package androidproject.nicedays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;

    private TextView textViewUserEmail;
    private Button NextButton;
    private Button SaveButton,button15;
    private EditText editTextName,editTextAge, editTextSex,editTextEmail, editTextPhoneNumber;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        firebaseAuth = FirebaseAuth.getInstance();

        imageView = (ImageView)findViewById(R.id.imageButton2);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextSex = (EditText) findViewById(R.id.editTextSex);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        SaveButton = (Button) findViewById(R.id.SaveButton);
        NextButton = (Button)findViewById(R.id.NextButton);
        button15 = (Button)findViewById(R.id.button15);

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, NotificationActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView)findViewById(R.id.textView4);

        textViewUserEmail.setText("Welcome"+user.getEmail());

        SaveButton.setOnClickListener(this);
        NextButton.setOnClickListener(this);
        button15.setOnClickListener(this);
    }

    private void saveUserInformation(){

        String Name = editTextName.getText().toString().trim();
        String Age = editTextAge.getText().toString().trim();
        String Sex = editTextSex.getText().toString().trim();
        String Email = editTextEmail.getText().toString().trim();
        String PhoneNumber = editTextPhoneNumber.getText().toString().trim();

        UserInformation userInformation = new UserInformation(Name,Age,Sex,PhoneNumber,Email);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this,"Information Saved...",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        if (view == NextButton ){
            finish();
            startActivity(new Intent(this, NotificationActivity.class));
        }
        if (view == SaveButton){
            saveUserInformation();
        }
        if (view == button15){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
