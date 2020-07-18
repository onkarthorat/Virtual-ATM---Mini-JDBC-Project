import javax.swing.*;
import database.seq;
import java.awt.*;
import java.awt.event.*;


class MyLabel extends JLabel
{
	MyLabel(String s)
	{
		this.setText("<html><div style='text-align: left;'>" + s + "</div></html>");
		Dimension d = new Dimension(350, 50);
    		this.setPreferredSize(d);
        		this.setMaximumSize(d);
        	this.setMinimumSize(d);
	}}

class MyTextField extends JTextField
{
	MyTextField()
	{
		Dimension d = new Dimension(350, 50);
    	this.setPreferredSize(d);
        this.setMaximumSize(d);
        this.setMinimumSize(d);
	}
}

class MyPanel extends JPanel
{
	MyPanel()
	{
		final int inf = (int) 1e9;
		Dimension d = new Dimension(350, inf);
	    this.setPreferredSize(d);
	    this.setMaximumSize(d);
	    this.setMinimumSize(d);
	}
}

class MyPasswordField extends JPasswordField
{
	MyPasswordField()
	{
		final int inf = (int) 1e9;
		Dimension d = new Dimension(350, 50);
	    this.setPreferredSize(d);
	    this.setMaximumSize(d);
	    this.setMinimumSize(d);
	}
}
public class First extends seq {
	
