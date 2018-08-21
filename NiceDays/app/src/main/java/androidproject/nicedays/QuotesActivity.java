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

public class QuotesActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;

    private Button button2,button3,button4;
    private EditText editQuoteText;
    CheckBox checkBox,checkBox1,checkBox3,checkBox4;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        firebaseAuth = FirebaseAuth.getInstance();

        imageView = (ImageView)findViewById(R.id.imageButton4);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        editQuoteText = (EditText) findViewById(R.id.editQuoteText);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox1 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox)findViewById(R.id.checkBox4);

        editQuoteText.setOnClickListener(this);
        button3.setOnClickListener(this);
        button2.setOnClickListener(this);
        button4.setOnClickListener(this);

    }
    public void Quote(){

        String editQuote = editQuoteText.getText().toString().trim();

        Quote quote = new Quote(editQuote);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(quote);

        Toast.makeText(this,"Quote Saved",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        if (view == checkBox ){
            Toast.makeText(this,"QuoteOne is Selected",Toast.LENGTH_LONG).show();
        }
        if (view == checkBox1){
            Toast.makeText(this,"QuoteTwo is Selected",Toast.LENGTH_LONG).show();
        }
        if (view == button3 ){
            finish();
            startActivity(new Intent(this, CloudActivity.class));
        }
        if (view == button4 ){
            finish();
            startActivity(new Intent(this, NotificationActivity.class));
        }
        if (view == button2 ){
            Quote();
            finish();
            checkBox3.setVisibility(View.VISIBLE);
            finish();

        }

    }

}

