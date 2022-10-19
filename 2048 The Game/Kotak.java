import java.awt.Color;

public class Kotak {
    int valueKotak;

    Color warnaKotak;

    public Kotak(){
        valueKotak=0;
    }

    public Kotak(int nilaiKotak){
        valueKotak=nilaiKotak;
    }

    public int getValue(){
        return valueKotak;
    }

    public void setValue(int valueKotak){
        this.valueKotak=valueKotak;
    }

    public void setColor()
    {
        if (this.getValue()==2)
        {
            warnaKotak=new Color(238,228,218);
        }
        else if(this.getValue()==4)
        {
            warnaKotak=new Color(237,224,200);
        }
        else if(this.getValue()==8)
        {
            warnaKotak=new Color(242,177,121);
        }
        else if(this.getValue()==16)
        {
            warnaKotak=new Color(245,149,99);
        }
        else if(this.getValue()==32)
        {
            warnaKotak=new Color(246,124,95);
        }
        else if(this.getValue()==64)
        {
            warnaKotak=new Color(246,94,59);
        }
        else if(this.getValue()==128)
        {
            warnaKotak=new Color(237,207,114);
        }
        else if(this.getValue()==256)
        {
            warnaKotak=new Color(237,204,97);
        }
        else if(this.getValue()==512)
        {
            warnaKotak=new Color(237,200,80);
        }
        else if(this.getValue()==1024)
        {
            warnaKotak=new Color(237,197,63);
        }
        else
        {
            warnaKotak=new Color(237,194,46);
        }
    }

    public Color getColor()
    {
        this.setColor();
        return warnaKotak;
    }
}
