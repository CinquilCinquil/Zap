package networking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI {

    private JPanel panel;
    private String title = "Zap";
    private JLabel msgLabel;
    private ArrayList msgs;

    Networking netObj;

    public GUI(String title, Networking netObj)
    {
        this.netObj = netObj;
        this.title = title;

        msgs = new ArrayList<String>();

        loadInterface();
    }

    public void loadInterface()
    {
        JFrame frame = new JFrame();
        panel = new JPanel();
        frame.setSize(768, 352);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null); // ??

        JLabel label = new JLabel("Send Message:");
        label.setBounds(10, 20, 120, 25); //x, w, h, y  (KKKKKKKKKKK)
        panel.add(label);

        JTextField userText = new JTextField("caio is legal", 30);   
        userText.setBounds(140, 20, 305, 25);
        userText.setVisible(true);
        panel.add(userText);

        msgLabel = new JLabel(":");
        msgLabel.setVerticalAlignment(JLabel.TOP);
        msgLabel.setBounds(10, 100, 600, 200);
        panel.add(msgLabel);   
        
        JButton send = new JButton("Send");
        send.setBounds(10, 60, 80, 25);
        send.setVisible(true);
        send.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                netObj.lastInput = userText.getText();
            }
        });
        panel.add(send);
        

        frame.setVisible(true);
    }

    public void pushMsg(String txt)
    {
        msgs.add(txt);

        String str = "<html>";
        
        for (int i = 0;i < msgs.size();i ++)
        {
            str += msgs.get(i) + "<br>";
        }

        str += "</html>";
        msgLabel.setText(str);
    }
}


































