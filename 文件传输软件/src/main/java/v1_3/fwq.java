package v1_3;

import v1_3.Message;
import v1_3.发送;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class fwq implements Runnable {
    public static ArrayList<Socket> list;
    public static int yilianjie = 0;

    fwq() {
    }

    public void run() {
        list = new ArrayList();
        ServerSocket soo = null;
        ExecutorService ex = Executors.newCachedThreadPool();

        try {
            soo = new ServerSocket(61855);
        } catch (IOException var7) {
            try {
                Message dialog = new Message(发送.发送, "<html>端口61855已打开 启动程序失败 可能程序已经启动...<br>程序将在5秒内退出", 380, 129);
                dialog.setDefaultCloseOperation(2);
                dialog.setVisible(true);
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException var5) {
                var5.printStackTrace();
            }
        }

        while(true) {
            while(true) {
                try {
                    Socket so = soo.accept();
                    list.add(so);
                    ++yilianjie;
                    发送.发送.repaint();
                    ex.execute(new v1_3.fwq.dklj(so));
                } catch (IOException var8) {
                    var8.printStackTrace();
                }
            }
        }
    }

    class dklj implements Runnable {
        Socket so = null;

        dklj(Socket so) {
            this.so = so;
        }

        public void run() {
            BufferedReader in = null;

            try {
                do {
                    in = new BufferedReader(new InputStreamReader(this.so.getInputStream()));
                } while(in.readLine() != null);
            } catch (IOException var4) {
            }

            --v1_3.fwq.yilianjie;
            v1_3.fwq.list.remove(this.so);
            发送.发送.repaint();

            try {
                if (in != null) {
                    in.close();
                }

                if (this.so != null) {
                    this.so.close();
                }
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }
    }
}
