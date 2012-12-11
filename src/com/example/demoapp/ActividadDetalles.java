package com.example.demoapp;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActividadDetalles extends Activity {
	 int codigo_pasar;
	 private Button btnCambiar;
	 private Button btnVermapa;
	 private Button btnActualizar;
	 private final String MY_DATABASE_NAME = "DBUsuarios"; 
	 private String name;
	 private String address;
	 private String mail; 
	 
	 OnClickListener mCorkyListener = new OnClickListener() {    
	 public void onClick(View v) {          		
	    		Intent intent = new Intent(ActividadDetalles.this,ActividadEditar.class);	    		
	    		intent.putExtra("codigo", codigo_pasar);
	    		startActivity(intent);		        
	    	}
	 };
	 
	 OnClickListener mCorkyListenermapa = new OnClickListener() {    
		 public void onClick(View v) {          		
		    		Intent intent = new Intent(ActividadDetalles.this,ActividadMapa.class);
		    		startActivity(intent);		        
		    	}
     };
     
     OnClickListener mCorkyListeneractualizar = new OnClickListener() {    
		 public void onClick(View v) {          		
			      finish();
			      startActivity(getIntent());        
		 }
     };
     
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles);        
        Bundle datos = this.getIntent().getExtras();
        String value_codigo = datos.getString("valueid");
        String[] tokens = value_codigo.split(":");
        codigo_pasar = Integer.parseInt(tokens[0]);
        
        
        SQLiteDatabase myDB = this.openOrCreateDatabase(MY_DATABASE_NAME, SQLiteDatabase.OPEN_READWRITE, null);
        try {                           
             Cursor c = myDB.query(UsuariosSQLiteHelper.MY_DATABASE_TABLE, null, "codigo ="+tokens[0], null, null, null, null);                        
           if (c != null) {          
               c.moveToFirst(); 
               int nombre = c.getColumnIndex("nombre"); 
               int direccion = c.getColumnIndex("direccion"); 
               int email = c.getColumnIndex("email"); 
                if (c.isFirst()) {                                       
                     do {                      
                          name = c.getString(nombre);                            
                          address = c.getString(direccion); 
                          mail = c.getString(email); 
                     } while (c.moveToNext()); 
                } 
           }
               
       } catch (SQLiteException e) { 
       } finally { 
            if (myDB != null) 
                 myDB.close(); 
       }
                
                 
        TextView textnombre= (TextView) findViewById(R.id.nombreuser);
        textnombre.setText(name);
        TextView textdireccion= (TextView) findViewById(R.id.direccionuser);
        textdireccion.setText(address);
        TextView textemail= (TextView) findViewById(R.id.emailuser);
        textemail.setText(mail);
        
        btnCambiar = (Button) findViewById(R.id.editardatos);  
        btnCambiar.setOnClickListener(mCorkyListener);
        
        btnVermapa = (Button) findViewById(R.id.vermapa);  
        btnVermapa.setOnClickListener(mCorkyListenermapa);
        
        btnActualizar = (Button) findViewById(R.id.actualizardatos);  
        btnActualizar.setOnClickListener(mCorkyListeneractualizar);
        

    }
	
}
