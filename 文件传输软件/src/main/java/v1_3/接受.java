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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

public class 接受 extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    public static boolean yilianjie = false;
    public static boolean jinzhiguanbi = false;
    public static 接受 接受;
    public static JLabel lblip = new JLabel("请先连接到对方IP：");
    public static JTextField textField_1;
    private JLabel label;
    private JButton button_1;
    public static JLabel lblNewLabel;
    private JButton button_2;
    private JButton button_3;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    接受 frame = new 接受((Component)null);
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    private void lujingout() {
        BufferedWriter out = null;

        try {
            out = new BufferedWriter(new FileWriter("Set.txt"));
            out.write(textField_1.getText() + "\r\n");
        } catch (IOException var4) {
        }

        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    private void lujingin() {
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("Set.txt"));
            String s = in.readLine();
            textField_1.setText(s);
        } catch (IOException var4) {
        }

        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public 接受(Component toto) {
        this.setResizable(false);
        this.setTitle("局域网文件传输-接收方V1.2");
        FileSystemView fsv = FileSystemView.getFileSystemView();
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                if (v1_3.接受.jinzhiguanbi) {
                    JOptionPane.showMessageDialog(接受.this, "正在传输文件...");
                } else {
                    接受.this.lujingout();
                    System.exit(0);
                }

            }
        });
        this.setBounds(100, 100, 450, 300);
        this.setLocationRelativeTo(toto);
        this.setLocation(this.getX() + this.getWidth() / 2, this.getY());
        this.contentPane = new JPanel();
        this.contentPane.setBackground(Color.WHITE);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        this.textField = new JTextField();
        this.textField.setFont(new Font("微软雅黑", 0, 12));
        this.textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!v1_3.接受.yilianjie) {
                    (new Thread(new lianjie(接受.this.textField.getText()))).start();
                } else {
                    try {
                        Message dialog = new Message(接受.this, "已连接服务器...", 278, 129);
                        dialog.setDefaultCloseOperation(2);
                        dialog.setVisible(true);
                    } catch (Exception var3) {
                        var3.printStackTrace();
                    }
                }

            }
        });
        this.textField.setText("192.168.1.");
        this.textField.setBounds(46, 139, 260, 21);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);
        JButton button = new JButton("连接");
        button.setBackground(Color.WHITE);
        button.setFont(new Font("微软雅黑", 0, 14));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!v1_3.接受.yilianjie) {
                    (new Thread(new lianjie(接受.this.textField.getText()))).start();
                } else {
                    try {
                        Message dialog = new Message(接受.this, "已连接服务器...", 278, 129);
                        dialog.setDefaultCloseOperation(2);
                        dialog.setVisible(true);
                    } catch (Exception var3) {
                        var3.printStackTrace();
                    }
                }

            }
        });
        button.setBounds(316, 138, 93, 23);
        this.contentPane.add(button);
        lblip.setFont(new Font("微软雅黑", 0, 14));
        lblip.setBounds(10, 114, 414, 15);
        this.contentPane.add(lblip);
        textField_1 = new JTextField(fsv.getHomeDirectory().toString() + "\\");
        textField_1.setFont(new Font("微软雅黑", 0, 12));
        this.lujingin();
        textField_1.setBounds(46, 195, 260, 21);
        this.contentPane.add(textField_1);
        textField_1.setColumns(10);
        this.label = new JLabel("另存为目录：");
        this.label.setFont(new Font("微软雅黑", 0, 14));
        this.label.setBounds(10, 170, 109, 15);
        this.contentPane.add(this.label);
        this.button_1 = new JButton("浏览");
        this.button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Message dialog = new Message(接受.this, "此按钮不可用 请将保存路径复制到编辑框", 278, 129);
                    dialog.setDefaultCloseOperation(2);
                    dialog.setVisible(true);
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        });
        this.button_1.setBackground(Color.WHITE);
        this.button_1.setFont(new Font("微软雅黑", 0, 14));
        this.button_1.setBounds(316, 194, 93, 23);
        this.contentPane.add(this.button_1);
        lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("微软雅黑", 0, 12));
        lblNewLabel.setBounds(142, 60, 144, 15);
        this.contentPane.add(lblNewLabel);
        this.button_2 = new JButton("设为桌面");
        this.button_2.setBackground(Color.WHITE);
        this.button_2.setFont(new Font("微软雅黑", 0, 14));
        this.button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileSystemView fsv = FileSystemView.getFileSystemView();
                v1_3.接受.textField_1.setText(fsv.getHomeDirectory() + "\\");
            }
        });
        this.button_2.setBounds(213, 220, 93, 23);
        this.contentPane.add(this.button_2);
        this.button_3 = new JButton("使用上一次的路径");
        this.button_3.setBackground(Color.WHITE);
        this.button_3.setFont(new Font("微软雅黑", 0, 14));
        this.button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                接受.this.lujingin();
            }
        });
        this.button_3.setBounds(56, 220, 147, 23);
        this.contentPane.add(this.button_3);
        接受 = this;
    }
}
