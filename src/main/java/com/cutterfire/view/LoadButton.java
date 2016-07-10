package com.cutterfire.view;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class LoadButton extends Button {
    public LoadButton(String text, int x,int y, int width, int height) {
        super(text);
        setWidth(width);
        setHeight(height);
        setTranslateX(x);
        setTranslateY(y);
    }

    public LoadButton(String text, int x,int y) {
        super(text);
        setTranslateX(x);
        setTranslateY(y);
    }


}
