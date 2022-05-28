package models;

public enum SocialTitle {

    MR(0), MRS(1);

    private int index;

    private SocialTitle(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

}
