package com.jarves.recycleview.HelperClasses;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import static java.lang.Integer.parseInt;

public class phonehelper {

    int image;
    int pcantidad;
    String title;
    String cantidad;
    GradientDrawable color;

    public phonehelper(GradientDrawable color, int image, String title) {
        this.image = image;
        this.title = title;
        this.color = color;
        this.cantidad = "0";
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }


    public Drawable getgradient() {
        return color;
    }

    public String getCantidad() {
        //pcantidad = parseInt(cantidad);
        return cantidad;
    }

    }
