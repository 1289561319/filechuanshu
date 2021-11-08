//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package v1_3;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class 发送 extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    public static 发送 发送;
    public static String mulu;
    public static JLabel label_1 = new JLabel("");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    发送 frame = new 发送((Component)null);
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public 发送(Component toto) {
        this.setResizable(false);
        this.setTitle("局域网文件传输-发送方V1.2");
        发送 = this;
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                if (fasong.list.size() > 0) {
                    try {
                        Message dialog = new Message(发送.this, "正在传输文件请稍后再试...", 278, 129);
                        dialog.setDefaultCloseOperation(2);
                        dialog.setVisible(true);
                    } catch (Exception var3) {
                        var3.printStackTrace();
                    }
                } else {
                    System.exit(0);
                }

            }
        });
        this.setDefaultCloseOperation(0);
        this.setBounds(100, 100, 450, 300);
        this.setLocationRelativeTo(toto);
        this.setLocation(this.getX() - this.getWidth() / 2, this.getY());
        this.contentPane = new JPanel();
        this.contentPane.setBackground(Color.WHITE);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        this.textField = new JTextField();
        this.textField.setBackground(Color.WHITE);
        this.textField.setFont(new Font("微软雅黑", 0, 12));
        this.textField.setEditable(false);
        this.textField.setBounds(10, 194, 414, 21);
        this.contentPane.add(this.textField);
        this.textField.setColumns(10);
        JLabel label = new JLabel("文件路径：(把文件拖到这里)");
        label.setFont(new Font("微软雅黑", 0, 14));
        label.setBounds(10, 169, 213, 15);
        this.contentPane.add(label);
        JButton button = new JButton("发送");
        button.setBackground(Color.WHITE);
        button.setFont(new Font("微软雅黑", 0, 14));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message dialog;
                if (发送.this.textField.getText().equals("")) {
                    try {
                        dialog = new Message(发送.this, "请设置文件路径...", 278, 129);
                        dialog.setDefaultCloseOperation(2);
                        dialog.setVisible(true);
                    } catch (Exception var7) {
                        var7.printStackTrace();
                    }
                } else if (fasong.list.size() > 0) {
                    try {
                        dialog = new Message(发送.this, "正在传输文件请稍后再试", 278, 129);
                        dialog.setDefaultCloseOperation(2);
                        dialog.setVisible(true);
                    } catch (Exception var6) {
                        var6.printStackTrace();
                    }
                } else {
                    File fi = new File(发送.this.textField.getText());
                    if (!fi.isFile()) {
                        try {
                            Message dialogx = new Message(发送.this, "非法文件 请重新选择", 278, 129);
                            dialogx.setDefaultCloseOperation(2);
                            dialogx.setVisible(true);
                        } catch (Exception var5) {
                            var5.printStackTrace();
                        }

                        return;
                    }

                    Socket so = null;

                    for(int i = 0; i < fwq.list.size(); ++i) {
                        so = (Socket)fwq.list.get(i);
                        (new Thread(new fasong(so))).start();
                    }

                    (new Thread(new drawaaa())).start();
                }

            }
        });
        button.setBounds(331, 228, 93, 23);
        this.contentPane.add(button);
        JLabel lblNewLabel = new JLabel("请让对方连接到您的IP：");
        lblNewLabel.setFont(new Font("微软雅黑", 0, 16));
        lblNewLabel.setBounds(10, 128, 414, 31);
        this.contentPane.add(lblNewLabel);
        String s = null;

        try {
            s = "" + InetAddress.getLocalHost();
        } catch (UnknownHostException var8) {
            var8.printStackTrace();
        }

        StringBuffer ss = new StringBuffer();

        try {
            for(int i = s.indexOf("192"); i < s.length(); ++i) {
                ss.append(s.charAt(i));
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        lblNewLabel.setText("请让对方连接到您的IP（找到本机ip地址）");
        label_1.setFont(new Font("微软雅黑", 0, 12));
        label_1.setBounds(289, 0, 145, 184);
        this.contentPane.add(label_1);
        JLabel label_2 = new JLabel("如果无法连接请试着将本机防火墙关闭");
        label_2.setFont(new Font("微软雅黑", 0, 12));
        label_2.setBounds(10, 233, 236, 15);
        this.contentPane.add(label_2);
        (new Thread(new fwq())).start();
        new DropTarget(this, new DropTargetAdapter() {
            public void drop(DropTargetDropEvent arg0) {
                发送.this.drop(arg0);
            }
        });
        new DropTarget(this.textField, new DropTargetAdapter() {
            public void drop(DropTargetDropEvent arg0) {
                发送.this.drop(arg0);
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("已连接：" + fwq.list.size(), 11, 48);
    }

    public void drop(DropTargetDropEvent arg0) {
        arg0.acceptDrop(3);
        List list = null;

        try {
            list = (List)arg0.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            File fi = (File)list.get(0);
            mulu = fi.getPath();
            this.textField.setText(mulu);
        } catch (IOException | UnsupportedFlavorException var4) {
            var4.printStackTrace();
        }

    }
}
