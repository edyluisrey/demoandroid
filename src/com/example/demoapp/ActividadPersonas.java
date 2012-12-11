package com.example.demoapp;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;


public class ActividadPersonas extends  ListActivity {
	
	private final String MY_DATABASE_NAME = "DBUsuarios";  
	static final String[] AFILIADOS = new String[] {    
		"1: Edy aguirre Quispe", "2: Juan manuel Vargas", 
		"3: Favio condori Ramos", "4: Carlos mamani",
		"5: Martin guitirrez", "6: David perez de cuellar", 
		"7: Maria guitierres", "8: Alberto Roca Cunn",
		"9: Luis Ramos Ticnona", "10: Claudio pizarro", 
		"11: Mario Vargas LLosa", "12: Carmen Llanos",
		"13: Paul tahobara s", "14: Julio rojas", 
		"15: Andrea Miranda","16: Juan Carlos mamani",
		"17: Maria guitierres", "18: Alberto Roca Cunn",
		"19: Luis Ramos Ticnona", "20: Claudio pizarro", 
		"21: Mario Vargas LLosa", "22: Carmen Llanos",
		"23: Paul tahobara s", "24: Julio rojas", 
		"25: Andrea Miranda","26: Juan Carlos mamani",
		"27: Maria guitierres", "28: Alberto Roca Cunn",
		"29: Luis Ramos Ticnona", "30: Claudio pizarro", 
		"31: Mario Vargas LLosa", "32: Carmen Llanos",
		"33: Paul tahobara s", "34: Julio rojas", 
		"35: Andrea Miranda","36: Juan Carlos mamani",
		"37: Maria guitierres", "38: Alberto Roca Cunn",
		"39: Luis Ramos Ticnona", "40: Claudio pizarro", 
		"41: Mario Vargas LLosa", "42: Carmen Llanos",
		"43: Paul tahobara s", "44: Julio rojas", 
		"45: Andrea Miranda","46: Juan Carlos mamani"};
	
	static final String[] DESAFILIADOS = new String[] {    
		"1: Miguel Chavez Ramos", "2: Santiago Acasiete R.", 
		"3: Frank Vargas M.", "4: Jose Canales tahoba",
		"5: Andres Estevan Ovalle", "6: Francisca Diaz M.", 
		"7: Lucia Cutipa Ramos", "8: Alberto Condori",
		"9: Meliza ollanta", "10: Alan Garcia perez", 
		"11: Johana Niro Quizada", "12: Liliana Mengolea",
		"13: Paul tabarez", "14: Paulo alvarazin Rojas"  };
	
	OnItemClickListener mCorkyListener = new OnItemClickListener() 
	{    
		public void onItemClick(AdapterView<?> parent, View view,        
				int position, long id) {     
			
			String valueid =(String) parent.getItemAtPosition(position);
			/*Toast toast1 = Toast.makeText(getApplicationContext(), valueid, Toast.LENGTH_SHORT);			 
		    toast1.show();*/		       
			Intent intent=new Intent(ActividadPersonas.this, ActividadDetalles.class);
			intent.putExtra("valueid", valueid);
			ActividadPersonas.this.startActivity(intent);  			
		}  
	};
		    	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);  
		
		Bundle datos = this.getIntent().getExtras();
        int position = datos.getInt("position");
        
       // ArrayList results = new ArrayList();
        ArrayList<String> results = new ArrayList<String>();
      
        // -- SQLiteOpenHelper dbHelper = new DefaultDBHelper(this, MY_DATABASE_NAME, null, 1);
        SQLiteDatabase myDB = this.openOrCreateDatabase(MY_DATABASE_NAME, SQLiteDatabase.OPEN_READWRITE, null);
        try {             
               // -- openOrCreateDatabase(name, mode, factory)
               // myDB = dbHelper.getReadableDatabase();
               Cursor c = myDB.query(UsuariosSQLiteHelper.MY_DATABASE_TABLE, null, "codigo >=0", null, null, null, null);         
               /* Check if our result was valid. */ 
           if (c != null) {          
               c.moveToFirst(); // it's very important to do this action otherwise your Cursor object did not get work
               int codigo = c.getColumnIndex("codigo"); 
               int nombre = c.getColumnIndex("nombre"); 
                /* Check if at least one Result was returned. */ 
                if (c.isFirst()) {                  
                     /* Loop through all Results */ 
                     do {                      
                          String codigos = c.getString(codigo);                            
                          String nombres = c.getString(nombre);                            
                          /* Add current Entry to results. */ 
                          results.add("" + codigos + ": " + nombres + ""); 
                     } while (c.moveToNext()); 
                } 
           }
               
       } catch (SQLiteException e) { 
       } finally { 
            if (myDB != null) 
                 myDB.close(); 
       }
       
       // -- android.R.layout.simple_list_item_1 is object which belong to ListActivity itself
       // -- you only need to add list object in your main layout file
       //setListAdapter(new ArrayAdapter(this,R.layout.personas, results)); 
       
        switch( position )
        {
           case 0:  setListAdapter(new ArrayAdapter<String>(this, R.layout.personas, results));
                    break;
           case 1:  setListAdapter(new ArrayAdapter<String>(this, R.layout.personas, results));
                    break;
           case 2:  setListAdapter(new ArrayAdapter<String>(this, R.layout.personas, results));
                    break;
           case 3:  setListAdapter(new ArrayAdapter<String>(this, R.layout.personas, results));
                    break;
           case 4:  setListAdapter(new ArrayAdapter<String>(this, R.layout.personas, results));
                    break;
           case 5:  setListAdapter(new ArrayAdapter<String>(this, R.layout.personas, AFILIADOS));
                    break;
        }
	    
		ListView lv = getListView();  
		lv.setTextFilterEnabled(true);  
		lv.setOnItemClickListener(mCorkyListener);
	}
		    
}
