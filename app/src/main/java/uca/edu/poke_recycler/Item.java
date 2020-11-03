package uca.edu.poke_recycler;

public class Item {
    private int imgResId;
    private String title;
    private String descripcion;


    public Item(int imgResId, String title, String descripcion){
        this.imgResId = imgResId;
        this.title = title;
        this.descripcion = descripcion;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getTitle(){
        return title;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
