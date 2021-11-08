//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package v1_3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

class lianjie implements Runnable {
    public Socket so;
    private String ip;

    public lianjie(String s) {
        this.ip = s;
    }

    public void run() {
        try {
            接受.lblip.setText("正在连接" + this.ip + "...");
            this.so = new Socket(this.ip, 61855);
            接受.lblip.setText("已连接" + this.ip + " 等待对方发送文件...");
            接受.yilianjie = true;
            (new Thread(new lianjie.shouwenjian())).start();
        } catch (IOException var2) {
            if (接受.yilianjie) {
                接受.lblip.setText("连接失败请检查IP是否正确");
            }
        }

    }

    class shouwenjian implements Runnable {
        shouwenjian() {
        }

        public void run() {
            BufferedOutputStream out = null;
            DataInputStream in = null;

            try {
                while(true) {
                    in = new DataInputStream(new BufferedInputStream(lianjie.this.so.getInputStream()));
                    byte[] by = new byte[10485760];
                    String name = in.readUTF();
                    long size = in.readLong();
                    接受.jinzhiguanbi = true;
                    long jieshou = 0L;
                    String s = 接受.textField_1.getText();
                    char c = s.charAt(s.length() - 1);
                    if (c != '\\') {
                        s = s + "\\";
                    }

                    File mulu = new File(s);
                    if (!mulu.getParentFile().exists()) {
                        mulu.getParentFile().mkdirs();
                    }

                    if (!mulu.exists() && !mulu.isDirectory()) {
                        mulu.mkdir();
                    }

                    File fi = new File(s + name);
                    out = new BufferedOutputStream(new FileOutputStream(fi));

                    int len;
                    while((len = in.read(by)) != -1) {
                        out.write(by, 0, len);
                        out.flush();
                        jieshou += (long)len;
                        double bfb = (double)jieshou * 100.0D / (double)size;
                        bfb = (double)((int)(bfb * 10.0D));
                        bfb /= 10.0D;
                        接受.lblNewLabel.setText("已接收：" + bfb + "%");
                        if (jieshou >= size) {
                            break;
                        }
                    }

                    out.close();

                    try {
                        Message dialogx = new Message(接受.接受, "文件接收完成...", 278, 129);
                        dialogx.setDefaultCloseOperation(2);
                        dialogx.setVisible(true);
                    } catch (Exception var18) {
                        var18.printStackTrace();
                    }

                    接受.jinzhiguanbi = false;
                }
            } catch (IOException var19) {
                var19.printStackTrace();

                try {
                    Message dialog = new Message(接受.接受, "文件路径异常或发送方已关闭软件", 278, 129);
                    dialog.setDefaultCloseOperation(2);
                    dialog.setVisible(true);
                } catch (Exception var17) {
                    var17.printStackTrace();
                }

                接受.jinzhiguanbi = false;
                接受.yilianjie = false;
                接受.lblip.setText("已断开连接");

                try {
                    if (out != null) {
                        out.close();
                    }

                    if (in != null) {
                        in.close();
                    }

                    if (lianjie.this.so != null) {
                        lianjie.this.so.close();
                    }
                } catch (IOException var16) {
                    var16.printStackTrace();
                }

            }
        }
    }
}
