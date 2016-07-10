package com.cutterfire.view;

import javafx.scene.control.TextField;

public class FileLoadEdit extends TextField {

    public FileLoadEdit(String text,int x, int y, int weidth,int height) {
        super(text);
        setTranslateX(x);
        setTranslateY(y);
        setWidth(weidth);
        setHeight(height);
    }

    public FileLoadEdit(String text,int x, int y, int weidth) {
        super(text);
        setTranslateX(x);
        setTranslateY(y);
        setWidth(weidth);
    }
}
