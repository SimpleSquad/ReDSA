package UserView;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RealEstate {

	///////////////////////////////////
	private JFrame frmRealestate;
	private  JTextField txtLotNo;
	private  JTextField txtFname;
	private  JTextField txtLname;
	private  JTextField txtPrice;
	private  JTextField txtsqfeet;
	private  JTextField txtNoOfBR;
	///////////////////////////////////
	
	// to clear textboxes
	private  void clearData()
	  {
		  txtLotNo.setText("");
		  txtFname.setText("");                    
		  txtLname.setText("");                    
		  txtPrice.setText("");                    
		  txtsqfeet.setText("");
		  txtNoOfBR.setText("");
	  }

          // methord use to send data to the text boxes
		private  void dataViewer(ListHouse house)
	  {
		  txtLotNo.setText(Integer.toString(house.lotNumber()));
		  txtFname.setText(house.firstName());                    
		  txtLname.setText(house.lastName());                    
		  txtPrice.setText(Integer.toString(house.price()));                    
		  txtsqfeet.setText(Integer.toString(house.squareFeet()));
		  txtNoOfBR.setText(Integer.toString(house.bedRooms()));
	  }
	
	//methord we use to get data from the textboxes
		 private  ListHouse dataRetriver()
	  {
	    String lastName;
	    String firstName;
	    int lotNumber;
	    int price;
	    int squareFeet;
	    int bedRooms;

	    lotNumber = Integer.parseInt(txtLotNo.getText());
	    firstName = txtFname.getText();                    
	    lastName = txtLname.getText();                    
	    price = Integer.parseInt(txtPrice.getText()); 
	    squareFeet = Integer.parseInt(txtsqfeet.getText());
	    bedRooms = Integer.parseInt(txtNoOfBR.getText());

	    ListHouse house = new ListHouse(lastName, firstName, lotNumber, price, 
	                                    squareFeet, bedRooms);
	    return house;
	  }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
								try {					
					RealEstate window = new RealEstate();
					window.frmRealestate.setVisible(true);				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getStarted()
	{// Load info from house file into list
    // If possible insert info about first house into text fields
		 try {   
				ListHouse house;
				HouseFile.checkAvailability();
				HouseFile.startRead();
			  
			    while (HouseFile.isMore())
			    {
			      house = HouseFile.getNextHouse();
			      list.insert(house); //start of items gets ++
			      
			    }			   
			    list.reset();
			    if (list.lengthIs() != 0)
			    { 
			      house = (ListHouse)list.getNextItem();
			      dataViewer(house);
			    } 	
		} catch (Exception e) {
		
		}
	}
		
	
	public RealEstate() {
		initialize();
		getStarted();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRealestate = new JFrame();
		frmRealestate.setTitle("RealEstate");		
	
		frmRealestate.setBounds(100, 100, 335, 445);
		frmRealestate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRealestate.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 319, 73);
		frmRealestate.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblstat = new JLabel("");
		lblstat.setHorizontalAlignment(SwingConstants.CENTER);
		lblstat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblstat.setBounds(10, 11, 299, 59);
		panel.add(lblstat);
		
		JLabel lbltime = new JLabel("");
		lbltime.setBounds(140, 11, 138, 59);
		panel.add(lbltime);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(106, 71, 213, 252);
		frmRealestate.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtLotNo = new JTextField();
		txtLotNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||(c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE))) 
			      {
			      Toolkit.getDefaultToolkit().beep();
			        e.consume();
			        lblstat.setText("You Can Only Type Numbers In This Field");
			      }else{
			    	  lblstat.setText(" ");
			      }
				
				}
		});
		txtLotNo.setBounds(10, 11, 193, 29);
		panel_1.add(txtLotNo);
		txtLotNo.setColumns(10);
		
		txtFname = new JTextField();
		txtFname.setColumns(10);
		txtFname.setBounds(10, 51, 193, 29);
		panel_1.add(txtFname);
		
		txtLname = new JTextField();
		txtLname.setColumns(10);
		txtLname.setBounds(10, 91, 193, 29);
		panel_1.add(txtLname);
		
		txtPrice = new JTextField();
		txtPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||(c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE))) 
			      {
			      Toolkit.getDefaultToolkit().beep();
			        e.consume();
			        lblstat.setText("You Can Only Type Numbers In This Field");
			      }else{
			    	  lblstat.setText(" ");
			      }
				
			}
		});
		txtPrice.setColumns(10);
		txtPrice.setBounds(10, 131, 193, 29);
		panel_1.add(txtPrice);
		
		txtsqfeet = new JTextField();
		txtsqfeet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||(c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE))) 
			      {
			      Toolkit.getDefaultToolkit().beep();
			        e.consume();
			        lblstat.setText("You Can Only Type Numbers In This Field");
			      }else{
			    	  lblstat.setText(" ");
			      }
				
			}
		});
		txtsqfeet.setColumns(10);
		txtsqfeet.setBounds(10, 171, 193, 29);
		panel_1.add(txtsqfeet);
		
		txtNoOfBR = new JTextField();
		txtNoOfBR.setColumns(10);
		txtNoOfBR.setBounds(10, 211, 193, 29);
		panel_1.add(txtNoOfBR);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 71, 106, 252);
		frmRealestate.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLotno = new JLabel("Lot Number");
		lblLotno.setBounds(14, 8, 150, 32);
		panel_2.add(lblLotno);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(14, 48, 150, 32);
		panel_2.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(14, 88, 150, 32);
		panel_2.add(lblLastName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(14, 128, 150, 32);
		panel_2.add(lblPrice);
		
		JLabel lblSquareFeet = new JLabel("Square Feet");
		lblSquareFeet.setBounds(14, 168, 150, 32);
		panel_2.add(lblSquareFeet);
		
		JLabel lblNoOfBed = new JLabel("No Of Bed Rooms");
		lblNoOfBed.setBounds(14, 208, 150, 32);
		panel_2.add(lblNoOfBed);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 317, 319, 98);
		frmRealestate.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		btnNewButton.setBounds(0, 11, 105, 39);
		panel_3.add(btnNewButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdd.setBounds(106, 11, 105, 39);
		panel_3.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 clearData();
				 lblstat.setText(list.lengthIs() + " houses on list");
			}
		});
		btnClear.setBounds(0, 49, 105, 39);
		panel_3.add(btnClear);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFind.setBounds(106, 49, 105, 39);
		panel_3.add(btnFind);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(212, 11, 105, 39);
		panel_3.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(212, 49, 105, 39);
		panel_3.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

	}
}

}
