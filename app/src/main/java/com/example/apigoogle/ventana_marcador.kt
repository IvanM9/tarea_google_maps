package com.example.apigoogle

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.squareup.picasso.Picasso

class ventana_marcador(context: Context) : GoogleMap.InfoWindowAdapter {

    var mWindow = (context as Activity).layoutInflater.inflate(R.layout.ventana_marcador, null)

    fun marcadores(marker: Marker, view: View){
        var parseo =marker.snippet.toString()
        val list: List<String> = listOf(*marker.snippet.toString().split("&").toTypedArray())


        val facultad = view.findViewById<TextView>(R.id.facultad)
        val carreras = view.findViewById<TextView>(R.id.txt_carreras)
        val decano=view.findViewById<TextView>(R.id.txt_Decano)
        val coordenadas = view.findViewById<TextView>(R.id.txt_coord)
        val logo = view.findViewById<ImageView>(R.id.logo_facultad)
        if(list.size>0)
        {
            facultad.text = marker.title
            carreras.text = "Carreras: "+list?.get(0)
            decano.text="Decano: "+list?.get(2)
            coordenadas.text = "Latitud:"+marker.position.latitude.toString()+", Longitud:"+marker.position.longitude.toString()

            Picasso.get().load(list?.get(1)).into(logo)

        }
    }

    override fun getInfoContents(p0: Marker): View? {
        marcadores(p0, mWindow)
        return mWindow    }

    override fun getInfoWindow(p0: Marker): View? {
        marcadores(p0, mWindow)
        return mWindow
    }

}