//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package v1_3;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class 入口 extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    入口 frame = new 入口();
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

                System.out.println("请不要关闭此窗口！！！");
                System.out.println("请不要关闭此窗口！！！");
                System.out.println("请不要关闭此窗口！！！");
                System.out.print("重要是事情要说三遍");
            }
        });
    }

    public 入口() {
        this.setResizable(false);
        this.setTitle("NWPU网络空间安全学院计算机网络课程传输文件v1.3");
        this.setDefaultCloseOperation(3);
        this.setSize(450, 300);
        this.setLocationRelativeTo((Component)null);
        this.contentPane = new JPanel();
        this.contentPane.setBackground(Color.WHITE);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        JButton btnNewButton = new JButton("发文件");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                发送 f = new 发送(入口.this);
                入口.this.setVisible(false);
                f.setVisible(true);
            }
        });
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("微软雅黑", 0, 16));
        btnNewButton.setBounds(10, 81, 414, 32);
        this.contentPane.add(btnNewButton);
        JButton button = new JButton("收文件");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                接受 f = new 接受(入口.this);
                入口.this.setVisible(false);
                f.setVisible(true);
            }
        });
        button.setBackground(Color.WHITE);
        button.setFont(new Font("微软雅黑", 0, 16));
        button.setBounds(10, 123, 414, 32);
        this.contentPane.add(button);
        JButton button_1 = new JButton("黄柯蒲");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Message dialog = new Message(入口.this, "<html>关于我是谁，双枪会给出答案", 278, 129);
                    dialog.setDefaultCloseOperation(2);
                    dialog.setVisible(true);
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        });
        button_1.setBackground(Color.WHITE);
        button_1.setFont(new Font("微软雅黑", 0, 12));
        button_1.setBounds(331, 228, 93, 23);
        this.contentPane.add(button_1);
        JButton btnNewButton_1 = new JButton("版本信息");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Message dialog = new Message(入口.this, "<html>版本v1.3测试修改第三次，没有第四次了！！！", 374, 158);
                    dialog.setDefaultCloseOperation(2);
                    dialog.setVisible(true);
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        });
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setFont(new Font("微软雅黑", 0, 12));
        btnNewButton_1.setBounds(10, 228, 93, 23);
        this.contentPane.add(btnNewButton_1);
    }
}
