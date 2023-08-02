package com.example.mytag.support;

/**
 * @author Belitski Marat
 * @date 02.08.2023
 */
public class Language {
    String name;
    int image;

    public Language(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
