package zero.ruts.ac.th.testproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public FirebaseDatabase fireebaseDatabase;
    public DatabaseReference LED1,LED2,LED3,LED4;
    //public static final String TAG ="LEDs control";
    public Button Switch,Switch2,Switch3,Switch4;
    public Integer Value1,Value0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //เรียก database Referrences ให้ตรงกับที่อยู่บน firebase
        fireebaseDatabase = FirebaseDatabase.getInstance();
        LED1 = fireebaseDatabase.getReference("Control/Switch/LED1");
        LED2 = fireebaseDatabase.getReference("Control/Switch/LED2");
        LED3 = fireebaseDatabase.getReference("Control/Switch/LED3");
        LED4 = fireebaseDatabase.getReference("Control/Switch/LED4");
        //LED = firebaseDatabase.getReference("Dev/switch");

        Switch = (Button) findViewById(R.id.Led1);
        LED1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               Value1 = dataSnapshot.getValue(Integer.class);
               //Log.d(TAG,"Value is"+Value1);
               if (Value1==0){
                   Switch.setText("LED1_ON");
                   Value0=0;
               }
               else {
                   Switch.setText("LED1_OFF");
                   Value0=1;
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            //Log.w(TAG,"Failed", databaseError.toException());
            }
        });
        Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED1.setValue(Value0);

            }
    });
        Switch2 = (Button) findViewById(R.id.Led2);
        LED2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+Value1);
                if (Value1==1){
                    Switch2.setText("LED2_ON");
                    Value0=0;
                }
                else {
                    Switch2.setText("LED2_OFF");
                    Value0=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed", databaseError.toException());
            }
        });
        Switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED2.setValue(Value0);

            }
        });

        Switch3 = (Button) findViewById(R.id.Led3);
        LED3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+Value1);
                if (Value1==1){
                    Switch3.setText("LED3_ON");
                    Value0=0;
                }
                else {
                    Switch3.setText("LED3_OFF");
                    Value0=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed", databaseError.toException());
            }
        });
        Switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED3.setValue(Value0);

            }
        });

        Switch4 = (Button) findViewById(R.id.Led4);
        LED4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+Value1);
                if (Value1==1){
                    Switch4.setText("LED4_ON");
                    Value0=0;
                }
                else {
                    Switch4.setText("LED4_OFF");
                    Value0=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed", databaseError.toException());
            }
        });
        Switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED4.setValue(Value0);

            }
        });
    }
}
