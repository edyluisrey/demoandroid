package com.example.demoapp;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
 
import android.os.Bundle;
 
public class ActividadMapa extends MapActivity {
 
    private MapView mapa = null;
    private MapController controlMapa = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);
 
        //Obtenemos una referencia al control MapView
        mapa = (MapView)findViewById(R.id.mapa);
 
        //Mostramos los controles de zoom sobre el mapa
        mapa.setBuiltInZoomControls(true);
        
        controlMapa = mapa.getController();
        Double latitud = -12.10*1E6;  
        Double longitud = -77.03*1E6;
 
        GeoPoint loc = new GeoPoint(latitud.intValue(), longitud.intValue());
 
        controlMapa.setCenter(loc);
        controlMapa.setZoom(14);
    }
 
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}
