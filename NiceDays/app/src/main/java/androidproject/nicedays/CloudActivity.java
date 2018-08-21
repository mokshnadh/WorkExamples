package androidproject.nicedays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CloudActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;

    private Button button5,button6,button13,button14;
    private TextView textView7,textView8;
    private EditText editText5,editText6,editText7,editText8,editText11,editText10;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        firebaseAuth = FirebaseAuth.getInstance();

        imageView = (ImageView)findViewById(R.id.imageButton6);
        editText11 = (EditText)findViewById(R.id.editText11);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);
        editText8 = (EditText)findViewById(R.id.editText8);
        editText10 = (EditText)findViewById(R.id.editText10);

        textView7 = (TextView)findViewById(R.id.textView7);
        textView8 = (TextView)findViewById(R.id.textView8);

        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button13 = (Button)findViewById(R.id.button13);
        button14 = (Button)findViewById(R.id.button14);

        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
    }

    private void CloudData(){

        String Name = editText5.getText().toString().trim();
        String PhoneNumber = editText6.getText().toString().trim();
        String Email = editText7.getText().toString().trim();
        String PNTWO = editText11.getText().toString().trim();
        String TwoE = editText10.getText().toString().trim();
        String feedback = editText8.getText().toString().trim();

        CloudData cloudData = new CloudData(Name,PhoneNumber,Email,PNTWO,TwoE,feedback);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(cloudData);

        Toast.makeText(this,"Information Saved...",Toast.LENGTH_LONG).show();


    }

    @Override
    public void onClick(View view) {

        if (view == button5){
            startActivity(new Intent(this, QuotesActivity.class));
        }
        if (view == button6){
            startActivity(new Intent(this, FavouriteActivity.class));
        }
        if (view == button13){
            Toast.makeText(this,"Information Sended...",Toast.LENGTH_LONG).show();
        }
        if (view == button14){
            CloudData();
        }

    }
}
