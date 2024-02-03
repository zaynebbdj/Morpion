import javax.swing.JOptionPane;

public class Partie {


    private Content currentPlayer;
    private Content[][] plateau;
    private static int LENGTH = 150;

    public Partie(){
        this.currentPlayer = Content.CROSS;
        this.plateau = new Content[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.plateau[i][j] = Content.EMPTY;
            }
        }
    }
    public Content[][] getPlateau(){
        return this.plateau;
    }

    public void setJoueur(Content c){
        this.currentPlayer = c;
    }

    public void update(int x, int y){
        int coupX = x / LENGTH;
        int coupY = y / LENGTH;
        if(coupPossible(coupX,coupY)){
            setCase(coupX,coupY);
            changeJoueur();
        }else{
            JOptionPane.showMessageDialog(null, "La case est déjà occupée");
        }
        if(isOver()){
            JOptionPane.showMessageDialog(null, "La partie est terminée");
            this.setNewPartie();
        }
    }

    public boolean coupPossible(int i, int j){
        return ( this.plateau[i][j] == Content.EMPTY );
    }
    public void setCase(int i, int j){
        this.plateau[i][j] = this.currentPlayer;
    }
    public void changeJoueur(){
        if(this.currentPlayer == Content.CROSS){
            this.setJoueur(Content.CIRCLE);
        }else{
            this.setJoueur(Content.CROSS);
        }
    }

    public boolean isCircle(int x, int y){
        return this.plateau[x][y] == Content.CIRCLE;
    }
    public boolean isCross(int x, int y){
        return this.plateau[x][y] == Content.CROSS;
    }
    public void showPlateau(){
        for(int i = 0 ; i < 3 ; i++){
            for( int j = 0; j < 3; j++){
                System.out.print("["+this.plateau[i][j]+"] "+ i+"-");
            }System.out.println();
        }
    }

    
    public void setNewPartie(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.plateau[i][j] = Content.EMPTY;
            }
        }
        this.currentPlayer = Content.CROSS;
    }
    public boolean isOver(){
        return (lineWin() || diagonalWin());
    }

    public boolean lineWin(){
        Content a, b, c;
        for(int i = 0; i < 3; i++){
            a = plateau[i][0];
            b = plateau[i][1];
            c = plateau[i][2];
            if ( a == b && a == c && (a == Content.CIRCLE || a == Content.CROSS)) return true;
        }
        for(int i = 0; i < 3; i++){
            a = plateau[0][i];
            b = plateau[1][i];
            c = plateau[2][i];
            if ( a == b && a == c && (a == Content.CIRCLE || a == Content.CROSS)) return true;
        }
        return false;
    }
    public boolean diagonalWin(){
        Content a, b, c;
        a = plateau[0][0];
        b = plateau[1][1];
        c = plateau[2][2];
        if ( a == b && a == c && (a == Content.CIRCLE || a == Content.CROSS) ) return true;
        
        a = plateau[2][0];
        b = plateau[1][1];
        c = plateau[0][2];
        if ( a == b && a == c && (a == Content.CIRCLE || a == Content.CROSS)) return true;
        return false;
    }

    
}
