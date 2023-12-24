import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PasswordG extends JFrame
{	
	
	Container c;
	JLabel labtitle;
	JTextArea txtareapass;
	JCheckBox cb1, cb2, cb3, cb4;
	JButton btnEnter,btnClear;
	
	PasswordG() {
		c = getContentPane();
		c.setLayout(null);

		labtitle = new JLabel("CREATE STRONG PASSWORD");
		cb1 = new JCheckBox("6 letter");
		cb2 = new JCheckBox("8 letter");
		cb3 = new JCheckBox("10 letter");
		cb4 = new JCheckBox("12 letter");
		txtareapass = new JTextArea("Generated Passwords :- \n");
		btnEnter = new JButton("Generate");
		btnClear = new JButton("Clear");

		Font f = new Font("Arial", Font.BOLD, 30);
		labtitle.setFont(f);
		cb1.setFont(f);
		cb2.setFont(f);
		cb3.setFont(f);
		cb4.setFont(f);
		txtareapass.setFont(f);
		btnEnter.setFont(f);
		btnClear.setFont(f);

		labtitle.setBounds(250, 80, 600, 40);
		cb1.setBounds(130, 180, 180, 40);
		cb2.setBounds(310, 180, 180, 40);
		cb3.setBounds(490, 180, 180, 40);
		cb4.setBounds(670, 180, 180, 40);
		txtareapass.setBounds(190, 280, 600, 300);
		btnEnter.setBounds(280, 600, 170, 40);
		btnClear.setBounds(510, 600, 170, 40);

		c.add(labtitle);
		c.add(cb1);
		c.add(cb2);
		c.add(cb3);
		c.add(cb4);
		c.add(txtareapass);
		c.add(btnEnter);
		c.add(btnClear);

		ActionListener a = (ae) -> {
    			int len = 0;

    			if (cb1.isSelected()) {
        			len = 6;
    			} else if (cb2.isSelected()) {
        			len = 8;
    			} else if (cb3.isSelected()) {
        			len = 10;
    			} else if (cb4.isSelected()) {
        			len = 12;
    			}

    			String validChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$^*_+=";
    			StringBuilder st = new StringBuilder();
    			Random rand = new Random();

    			for (int i = 0; i < 5; i++) {
        			st.setLength(0); // Clear the StringBuilder for a new password

        		while (len-- > 0) {
            			st.append(validChar.charAt(rand.nextInt(validChar.length())));
        		}

        		txtareapass.append(st.toString());
        		if (i < 4) {
            			txtareapass.append(" "); // Add a comma as a separator between passwords
        		}
    		}
    		txtareapass.append("\n"); // Add a new line after all passwords

	};
	btnEnter.addActionListener(a);

		ActionListener a2 = (ae) -> {
			
			txtareapass.setText("");
		}; 
		btnClear.addActionListener(a2);

		setTitle("PASSWORD GANERATE APP");
		setSize(1000, 800);
		setLocationRelativeTo(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class PG 
{
	public static void main(String args[])
	{
		PasswordG pg = new PasswordG();		
	}
}