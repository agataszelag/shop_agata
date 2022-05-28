package models;

public enum Subject {

    CUSTOMER_SERVICE(0), WEBMASTER(1);

    private int index;

    private Subject(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }
}
