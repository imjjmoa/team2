package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JFrame{
    private String [] md={"TIM","STW","ALM","TMR","DIC","RRT"};                   // md=모드이름, d3=요일
    private String [] d3={"MON","TUS","WED","TUR","FRY","SAT","SUN","SET","---","ON","OFF"};
    //private int tm1=0,tm2=0,tm3=0,d1=1,d2=1;          // tm1=왼쪽 숫자,tm2=중간 숫자,tm3=오른쪽숫자,d1=월,d2=일
    //public int md_num=0;
    //private int d3_num=0;
    public long btn_press=0,btn_release=0;
    public long btn_time=0;

    public int btn_input=0;
    public int btn_temp=0;

    private JButton ok=new JButton("OK");
    private JButton menu=new JButton("MENU");
    private JButton up=new JButton("UP");
    private JButton down=new JButton("DOWN");

    private JLabel mode=new JLabel();
    private JLabel time=new JLabel();
    private JLabel day=new JLabel();

    public GUI(){

        setLayout();
        setButton();
        setLabel();

    }
    private class MyActionListener implements MouseListener {

        public void mouseClicked(MouseEvent e){
        }
        public void mousePressed(MouseEvent e) {
            if(e.isMetaDown()){

            }
            else
            {
                btn_press=System.currentTimeMillis();
            }
        }
        public void mouseReleased(MouseEvent e) {
            JButton b = (JButton)e.getSource();
            if(e.isMetaDown()){

            }
            else
            {
                btn_release=System.currentTimeMillis();
                btn_time=btn_release-btn_press;
                if(b.getText().equals("UP")) {
                    btn_input=1;
                }
                if(b.getText().equals("DOWN")) {
                    btn_input=2;
                }
                if(b.getText().equals("OK") && btn_time>=2000)
                {
                    btn_input=5;
                }
                else if(b.getText().equals("OK")){
                    btn_input=3;
                }
                if(b.getText().equals("MENU")&&btn_time>=2000)
                {
                    btn_input=6;
                }
                else if(b.getText().equals("MENU")){
                    btn_input=4;
                }
            }
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }
    private void setButton(){
        MyActionListener listener=new MyActionListener();

        this.ok.addMouseListener(listener);
        this.menu.addMouseListener(listener);
        this.up.addMouseListener(listener);
        this.down.addMouseListener(listener);

        this.ok.setSize(80,80);
        this.ok.setLocation(0,0);
        this.menu.setSize(80,80);
        this.menu.setLocation(0,520);
        this. up.setSize(80,80);
        this.up.setLocation(520,0);
        this.down.setSize(80,80);
        this.down.setLocation(520,520);

        add(this.ok);
        add(this.menu);
        add(this.up);
        add(this.down);
    }
    private void setLayout(){
        setTitle("Watch");
        setSize(618,647);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void setLabel(){


        this.mode.setOpaque(true);
        this.mode.setBackground(new Color(0,0,0,0));
        this.mode.setBounds(250,230,300,20);
        this.mode.setForeground(Color.black);

        this.time.setOpaque(true);
        this.time.setBackground(new Color(0,0,0,0));
        this.time.setBounds(250,250,300,20);
        this.time.setForeground(Color.black);

        this.day.setOpaque(true);
        this.day.setBackground(new Color(0,0,0,0));
        this.day.setBounds(250,270,300,20);
        this.day.setForeground(Color.black);
    }

    public void display(int [] dis){

        this.mode.setText("Mode : " + this.md[dis[0]]);
        this.time.setText(dis[1] + ":" + dis[2] + ":" + dis[3]);
        this.day.setText(dis[4] + "-" + dis[5] + "-" + this.d3[dis[6]]);

        add(this.mode);
        add(this.time);
        add(this.day);
    }

    public int GUI_btn(){
        btn_temp=btn_input;
        btn_input=0;
        return btn_temp;
    }
}