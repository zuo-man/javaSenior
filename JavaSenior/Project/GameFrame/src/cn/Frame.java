package cn;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * @create 2021-11-12 16:27
 */
public class Frame extends JFrame {
    Plane plane;

    //初始化窗口，构造器
    public Frame(){
        //创建飞机
        plane = new Plane();

        //设置窗体的宽高
        this.setSize(500,760);
        this.setTitle("雷霆战机");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //窗口可见
        this.setVisible(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /*
    在窗口上画内容，paint这个画笔的方法在敞口初始化的时候会默认的执行
     */
    public void paint(Graphics g){
        System.out.println("绘制面板");
        //画背景
        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width,this.getSize().height);
        //高效缓存的画笔
        Graphics bi = image.getGraphics();

        bi.drawImage(new ImageIcon("img/bj.png").getImage(),0,0,null);

        bi.drawImage(plane.img,plane.x,plane.y,null);



        //生效
        g.drawImage(image,0,0,null);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}
