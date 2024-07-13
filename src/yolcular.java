public class yolcular {
    private final String ad;
    private final int index;


    public yolcular(String ad, int index) {
        this.ad = ad;
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
    @Override
    public String toString() {
        return String.format("%18s",ad) + " {"+String.format("%02d",index)+"}" ;

    }
}
