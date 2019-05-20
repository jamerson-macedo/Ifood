package com.jmdevelopers.ifood;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EntrarActivity extends AppCompatActivity {
    EditText camposenha, campophone;
    Button entrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        campophone = findViewById(R.id.regfone);
        camposenha = findViewById(R.id.regsenha);
        entrar = findViewById(R.id.botaoentrar);
        // firebase
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference table_name = firebaseDatabase.getReference().child("Users");
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = new ProgressDialog(EntrarActivity.this);
                dialog.setMessage("Aguarde");
                dialog.show();
                table_name.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(campophone.getText().toString()).exists()) {
                            dialog.dismiss();
                            User user = dataSnapshot.child(campophone.getText().toString()).getValue(User.class);
                            if (user.getSenha().equals(camposenha.getText().toString())) {

                                Toast.makeText(EntrarActivity.this, "usuario logado", Toast.LENGTH_LONG).show();


                            } else {
                                Toast.makeText(EntrarActivity.this, "falha ao logar", Toast.LENGTH_LONG).show();


                            }
                        }
                        else{

                            Toast.makeText(EntrarActivity.this, "falha ao logar", Toast.LENGTH_LONG).show();


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}
