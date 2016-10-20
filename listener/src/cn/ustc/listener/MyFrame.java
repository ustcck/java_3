package cn.ustc.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * listener
 * Created by ustcck on 2016/10/15.
 */
public class MyFrame extends JFrame{
    private JButton button = new JButton("按钮");//事件源
    //事件：button被按下就是一个事件
    public MyFrame() throws HeadlessException {
        this.getContentPane().add(button);
        button.addActionListener(new ButListener());//注册监听
        setDefaultCloseOperation(3);
        this.setBounds(100,100,300,300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    //监听器
    private class ButListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello world");
        }
    }
}
