package com.example.demoapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class ActividadEditar extends Activity {
	int codigo_update;
	private Button btnGuardar;
	private final String MY_DATABASE_NAME = "DBUsuarios"; 
	private String name;
	private String address;
	private String mail; 
    
	OnClickListener mCorkyListener = new OnClickListener() {    
		 public void onClick(View v) {          		
		    		
			        final EditText txtname = (EditText)findViewById(R.id.nombreeditar); 
			        String textoname = txtname.getText().toString();
			        final EditText txtaddress = (EditText)findViewById(R.id.direccioneditar);        
			        String textoaddress = txtaddress.getText().toString();
			        final EditText txtmail = (EditText)findViewById(R.id.emaileditar);        
			        String textoemail = txtmail.getText().toString();
			        
			        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(ActividadEditar.this, "DBUsuarios", null, 1);
			        SQLiteDatabase db = usdbh.getWritableDatabase();       
			        if(db != null) 
			        {           			                
			        	ContentValues valores = new ContentValues();
			        	valores.put("nombre",textoname);	
			        	valores.put("direccion",textoaddress);
			        	valores.put("email",textoemail);
			        	db.update("Usuarios", valores, "codigo="+codigo_update, null);			                           
			            db.close();
			            
			            Toast toast1 = Toast.makeText(getApplicationContext(), "Guardado Correctamente", Toast.LENGTH_SHORT);			 
			            toast1.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);			
			            toast1.show();
				        
				       // finish();
				        Intent intent = new Intent(ActividadEditar.this,ActividadDetalles.class);
				        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); 		        
				        startActivity(intent);
				        
			        }
			        else
			        {
			        	Toast toast1 = Toast.makeText(getApplicationContext(), "Fallo", Toast.LENGTH_SHORT);			 
					    toast1.show();
			        }
			        
			        
			            
			       
		    	}
		 };
		 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_user);
        
        Bundle datos = this.getIntent().getExtras();
        int codigo = datos.getInt("codigo");
        codigo_update=codigo;
        
        SQLiteDatabase myDB = this.openOrCreateDatabase(MY_DATABASE_NAME, SQLiteDatabase.OPEN_READWRITE, null);
        try {                           
             Cursor c = myDB.query(UsuariosSQLiteHelper.MY_DATABASE_TABLE, null, "codigo ="+codigo, null, null, null, null);                        
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
        
        final EditText txtname = (EditText)findViewById(R.id.nombreeditar);        
        txtname.setText(name); 
        final EditText txtaddress = (EditText)findViewById(R.id.direccioneditar);        
        txtaddress.setText(address);
        final EditText txtmail = (EditText)findViewById(R.id.emaileditar);        
        txtmail.setText(mail);
        //String texto = txtTexto.getText().toString(); 
        //String aux2 = Html.toHtml(txtTexto.getText());
        
        btnGuardar = (Button) findViewById(R.id.guardaruser);  
        btnGuardar.setOnClickListener(mCorkyListener);
    }
 
}
