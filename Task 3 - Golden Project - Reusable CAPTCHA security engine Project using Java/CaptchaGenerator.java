import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ReusableCaptcha extends JFrame {

	Container c;
	JLabel labtitle;
	JTextArea txt1;
	JTextField txtf1;
	JButton btnGenrate, btnEnter, btnClear;

	StringBuffer captcha = new StringBuffer();

	ReusableCaptcha() {
		c = getContentPane();
		c.setLayout(null);

		labtitle = new JLabel("Captcha Generator");
		txt1 = new JTextArea();
		txtf1 = new JTextField(30);
		btnGenrate = new JButton("Generate");
		btnEnter = new JButton("Enter");
		btnClear = new JButton("Clear");

		Font f = new Font("Arial", Font.BOLD, 30);
		labtitle.setFont(f);
		txt1.setFont(f);
		txtf1.setFont(f);
		btnGenrate.setFont(f);
		btnEnter.setFont(f);
		btnClear.setFont(f);

		labtitle.setBounds(250, 80, 600, 40);
		txt1.setBounds(200, 180, 100, 40);
		txtf1.setBounds(200, 260, 200, 40);
		btnGenrate.setBounds(400, 180, 170, 40);
		btnEnter.setBounds(200, 340, 170, 40);
		btnClear.setBounds(400, 340, 170, 40);

		txt1.setEditable(false);

		c.add(labtitle);
		c.add(txt1);
		c.add(txtf1);
		c.add(btnGenrate);
		c.add(btnEnter);
		c.add(btnClear);

		// Generate Captcha
		ActionListener a = (ae) -> {
			int len = 5;
			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			Random rnd = new Random();

			captcha.setLength(0);
			while (len > 0) {
				captcha.append(characters.charAt(rnd.nextInt(characters.length())));
				len--;
			}
			txt1.setText(captcha.toString());
		};

		// Verify Captcha
		ActionListener a2 = (ae) -> {
			String captchaString = captcha.toString();
			//JOptionPane.showMessageDialog(c, captchaString);

			String userData = txtf1.getText();
			if (captchaString.equals(userData)) {
				JOptionPane.showMessageDialog(c, "Captcha Successfully matched!");
			} else {
				JOptionPane.showMessageDialog(c, "Captcha Doesn't matched!");
			}
		};

		// Clear TextFields
		ActionListener a3 = (ae) -> {
			txt1.setText("");
			txtf1.setText("");
		};

		// onClick - Button
		btnGenrate.addActionListener(a);
		btnEnter.addActionListener(a2);
		btnClear.addActionListener(a3);

		setTitle("PASSWORD GANERATE APP");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class CaptchaGenerator {
	public static void main(String args[]) {
		ReusableCaptcha rc = new ReusableCaptcha();
	}
}