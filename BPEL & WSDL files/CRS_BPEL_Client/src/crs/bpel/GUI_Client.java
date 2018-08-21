/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs.bpel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




/**
 *
 * @author cmp7038User
 */
public class GUI_Client extends JFrame implements ActionListener{
    private JTextField usrIdTxt = new JTextField();
    private JTextField emailTxt = new JTextField();
    private JTextField nameTxt = new JTextField();
    private JTextField phoneTxt = new JTextField();
    private JTextField usrIdTxt2 = new JTextField();
    private JTextField locTxt = new JTextField();
	
    private JButton addUsrBtn = new JButton("Add Customer");
    private JButton bookCarBtn = new JButton("Book Car");
        
    public GUI_Client(){
        initialize();
    }
    
    public void initialize(){
        try{ 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex){                
        } 
		
		

	//setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/icons/icon.JPG")));
	setTitle("CRS Client");
		
	setSize(300, 200); 
        
        JPanel topPanel = new JPanel();
	topPanel.setLayout(new GridLayout(5,2));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        
        topPanel.add(new JLabel("User ID : "));
	topPanel.add(usrIdTxt);
	topPanel.add(new JLabel("Email : "));
	topPanel.add(emailTxt);
	topPanel.add(new JLabel("Name : "));
	topPanel.add(nameTxt);
	topPanel.add(new JLabel("Phone : "));
	topPanel.add(phoneTxt);
	topPanel.add(new JLabel("         "));
	topPanel.add(addUsrBtn);
        
        addUsrBtn.addActionListener(this);
        
        
        JPanel bottomPanel = new JPanel();
	bottomPanel.setLayout(new GridLayout(3,2));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));        
        
        bottomPanel.add(new JLabel("User ID : "));
        bottomPanel.add(usrIdTxt2);
        bottomPanel.add(new JLabel("Location : "));
        bottomPanel.add(locTxt);
        bottomPanel.add(new JLabel("           "));
        bottomPanel.add(bookCarBtn);        
        bookCarBtn.addActionListener(this);
       
	this.getContentPane().add(topPanel, BorderLayout.CENTER);
	this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		
	setVisible(true);		            
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addUsrBtn){

            JOptionPane.showMessageDialog(this, "No Code To Call Customer Registry");
        }
        else if(ae.getSource() == bookCarBtn){
            JOptionPane.showMessageDialog(this, "No Code To Call Car Registry");
        } 
    }
    
    public static void main(String[] args){
        new GUI_Client();
    }
}
