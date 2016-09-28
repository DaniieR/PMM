package com.example.mati.checkbox2;

import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by mati on 28/09/16.
 */
public class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener {
    @Override
    public void onCheckedChanged(CompoundButton bottonView,boolean isChecked){
        if (isChecked){
            if (buttonView==chkBoxDeporte){
                showTextNotification("Deporte");
            }
            if (buttonView==chkBoxLeer){
                showTextNotification("Leer");
            }
            if (buttonView==chkBoxMusica){
                showTextNotification("Musica");
            }
        }
    }
}