	static JFrame f;
	static MyPanel base;
	static MyPanel p2;
	static void updateFrame(MyPanel panel)
	{
		f.getContentPane().removeAll();
		f.repaint();
		base.removeAll();
		base.add(panel);
		base.add(p2);
		f.getContentPane().add(base);
		f.validate();
	}
	public void Firs() throws Exception {
		f = new JFrame("Virtual ATM");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base = new MyPanel();
		base.setLayout(new BoxLayout(base, BoxLayout.X_AXIS));
	MyPanel home = new MyPanel();
	p2 = new MyPanel();
    BoxLayout boxlayout = new BoxLayout(p2, BoxLayout.Y_AXIS); 
    p2.setLayout(boxlayout);
	MyLabel la = new MyLabel("HOW CAN WE HELP YOU?");
	JButton b1 = new JButton("WITHDRAWAL");
	JButton b2 = new JButton("DEPOSIT");
	JButton b3 = new JButton("BALANCE ENQUIRY");
	JButton b4 = new JButton("CHANGE PIN");
	JButton b5 = new JButton("TRANSFER");
	JButton b6 = new JButton("EXIT");
	p2.add(la);
	p2.add(b1);
	p2.add(b2);
	p2.add(b3);
	p2.add(b4);
	p2.add(b5);
	p2.add(b6);
	MyPanel p3 = new MyPanel();
	p3.setLayout(null);
	MyPanel p4 = new MyPanel();
	p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
	p4.setLayout(null);
	home.setLayout(null);
	MyLabel l1= new MyLabel("Hello");
	MyLabel l2 = new MyLabel("Welcome to Virtual Bank");
	l1.setForeground(Color.WHITE);
	l2.setForeground(Color.WHITE);
	//l1.setHorizontalAlignment(JLabel.CENTER);
	l1.setBounds(250,0,50,50);
	l2.setBounds(200,15,200,50);
	home.add(l1);
	home.add(l2);
	MyLabel l3 = new MyLabel("Enter PIN");
	MyLabel l4 = new MyLabel("Enter card number");
	l3.setForeground(Color.WHITE);
	l4.setForeground(Color.WHITE);
	l4.setBounds(100,80,250,30);
	l3.setBounds(100,120,100,30);
	home.add(l3);
	home.add(l4);
	MyTextField t1 = new MyTextField();
	t1.setBounds(270,80,200,30);
	MyPasswordField p = new MyPasswordField();
	p.setBounds(270,120,200,30);
	JButton b = new JButton("Proceed");
	b.setBounds(225,180,100,40);
	b.setForeground(Color.BLUE);
	b.setBackground(Color.YELLOW);
	home.add(b);
	home.add(t1);
	home.add(p);
	f.getContentPane().add(home);
	float conver[] = new float[3];
	conver = Color.RGBtoHSB(138, 0, 30, null);
	float convers[] = new float[3];
	convers = Color.RGBtoHSB(239, 200, 208, null);
	home.setBackground(Color.getHSBColor(conver[0], conver[1], conver[2]));
	p2.setBackground(Color.getHSBColor(convers[0], convers[1], convers[2]));
	p3.setBackground(Color.getHSBColor(conver[0], conver[1], conver[2]));
	p4.setBackground(Color.getHSBColor(conver[0], conver[1], conver[2]));
	b.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent ae) {
			String getValue = t1.getText();
				char[] ping = p.getPassword();
				String ps = new String(ping);
				/*if(getValue=="" && ps == "")
				{
					JOptionPane.showMessageDialog(null, "Fields are empty");
				}
				*/
				boolean cond = false;
				try {
					cond = seq.getpin(getValue, ps);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					if(cond==true) {
				String na = "";
				try {
					na=seq.getn(getValue);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MyPanel welcome = new MyPanel();
				welcome.setLayout(null);
				MyLabel welcome_message = new MyLabel("Hello, " +na+ "!"); 
				MyLabel option = new MyLabel("Please select an option from right");
				welcome_message.setForeground(Color.WHITE);
				welcome_message.setBounds(115,75,300,80);
				option.setForeground(Color.WHITE);
				option.setBounds(60,105,300,100);
				welcome.add(welcome_message);
				welcome.add(option);
				float convertc[] = new float[3];
				convertc = Color.RGBtoHSB(138, 0, 30, null);
		welcome.setBackground(Color.getHSBColor(convertc[0], convertc[1], convertc[2]));
				float conve[] = new float[3];
				conve = Color.RGBtoHSB(138, 0, 30, null);
				b1.setBackground(Color.getHSBColor(conve[0], conve[1], conve[2]));
				b2.setBackground(Color.getHSBColor(conve[0], conve[1], conve[2]));
				b3.setBackground(Color.getHSBColor(conve[0], conve[1], conve[2]));
				b4.setBackground(Color.getHSBColor(conve[0], conve[1], conve[2]));
				b5.setBackground(Color.getHSBColor(conve[0], conve[1], conve[2]));
				b6.setBackground(Color.getHSBColor(conve[0], conve[1], conve[2]));
				
				b1.setOpaque(true);
				b2.setOpaque(true);
				b3.setOpaque(true);
				b4.setOpaque(true);
				b5.setOpaque(true);
				b6.setOpaque(true);

				updateFrame(welcome);
					
				/**
				 * this is the action listener for the exit button in p2 panel
				 * on the right
				 */
			b6.addActionListener(new ActionListener()
				{
						public void actionPerformed(ActionEvent aew)
				{
							f.getContentPane().removeAll();
							base.removeAll();
							f.repaint();
							f.getContentPane().add(home);
							f.validate();
							t1.setText("");
							p.setText("");
				}});
				b1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent aea)
					{
					MyLabel l = new MyLabel("Enter the amount to withdraw");
						l.setForeground(Color.WHITE);
						MyTextField wit = new MyTextField();
						JButton with = new JButton("Proceed");
						l.setBounds(10,25,250,50);
						wit.setBounds(10,100,250,40);
						with.setBounds(125,175,100,35);
						p3.removeAll();
						p3.add(l);
						p3.add(wit);
						p3.add(with);
						updateFrame(p3);
						with.addActionListener(new ActionListener() { 
							boolean co;
							public void actionPerformed(ActionEvent aeae)
							{
								String pro = wit.getText();
							try {
								co=	seq.getbal(getValue, pro);
							} catch (Exception e) {
								e.printStackTrace();
							}
								if(co==true)
								{
									float ba = 0;
									try {
										ba = seq.getb(getValue);
									} catch (Exception e) {
										e.printStackTrace();
									}
								float proc =Float.parseFloat(pro);
									float newb = ba-proc;
									try {
									seq.update(getValue, newb);
									} catch (Exception e) {
										e.printStackTrace();
									}
									
					MyLabel suc = new MyLabel("Transaction Successful!");
			MyLabel bal = new MyLabel("Available balance in your account is ₹"+newb);
				suc.setBounds(75,25,150,50);
				bal.setBounds(20,110,300,50);											suc.setForeground(Color.WHITE);										bal.setForeground(Color.WHITE);
						p4.removeAll();
						p4.add(suc);
						p4.add(bal);
						updateFrame(p4);
								}				
			else
				JOptionPane.showMessageDialog(null,"Balance Insufficient”);
							}});}});
				b2.addActionListener(new ActionListener()
						{
						public void actionPerformed(ActionEvent aeaea)
						{
					MyLabel l = new MyLabel("Enter the amount to deposit");
					MyTextField td = new MyTextField();
					JButton dep = new JButton("Proceed");
					l.setForeground(Color.WHITE);
					dep.setBounds(125,175,100,35);
					l.setBounds(10,25,250,50);
					td.setBounds(10,100,250,40);
					p3.removeAll();
					p3.add(l);
					p3.add(td);
					p3.add(dep);
					updateFrame(p3);
					dep.addActionListener(new ActionListener()
							{
						public void actionPerformed(ActionEvent aeaeae)
						{
							String depo = td.getText();	
							float ba = 0;
							try {
								ba = seq.getb(getValue);
							} catch (Exception e) {
								e.printStackTrace();
							}
							float depos = Float.parseFloat(depo);
							float newba = depos + ba;
							try {
								seq.update(getValue, newba);
							} catch (Exception e) {
								e.printStackTrace();
							}
							
					MyLabel suc = new MyLabel("Transaction Successful!");
		MyLabel bal = new MyLabel("Available balance in your account is ₹"+newba);
							suc.setBounds(75,25,150,50);
							bal.setBounds(20,110,300,50);
							suc.setForeground(Color.WHITE);
							bal.setForeground(Color.WHITE);
							p4.removeAll();
							p4.add(suc);
							p4.add(bal);
							updateFrame(p4);
				}});}});
				b3.addActionListener(new ActionListener()
						{
					public void actionPerformed(ActionEvent aeaeaeae)
					{
						float balan = 0;
						try {
							balan= seq.getb(getValue);
						} catch (Exception e) {
							e.printStackTrace();
						}
				MyLabel gb = new MyLabel("Balance in your account is ₹"+balan);
						gb.setForeground(Color.WHITE);
						gb.setBounds(50,100,250,100);
						p3.removeAll();
						p3.add(gb);
						updateFrame(p3);
					}});
				b4.addActionListener(new ActionListener()
						{
					public void actionPerformed(ActionEvent aeaeaee)
					{
						MyPasswordField te1 = new MyPasswordField();
						MyPasswordField te2 = new MyPasswordField();
						MyPasswordField te3 = new MyPasswordField();
						MyLabel le1 = new MyLabel("Enter current PIN");
						MyLabel le2 = new MyLabel("Enter new PIN");
						MyLabel le3 = new MyLabel("Enter new PIN again");
						JButton be = new JButton("Change PIN");
						le1.setForeground(Color.WHITE);
						le2.setForeground(Color.WHITE);
						le3.setForeground(Color.WHITE);
						le1.setBounds(10,5,150,40);
						le2.setBounds(10,95,150,40);
						le3.setBounds(10,185,150,40);
						te1.setBounds(10,50,150,40);
						te2.setBounds(10,140,150,40);
						te3.setBounds(10,230,150,40);
					be.setBounds(175,275,100,35);
						p3.removeAll();
						p3.add(le1);
						p3.add(te1);
						p3.add(le2);
						p3.add(te2);
						p3.add(le3);
						p3.add(te3);
						p3.add(be);
						updateFrame(p3);
						be.addActionListener(new ActionListener()
								{
						public void actionPerformed(ActionEvent aeaeaa)
							{
								String op = te1.getText();
								String nhome = te2.getText();
								String np2 = te3.getText();
								boolean pq = false;
								try {
									pq = seq.getpinw(getValue, op);
								} catch (Exception e) {
									e.printStackTrace();
								}
								if(pq==false)
								{
					JOptionPane.showMessageDialog(null, "Wrong PIN entered");
								}
								else
								{
									if(nhome.equals(np2))
									{
					MyLabel ld = new MyLabel("PIN changed succesfully!");
										ld.setBounds(100,100,300,100);										ld.setForeground(Color.WHITE);
p4.removeAll();
p4.add(ld);									
try {											seq.updatep(getValue, nhome);
} catch (Exception e) {									e.printStackTrace();
	}
	updateFrame(p4);
	}
	else 
	{
		JOptionPane.showMessageDialog(null, "New PINS do not match");
							}}}});}});
				b5.addActionListener(new ActionListener()
						{
					public void actionPerformed(ActionEvent aeaeaaa)
					{
			MyLabel l = new MyLabel("Enter the account number of beneficiary");
				l.setForeground(Color.WHITE);
				MyTextField t0 = new MyTextField();
				MyLabel l1 = new MyLabel("Enter the amount to transfer");
						l1.setForeground(Color.WHITE);
						MyTextField t6 = new MyTextField();
						JButton bt = new JButton("Proceed");
						l1.setBounds(5, 110, 260, 40);
						bt.setBounds(150, 210, 100, 35);
						l.setBounds(5, 10, 260, 40);
						t0.setBounds(5,50, 200, 40);
						t6.setBounds(5,145,200,40);
						p3.removeAll();
						p3.add(l);
						p3.add(t0);
						p3.add(l1);
						p3.add(t6);
						p3.add(bt);
						updateFrame(p3);
						bt.addActionListener(new ActionListener()
								{
						public void actionPerformed(ActionEvent aeaeea)
							{
								String st = t0.getText(); //ben acc_no
								String sa = t6.getText(); //amt
								boolean c = false;
							try {
								c=	seq.getbal(getValue, sa);
							} catch (Exception e) {
								e.printStackTrace();
							}
							if(c==true)
							{
								float oba = 0;
								try {
									oba = seq.getb(getValue);
								} catch (Exception e) {
									e.printStackTrace();
								}
								float bba = 0;
								try {
									bba = seq.getbb(st);
								} catch (Exception e) {
									e.printStackTrace();
								}
								if(bba == 0)							JOptionPane.showMessageDialog(null, "Account number does not exist");
								else
								{
									float sac = Float.parseFloat(sa);
									float newbo = oba -  sac;
									float newbb = bba +sac;
									try {
									seq.update(getValue, newbo);
									} catch (Exception e) {
										e.printStackTrace();
									}
									try {
										seq.updateu(st, newbb);
									} catch (Exception e) {
										e.printStackTrace();
									}
						MyLabel las = new MyLabel("Transaction Succesful!");
								las.setForeground(Color.WHITE);
		MyLabel las1 = new MyLabel("Available balance in your account is ₹"+newbo);
																las1.setForeground(Color.WHITE);										las.setBounds(75,25,150,50);
		las1.setBounds(20,110,300,50);
		p4.removeAll();
		p4.add(las);
		p4.add(las1);
		updateFrame(p4);
			}
				}else
			JOptionPane.showMessageDialog(null, "Insufficient Balance”);								}});}});}
					else if(getValue == "" || ps == "") {
		JOptionPane.showMessageDialog(null, "Incomplete or wrong data entered");
					}
					else
			JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
		
	}});
	f.setSize(550,350);
	f.setVisible(true); 
}}