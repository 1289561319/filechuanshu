//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package v1_3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Message extends JDialog {
    public static void main(String[] args) {
        try {
            Message dialog = new Message((Component)null, "<html>123<br>123", 450, 300);
            dialog.setDefaultCloseOperation(2);
            System.out.println(2);
            dialog.setVisible(true);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public Message(Component a, String s, int w, int h) {
        this.setTitle("消息");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(w, h);
        this.setLocationRelativeTo(a);
        this.getContentPane().setLayout((LayoutManager)null);
        JLabel lblNewLabel = new JLabel(s);
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("微软雅黑", 0, 12));
        lblNewLabel.setBounds(10, 10, this.getWidth() - 36, this.getHeight() - 92);
        this.getContentPane().add(lblNewLabel);
        JButton btnNewButton = new JButton("确定");
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("微软雅黑", 0, 12));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message.this.dispose();
            }
        });
        btnNewButton.setBounds(331, 228, 93, 23);
        this.getContentPane().add(btnNewButton);
        btnNewButton.setLocation(this.getWidth() - btnNewButton.getWidth() - 26, this.getHeight() - btnNewButton.getHeight() - 49);
    }
}
