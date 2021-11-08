//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package v1_3;

class drawaaa implements Runnable {
    drawaaa() {
    }

    public void run() {
        while(fasong.list.size() > 0) {
            try {
                Thread.sleep(0L);
            } catch (InterruptedException var5) {
                var5.printStackTrace();
            }

            aaa aaa = null;
            StringBuffer str = new StringBuffer("<html>");

            for(int i = 0; i < fasong.list.size(); ++i) {
                aaa = (aaa)fasong.list.get(i);
                str.append(aaa.s);
                str.append("<br>");
            }

            发送.label_1.setText(str.toString());
        }

        发送.label_1.setText("已完成");
        发送.发送.repaint();

        try {
            Message dialog = new Message(发送.发送, "传输完成！", 278, 129);
            dialog.setDefaultCloseOperation(2);
            dialog.setVisible(true);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}
