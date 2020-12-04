import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class HomePage {

	protected Shell shlCopperBeechTownhomes;
	private Text ageText;
	private Text nameText;
	private Text emailText;
	private Waitlist waitlist = new Waitlist();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HomePage window = new HomePage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCopperBeechTownhomes.open();
		shlCopperBeechTownhomes.layout();
		while (!shlCopperBeechTownhomes.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCopperBeechTownhomes = new Shell();
		shlCopperBeechTownhomes.setBackground(SWTResourceManager.getColor(255, 255, 255));
		shlCopperBeechTownhomes.setSize(450, 300);
		shlCopperBeechTownhomes.setText("Copper Beech ");
		
		Label lblNewLabel = new Label(shlCopperBeechTownhomes, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 20, SWT.NORMAL));
		lblNewLabel.setBounds(173, 50, 101, 35);
		lblNewLabel.setText("Waitlist");
		
		Label lblNewLabel_1 = new Label(shlCopperBeechTownhomes, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 20, SWT.NORMAL));
		lblNewLabel_1.setBounds(37, 50, 77, 25);
		lblNewLabel_1.setText("Register");
		
		Label nameLabel = new Label(shlCopperBeechTownhomes, SWT.NONE);
		nameLabel.setBounds(10, 81, 59, 14);
		nameLabel.setText("Name:");
		
		Label ageLabel = new Label(shlCopperBeechTownhomes, SWT.NONE);
		ageLabel.setBounds(10, 113, 59, 17);
		ageLabel.setText("Age: ");
		
		Label emailLabel = new Label(shlCopperBeechTownhomes, SWT.NONE);
		emailLabel.setBounds(10, 147, 59, 14);
		emailLabel.setText("Email:");
		
		Button renewCheckbox = new Button(shlCopperBeechTownhomes, SWT.CHECK);
		renewCheckbox.setBounds(10, 177, 120, 16);
		renewCheckbox.setText("Renewing Lease");
		
		Label listLabel = new Label(shlCopperBeechTownhomes, SWT.BORDER);
		listLabel.setBounds(155, 81, 270, 145);
		if(waitlist.isEmpty()) {
			listLabel.setText("Waitlist is empty, be the first to register!");
		}
		
		Label messageLabel = new Label(shlCopperBeechTownhomes, SWT.WRAP | SWT.CENTER);
		messageLabel.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 11, SWT.NORMAL));
		messageLabel.setBounds(10, 232, 415, 30);
		
		Button submitButton = new Button(shlCopperBeechTownhomes, SWT.NONE);
		submitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (ageText.getText().trim().length() != 0 && nameText.getText().trim().length() != 0 && emailText.getText().trim().length() != 0) {
					try {
						int age = Integer.parseInt(ageText.getText());
						String name = nameText.getText();
						String email =  emailText.getText();
						boolean renewed = renewCheckbox.getSelection();
						
						//Creates a new customer and adds it to the waitlist
						Customer customer = new Customer(name, age, email, renewed);
						waitlist.insert(nameText.getText(), customer);
						
						//Create the label that will display the customers on the waitlist
						listLabel.setText(waitlist.printQueue());
						
						//Sends a message when each customer is added
						messageLabel.setText("Thank you for registering, you will receive an email when there is an apartment available to you!");
						messageLabel.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 12, SWT.NORMAL));
						//Clears the input boxes
						nameText.setText("");
						ageText.setText("");
						emailText.setText("");
						renewCheckbox.setSelection(false);
					} catch(NumberFormatException exception) {
						messageLabel.setText("Please only enter numbers in the age input field");
						messageLabel.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 19, SWT.NORMAL));
					}
					
				}else {
					messageLabel.setText("Please enter input for all fields");
					messageLabel.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 19, SWT.NORMAL));
				}
				
				
			}
		});
		submitButton.setBounds(18, 199, 96, 27);
		submitButton.setText("Submit");
		
		ageText = new Text(shlCopperBeechTownhomes, SWT.BORDER);
		ageText.setBounds(47, 113, 64, 19);
		
		nameText = new Text(shlCopperBeechTownhomes, SWT.BORDER);
		nameText.setBounds(47, 81, 64, 19);
		
		emailText = new Text(shlCopperBeechTownhomes, SWT.BORDER);
		emailText.setBounds(47, 147, 64, 19);
		
		
		Label welcomeLabel = new Label(shlCopperBeechTownhomes, SWT.WRAP);
		welcomeLabel.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 14, SWT.NORMAL));
		welcomeLabel.setAlignment(SWT.CENTER);
		welcomeLabel.setBounds(10, 10, 430, 49);
		welcomeLabel.setText("Sorry, we don't have any available apartments right now. Please enter the information below and we will add you to the waitlist. ");
	}
}
