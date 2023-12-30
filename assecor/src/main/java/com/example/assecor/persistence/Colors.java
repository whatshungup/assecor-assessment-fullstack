package com.example.assecor.persistence;

import org.springframework.stereotype.Component;

@Component
public class Colors {
    public static ColorEntity[] COLORS = {
            new ColorEntity(1L, "Blau","#0000FF"),
            new ColorEntity(2L, "Grün","#00FF00"),
            new ColorEntity(3L, "Violett","#FF00FF"),
            new ColorEntity(4L, "Rot","#FF0000"),
            new ColorEntity(5L, "Gelb","#FFFF00"),
            new ColorEntity(6L, "Türkis","#40E0D0"),
            new ColorEntity(7L, "Weiß","#000000"),
    };
}
