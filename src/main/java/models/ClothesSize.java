package models;

public enum ClothesSize {

    S(0), M(1), L(2), XL(3);

    private int index;

    private ClothesSize(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }


}
