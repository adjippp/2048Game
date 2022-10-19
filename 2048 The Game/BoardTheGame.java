import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardTheGame extends JPanel implements KeyListener{

    Papan game=new Papan();

    static BoardTheGame newGame=new BoardTheGame();

    static JFrame frame=new JFrame("2048 the Game");

    static Color warna;

    String papanGame=game.toString();

    public static void main(String[] args)
    {
        start();
    }

    public static void start(){
        frame.addKeyListener(newGame);
        frame.getContentPane().add(newGame);
        frame.setSize(550,500);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyChar()=='w' || e.getKeyCode()==KeyEvent.VK_UP){
            game.up();
            game.summonAngka();
            papanGame = game.toString();
            frame.repaint();
        }
        else if(e.getKeyChar()=='s' || e.getKeyCode()==KeyEvent.VK_DOWN){
            game.down();
            game.summonAngka();
            papanGame = game.toString();
            frame.repaint();
        }
        else if(e.getKeyChar()=='a' || e.getKeyCode()==KeyEvent.VK_LEFT){
            game.left();
            game.summonAngka();
            papanGame = game.toString();
            frame.repaint();
        }
        else if(e.getKeyChar()=='d' || e.getKeyCode()==KeyEvent.VK_RIGHT){
            game.right();
            game.summonAngka();
            papanGame = game.toString();
            frame.repaint();
        }
        else if(e.getKeyCode()==KeyEvent.VK_ENTER){
            game = new Papan();
            game.summonAngka();
            game.summonAngka();
            frame.repaint();
        }
        // else if(e.getKeyCode()==KeyEvent.VK_F5){
        //     start();
        // }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        g2.drawString("2048",250,20);
        g2.drawString("Score: "+game.getSkor(),
            200-4*String.valueOf(game.getSkor()).length(),
            40);
        g2.drawString("Highest Tile: "+game.getNilaiKotakTertinggi(),
            280-4*String.valueOf(game.getNilaiKotakTertinggi()).length(),
            40);
        g2.drawString("Press 'Enter' to Start", 210, 315);
        g2.drawString("Use 'wasd' or Arrow Keys to move",180,335);
        // if(game.noMoreMove()){
        //     g2.drawString("Press 'Enter' to restart",200,355);
        // }
        g2.setColor(Color.gray);
        g2.fillRect(140,50,250,250);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                buatKotak(g,game.papan[i][j],j*60+150,i*60+60);
            }
        }
        if(game.isGameOver() || game.noMoreMove()){
            g2.drawString("Press F5 to restart",150,315);
            g2.setColor(Color.gray);
            g2.fillRect(140,50,250,250);
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    g2.setColor(Color.BLACK);
                    g2.fillRoundRect(j*60+150,i*60+60,50,50,5,5);
                    g2.setColor(Color.WHITE);
                    g.drawString("GAME",j*60+160,i*60+75);
                    g.drawString("OVER",j*60+160,i*60+95);
                }
            }
        }
    }

    private void buatKotak(Graphics g,Kotak kotak,int x,int y){
        int tileValue=kotak.getValue();
        int length=String.valueOf(tileValue).length();
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.lightGray);
        g2.fillRoundRect(x,y,50,50,5,5);
        g2.setColor(Color.black);
        if(tileValue>0){
            g2.setColor(kotak.getColor());
            g2.fillRoundRect(x,y,50,50,5,5);
            g2.setColor(Color.black );
            g.drawString(""+tileValue,x+25-3*length,y+25);
        }
    }
}
