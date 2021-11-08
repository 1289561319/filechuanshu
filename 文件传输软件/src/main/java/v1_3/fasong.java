//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package v1_3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

class fasong implements Runnable {
    public static ArrayList<aaa> list = new ArrayList();
    Socket so = null;
    private aaa aaa;

    public fasong(Socket so) {
        this.so = so;
        this.aaa = new aaa();
        list.add(this.aaa);
    }

    public void run() {
        File fi = new File(发送.mulu);
        BufferedInputStream in = null;

        try {
            in = new BufferedInputStream(new FileInputStream(fi));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(this.so.getOutputStream()));
            String name = fi.getName();
            long size = fi.length();
            long yifasong = 0L;
            byte[] by = new byte[10485760];
            out.writeUTF(name);
            out.flush();
            out.writeLong(size);
            out.flush();

            int len;
            while((len = in.read(by)) != -1) {
                out.write(by, 0, len);
                out.flush();
                yifasong += (long)len;
                double bfb = (double)yifasong * 100.0D / (double)size;
                bfb = (double)((int)(bfb * 10.0D));
                bfb /= 10.0D;
                this.aaa.s = "已发送：" + bfb + "%";
            }

            list.remove(this.aaa);
        } catch (IOException var14) {
            var14.printStackTrace();
        }

        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException var13) {
            var13.printStackTrace();
        }

        发送.发送.repaint();
    }
}
