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
import ListPkg.*;
import FileHandler.HouseFile;

//This is the interface that user see
public class RealEstate {

	 private  SortedList list = new SortedList();
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
				frmRealestate.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				 ListHouse house;
			        try 
			        {
			          // Store info from list into house file
			          HouseFile.startWriter();
			          list.reset();
			          int length = list.lengthIs();
			          for (int counter = 1; counter <= length; counter++)
			          {
			            house = (ListHouse)list.getNextItem();
			            HouseFile.writerToFile(house);
			          }
			          HouseFile.streamCloser();
			        }
			        catch (Exception e)
			        {
			          System.out.println("Issue in "+e); 
			                            
			        }
			        System.exit(0);                           // Quit the program
			      }
			}
		);
	
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
				 ListHouse house;
				 list.reset();
			        if (list.lengthIs() == 0)
			          clearData();
			        else
			        {
			          house = (ListHouse)list.getNextItem();
			          dataViewer(house);
			        }
			        lblstat.setText("List reset"); 
			}
		});
		btnNewButton.setBounds(0, 11, 105, 39);
		panel_3.add(btnNewButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 ListHouse house;		
				if(txtLotNo.getText().isEmpty())
					lblstat.setText("Please Enter The Lot Number");
				else if(txtFname.getText().isEmpty())
					lblstat.setText("Please Enter First Name ");
				else if(txtLname.getText().isEmpty())
					lblstat.setText("Please Enter Last Name");
				else if(txtPrice.getText().isEmpty())
					lblstat.setText("Please Enter The Price");
				else if(txtsqfeet.getText().isEmpty())
					lblstat.setText("Please Enter Squrefeet Amount");
				else if(txtNoOfBR.getText().isEmpty())
					lblstat.setText("Please Enter The No Of Bedrooms");
				else{
					 try
			        	{
			          	house = dataRetriver();
			          	if (list.availability(house))
			        	  lblstat.setText("Lot number already in use"); 
			          else
			          { 
			            list.insert(house);
			            lblstat.setText("House added to list"); 
			          }
			     	 //when adding a list item the current position will be null.
	                         //in order to prevent it after adding the first element we 
		                 //this will assign an memory location to the first node rather than a null
			          //insert methord the current position does not change
			          //to change it we use this
							 if((list.getCurrent() == null)&&(list.lengthIs()==1))
						 {					
					          list.reset();    
				              house = (ListHouse)list.getNextItem();

						 }					 
			         
			        }
			        catch (NumberFormatException d)
			        {
			          // text field info incorrectly formated
			        	lblstat.setText("You Can Only Type Numbers");
			        }
                            }

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
		                ListHouse house;
				 int lotNumber;
				 
				 if(txtLotNo.getText().isEmpty())
						lblstat.setText("Please Enter The Lot Number");				
					else{
				 
			        try
			        {
			          lotNumber = Integer.parseInt(txtLotNo.getText());
			          house = new ListHouse("", "", lotNumber, 0, 0, 0);
			          if (list.availability(house))
			          {
			            house = (ListHouse)list.Fetcher(house);
			            dataViewer(house);
			            lblstat.setText("House found"); 
			          }
			          else
			        	  lblstat.setText("House not found");
			        }
			        catch (NumberFormatException badHouseData)
			        {
			          // text field info incorrectly formated
			        	lblstat.setText("Number? " + badHouseData.getMessage());
			        } 
					}



			}
		});
		btnFind.setBounds(106, 49, 105, 39);
		panel_3.add(btnFind);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(212, 11, 105, 39);
		panel_3.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                                 ListHouse house;					
				 if(txtLotNo.getText().isEmpty())
						lblstat.setText("Please Enter The Lot Number");				
					else{				 
			        try
			        {
			          house = dataRetriver();
			          if (list.availability(house))
			          {
			            list.delete(house);
			            lblstat.setText("House deleted"); 
			          }
			          else
			        	  lblstat.setText("Lot number not on list"); 
			        }
			        catch (NumberFormatException badHouseData)
			        {
			          // text field info incorrectly formated
			        	lblstat.setText("Wrong format entered");
			        } 
			        clearData();
		             }


			}
		});
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(212, 49, 105, 39);
		panel_3.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if((list.lengthIs()==1) && list.getCurrent()==null)
				 {}//this is used to avoid error which happerns when clicking next when adding items to a empty list
				 //from the start and clicking next because the current position refers as null in the getNextItem()
				 else{
				 ListHouse house;
				 if (list.lengthIs() == 0)
					 lblstat.setText("list is empty!");
			        else
			          {
			          house = (ListHouse)list.getNextItem();
			          dataViewer(house);
			          lblstat.setText("Next house displayed");
			        } 

                             }

			}
		});

	}
}


