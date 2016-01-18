package com.example.sebas.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class addChild extends AppCompatActivity {
    ListView lstKids;
    int indKid=0;
    ArrayList<Child> MyKids = new ArrayList<Child>();
    kidDatabaseHelper kidDatabase=new kidDatabaseHelper(this);
    private Firebase mRef;
    private String nameP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
        //FIREBASE
        Firebase.setAndroidContext(this);
        //mi base de datos en FIREBASE
        mRef=new Firebase("https://clasefirebase.firebaseio.com/");
        nameP=getIntent().getStringExtra("nombre");
        lstKids = (ListView) findViewById(R.id.Lst);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/TimKid.ttf");

        Button New = (Button) findViewById(R.id.newButton);
        TextView tvtitle = (TextView) findViewById(R.id.idTitle);
        tvtitle.setTypeface(myCustomFont);
        New.setTypeface(myCustomFont);

        New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(addChild.this, KidRegister.class);
                startActivityForResult(i, 1);
            }
        });

        if(kidDatabase.getContactsCount()!=0)
            MyKids.addAll(kidDatabase.getAllChilds());
        populateList();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                int age=getAge(data.getIntExtra("year", 1), data.getIntExtra("month", 1), data.getIntExtra("day", 1));
                if(data.getStringExtra("sex").equals("Boy")) {
                    Child newKid = new Child(R.drawable.cara_nino, data.getStringExtra("language"), data.getStringExtra("nombre"), 0, data.getIntExtra("hour",1),data.getIntExtra("min",1));
                    newKid.setSexo("Boy");
                    newKid.setedad(age);
                    MyKids.add(newKid);
                    kidDatabase.insertChild(newKid);
                    //GUARDA EN FIREBASE
                    Firebase bd = mRef.child(nameP).child(newKid.getName());
                    bd.setValue(newKid);

                    Toast.makeText(getApplicationContext(), data.getStringExtra("nombre") +
                            " has been added to your Childs!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Child newKid = new Child(R.drawable.cara_nina, data.getStringExtra("language"), data.getStringExtra("nombre"), 0, data.getIntExtra("hour",1),data.getIntExtra("min",1));
                    newKid.setSexo("Girl");
                    newKid.setedad(age);
                    MyKids.add(newKid);
                    kidDatabase.insertChild(newKid);
                    //GUARDA EN FIREBASE
                    Firebase bd = mRef.child(nameP).child(newKid.getName());
                    bd.setValue(newKid);
                    //mensaje para el usuario
                    Toast.makeText(getApplicationContext(), data.getStringExtra("nombre") +
                            " has been added to your Childs!", Toast.LENGTH_SHORT).show();

                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
            populateList();
        }
    }//onActivityResult

    private void populateList() {
        ArrayAdapter<Child> adapter = new ChildAdapter();
        lstKids.setAdapter(adapter);
    }

    private class ChildAdapter extends ArrayAdapter<Child> {
        public ChildAdapter() {

            super (getApplicationContext(), R.layout.layout_childs, MyKids);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.layout_childs, parent, false);

            Child currentChild = MyKids.get(position);

            TextView nombre = (TextView) view.findViewById(R.id.nameKid);
            nombre.setText(currentChild.getName());
            TextView level = (TextView) view.findViewById(R.id.levelKid);
            level.setText("Months: "+Integer.toString(currentChild.getedad()));
            TextView lengua = (TextView) view.findViewById(R.id.languageKid);
            lengua.setText(currentChild.getLenguaje());
            ImageView image = (ImageView) view.findViewById(R.id.imagen);
            image.setImageResource(currentChild.getImagen());

            return view;
        }
    }
    public int getAge (int año, int mes, int dia) {

        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d, a,dif;

        y = cal.get(Calendar.YEAR);
        m = cal.get(Calendar.MONTH);
        d = cal.get(Calendar.DAY_OF_MONTH);

        a =( y - año)*12;
        dif=m-mes;

        if (m>mes){
            if(d==dia || d>dia){
                a=a+dif;
            }
        }
        else if(m<mes){
            a=a+dif;
        }
        else if(m==mes){
            if(d<dia){
                a=a-1;
            }
        }
        return a;
    }

}
