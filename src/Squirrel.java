public class Squirrel {
    private int[] nuts;

    public Squirrel(int[] nuts) {
        this.nuts = nuts;
    }

    public int getNuts(int index) {
        return nuts[index];
    }


    public int maxNuts() {
        int[] nutsCost = new int[nuts.length];
        if (nuts.length == 1) {
            return nuts[0] >= 0 ? nuts[0] : 0;
        }else {
            nutsCost[0] = nuts[0];
            nutsCost[1] = Math.max(nuts[1], nuts[1] + nuts[0]);
            for (int i = 2; i < nuts.length; i++) {
                nutsCost[i] = nuts[i] + Math.max(nutsCost[i - 1], nutsCost[i - 2]);
                if (nutsCost[i]<0){
                    nutsCost[i]=0;
                }
            }
        }
        return Math.max(1, Math.max(nutsCost[nutsCost.length-1],nutsCost[nutsCost.length-2]));

    }
}