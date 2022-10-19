public class Papan {
    public Kotak[][] papan;

    private static int jmlKotak=4;

    private int batas=0;

    public int skor=0;

    //constructor
    public Papan(){
        papan=new Kotak[4][4];
        for(int baris=0;baris<papan.length;baris++){
            for(int kolom=0;kolom<papan.length;kolom++){
                papan[baris][kolom]=new Kotak();
            }
        }
    }

    public Kotak[][] getPapan(){
        return papan;
    }

    public int getSkor(){
        return skor;
    }

    public void summonAngka(){
        boolean empty = true;
        while(empty)
        {
            int row = (int)(Math.random()*4);
            int col = (int)(Math.random()*4);
            double x = Math.random();
            if(papan[row][col].getValue()==0){
                if(x<0.2){
                    papan[row][col]=new Kotak(4);
                    empty = false;
                }
                else{
                    papan[row][col]=new Kotak(2);
                    empty = false;
                }
            }

        }

    }

    public int getNilaiKotakTertinggi(){
        int high=papan[0][0].getValue();
        for(int baris=0;baris<papan.length;baris++){
            for(int kolom=0;kolom<papan[baris].length;kolom++){
                if(papan[baris][kolom].getValue()>high){
                    high=papan[baris][kolom].getValue();
                }
            }
        }
        return high;
    }

    public boolean noMoreMove(){
        int count=0;
        for(int i=0;i<papan.length;i++){
            for(int j=0;j<papan[i].length;j++){
                if(papan[i][j].getValue()>0){
                    count++;
                }
            }
        }
        if(count==16){
            return true;
        }
        return false;
    }

    public boolean isGameOver(){
        int counter=0;
        for(int i=0;i<papan.length;i++){
            for(int j=0;j<papan[i].length;j++){
                if(papan[i][j].getValue()>0){
                    if(i==0 && j==0 ){
                        if(papan[i][j].getValue()!=papan[i + 1][j].getValue()
                            && papan[i][j].getValue()!=papan[i][j + 1].getValue())
                        {
                            counter++;
                        }
                    }
                    else if(i==0 && j==3){
                        if(papan[i][j].getValue()!=papan[i + 1][j].getValue()
                            && papan[i][j].getValue()!=papan[i][j - 1].getValue())
                        {
                            counter++;
                        }
                    }
                    else if(i==3 && j==3){
                        if(papan[i][j].getValue()!=papan[i - 1][j].getValue()
                            && papan[i][j].getValue()!=papan[i][j - 1].getValue())
                        {
                            counter++;
                        }
                    }
                    else if(i==3 && j==0){
                        if(papan[i][j].getValue()!=papan[i - 1][j].getValue()
                            && papan[i][j].getValue()!=papan[i][j + 1].getValue())
                        {
                            counter++;
                        }
                    }
                    else if(i==0 && (j==1 || j==2)){
                        if(papan[i][j].getValue()!=papan[i + 1][j].getValue()
                            && papan[i][j].getValue()!=papan[i][j + 1].getValue()
                            && papan[i][j].getValue()!=papan[i][j - 1].getValue())
                        {
                            counter++;
                        }
                    }
                    else if(i==3 && (j==1 || j==2)){
                        if(papan[i][j].getValue()!=papan[i - 1][j].getValue()
                            && papan[i][j].getValue()!=papan[i][j + 1].getValue()
                            && papan[i][j].getValue()!=papan[i][j - 1].getValue())
                        {
                            counter++;
                        }
                    }
                    else if(j==0 && (i==1 || i==2)){
                        if(papan[i][j].getValue()!=papan[i][j + 1].getValue()
                            && papan[i][j].getValue()!=papan[i - 1][j].getValue()
                            && papan[i][j].getValue()!=papan[i + 1][j].getValue())
                        {
                            counter++;
                        }
                    }
                    else if(j==3 && (i==1 || i==2)){
                        if(papan[i][j].getValue()!=papan[i][j - 1].getValue()
                            && papan[i][j].getValue()!=papan[i - 1][j].getValue()
                            && papan[i][j].getValue()!=papan[i + 1][j].getValue())
                        {
                            counter++;
                        }
                    }
                    else{
                        if(papan[i][j].getValue()!=papan[i][j - 1].getValue()
                            && papan[i][j].getValue()!=papan[i][j + 1].getValue()
                            && papan[i][j].getValue()!=papan[i - 1][j].getValue()
                            && papan[i][j].getValue()!=papan[i + 1][j].getValue())
                        {
                            counter++;
                        }
                    }
                }
            }
        }
        if(counter==16){
            return true;
        }
        return false;
    }

    private void vertical(int baris, int kolom, String arah){ //all for vertical move (up or down)
        Kotak initial=papan[batas][kolom];
        Kotak compare=papan[baris][kolom];
        if(initial.getValue()==0 || initial.getValue()==compare.getValue()){
            if(baris>batas || (arah.equals("down") && ( baris < batas ))){
                int tambahSkor=initial.getValue()+compare.getValue();
                if(initial.getValue()!=0){
                    skor += tambahSkor;
                }
                initial.setValue(tambahSkor);
                compare.setValue(0);
            }
        }
        else
        {
            if(arah.equals("down")){
                batas--;
            }
            else{
                batas++;
            }
            vertical(baris,kolom,arah);
        }
    }

    public void up(){
        for(int i=0;i<jmlKotak;i++){
            batas=0;
            for(int j=0;j<jmlKotak;j++){
                if(papan[j][i].getValue()!=0 ){
                    if(batas<=j){
                        vertical(j,i,"up" );
                    }
                }
            }
        }
    }

    public void down(){
        for(int i=0;i<jmlKotak;i++){
            batas=(jmlKotak - 1);
            for(int j=jmlKotak-1;j>=0;j--){
                if(papan[j][i].getValue()!=0){
                    if(batas>=j){
                        vertical(j,i,"down" );
                    }
                }
            }
        }
    }

    private void horizontal( int baris, int kolom, String arah ){ //all for horizontal move (right or left)
        Kotak initial=papan[baris][batas];
        Kotak compare=papan[baris][kolom];
        if(initial.getValue()==0 || initial.getValue()==compare.getValue()){
            if(kolom>batas || (arah.equals("right") && (kolom<batas))){
                int tambahSkor=initial.getValue()+compare.getValue();
                if(initial.getValue()!=0){
                    skor += tambahSkor;
                }
                initial.setValue(tambahSkor);
                compare.setValue(0);
            }
        }
        else{
            if(arah.equals("right")){
                batas--;
            }
            else{
                batas++;
            }
            horizontal(baris, kolom, arah);
        }
    }

    public void left(){
        for(int i=0;i<jmlKotak;i++){
            batas=0;
            for(int j=0;j<jmlKotak;j++){
                if(papan[i][j].getValue()!=0){
                    if(batas<=j){
                        horizontal(i,j,"left");
                    }
                }
            }
        }
    }

    public void right(){
        for(int i=0;i<jmlKotak;i++){
            batas=(jmlKotak-1);
            for( int j=(jmlKotak-1 );j>=0;j--){
                if(papan[i][j].getValue()!=0){
                    if(batas>=j){
                        horizontal(i,j,"right");
                    }
                }
            }
        }
    }
}
