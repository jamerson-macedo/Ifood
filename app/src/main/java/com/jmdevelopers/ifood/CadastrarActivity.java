package com.jmdevelopers.ifood;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.jmdevelopers.ifood.model.User;

public class CadastrarActivity extends AppCompatActivity {
    EditText regnome, regsenha, regfone;
    Button cadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        regfone = findViewById(R.id.regfone);
        regsenha = findViewById(R.id.regsenha);
        regnome = findViewById(R.id.regnome);
        cadastrar = findViewById(R.id.regcadastrar);
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference table_name = firebaseDatabase.getReference().child("Users");
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = new ProgressDialog( CadastrarActivity.this);
                dialog.setMessage("Aguarde");
                dialog.show();
                table_name.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(regfone.getText().toString()).exists()) {
                            dialog.dismiss();
                            Toast.makeText(CadastrarActivity.this, "Ja existe", Toast.LENGTH_LONG).show();


                        }else {
                            dialog.dismiss();
                            User user=new User(regnome.getText().toString(),regsenha.getText().toString());
                            table_name.child(regfone.getText().toString()).setValue(user);
                            Toast.makeText(CadastrarActivity.this, "Sucesso", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(CadastrarActivity.this,HomeActivity.class));

                            finish();



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
