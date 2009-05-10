package com.dendrytdev.org.client.problemOverview;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.dendrytdev.org.client.bean.Problem;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * ProblemOverview composite
 * gives client opportunity to search for dendryt-Problems
 * @author michal
 *
 */
public class ProblemOverview extends Composite {
	
	
	void blankAllFields(){
		final String EMPTY = "";
		
		// initialize textboxes
		_productTextBox.setText(EMPTY);
		_firstNameTextBox.setText(EMPTY);
		_surnameTextBox.setText(EMPTY);
		_phoneTextBox.setText(EMPTY);
		_ratioTextBox.setText(EMPTY);
		_dateTextBox.setText(EMPTY);

		_servicemanTextBox.setText(EMPTY);
		_designerTextBox.setText(EMPTY);
		_programmerTextBox.setText(EMPTY);
		_testerTextBox.setText(EMPTY);
		
		_textArea.setText(EMPTY);
		
		//_suggestBox.setText(EMPTY);
		
	}
	ListBox _listBox;
	
	
	// fields connected with PRODUCT
	TextBox _productTextBox;
	TextBox _firstNameTextBox;
	TextBox _surnameTextBox;
	TextBox _phoneTextBox;
	TextBox _ratioTextBox;
	TextBox _dateTextBox;
	
	// fields connected with ASSIGNMENT
	TextBox _servicemanTextBox;
	TextBox _designerTextBox;
	TextBox _programmerTextBox;
	TextBox _testerTextBox;
	
	TextArea _textArea;
	
	SuggestBox _suggestBox;
	
	Button _assignmentButton;
	Button _refreshListButton;

	public ProblemOverview() {
		// initialize listBox
		_listBox = new ListBox();
		
		_listBox.setSize("250", "300");
		_listBox.setVisibleItemCount(5);
		
		
		// initialize textboxes
		_productTextBox = new TextBox();
		_firstNameTextBox = new TextBox();
		_surnameTextBox = new TextBox();
		_phoneTextBox = new TextBox();
		_ratioTextBox = new TextBox();
		_dateTextBox = new TextBox();

		_servicemanTextBox = new TextBox();
		_designerTextBox = new TextBox();
		_programmerTextBox = new TextBox();
		_testerTextBox = new TextBox();
		
		
		_textArea = new TextArea();
		
		_suggestBox = new SuggestBox();
		
		// initialize buttons
		_assignmentButton = new Button("Przydziel pracownikow");
		
		_refreshListButton = new Button("Odswiez liste", new ClickListener(){
			@Override
			public void onClick(Widget sender) {
				// TODO Auto-generated method stub
				
			}
		});

		
		
		//////////////////////////// TODO: testing purposes ONLY
		fillForTest();
		
		//////////////////////// TODO: testing purposes ONLY
		
		HorizontalPanel mainPanel = new HorizontalPanel();
		initWidget(mainPanel);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		mainPanel.setWidth("500");

		/////////////////////////////////////////////////////////
		//wrapp by decorator LEFT Panel and add it to the mainPanel
		DecoratorPanel leftWrapper = new DecoratorPanel();
		Panel leftPanel = generateLeftVerticalPanel(); // creating leftPanel HERE
		leftWrapper.setWidget(leftPanel);
		leftWrapper.setHeight("400");
		mainPanel.add(leftWrapper);
		
		/////////////////////////////////////////////////////////
		//create RIGHT Panel
		VerticalPanel rightVerticalPanel = new VerticalPanel();
		mainPanel.add(rightVerticalPanel);

		//add labels with textboxes on up of RIGHT Panel
		rightVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		DecoratorPanel rightWrapper = new DecoratorPanel();
		rightWrapper.setWidget(generatePropertiesFieldsPanel()); // creating Properties panel HERE
		rightWrapper.setHeight("200");
		rightVerticalPanel.add(rightWrapper);

		// add to RIGHT Panel new RightDown panel with assignment and description
		Panel rightDownPanel = generateRightDownPanel();
		rightDownPanel.setHeight("200");
		rightVerticalPanel.add(rightDownPanel);
		
		
		
		
		
		/////////////////////////////////////////////////////////
		//create RIGHT RIGHT ;) Panel
		
		VerticalPanel descriptionPanel = new VerticalPanel();
		descriptionPanel.add(new Label("OPIS PROBLEMU"));
		
		// generate description text area here
		
	    _textArea.setCharacterWidth(50);
	    _textArea.setVisibleLines(20);

		descriptionPanel.add(_textArea);
		
		DecoratorPanel descriptionWrapper = new DecoratorPanel();
		descriptionWrapper.setWidget(descriptionPanel);
		descriptionWrapper.setHeight("400");
		mainPanel.add(descriptionWrapper);
		
		
		
		

	}

	Panel generateRightDownPanel() {

		VerticalPanel assignmentPanel = new VerticalPanel();
		assignmentPanel.add(new Label("PRZYDZIAL"));
		assignmentPanel.add(generateAssignmentFieldsPanel()); //creating ASSIGNMENT panel HERE
		assignmentPanel.add(_assignmentButton);
		
		DecoratorPanel assignmentWrapper = new DecoratorPanel();
		assignmentWrapper.setWidget(assignmentPanel);
		return assignmentWrapper;
	}
	
	
	
	VerticalPanel generateLeftVerticalPanel(){
		VerticalPanel leftVerticalPanel = new VerticalPanel();
		leftVerticalPanel.add(new Label("LISTA PROBLEMOW"));

		leftVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		

		AbsolutePanel absolutePanel = new AbsolutePanel();
		leftVerticalPanel.add(absolutePanel);
		absolutePanel.setSize("250", "300");
		
		absolutePanel.add(_listBox);

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		leftVerticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("200");

		Label label = new Label("Wyszukaj:");
		horizontalPanel_1.add(label);
		horizontalPanel_1.add(_suggestBox);
		_suggestBox.setWidth("120");
		
		leftVerticalPanel.add(_refreshListButton);
		
		return leftVerticalPanel;
	}
	
	
	

	/**
	 * 
	 * DAMN DAMN DAMN!!!
	 * Workaround used to extract method from addProblemPropertiesFields()-method
	 * and still work with instantine-GWT plugin
	 * 
	 * all other tries to do it in simply way failed.
	 * I tried to extract non-static method in ProblemOverview - failed.
	 * I tried to extract static method in ProblemOverview - failed.
	 * 
	 * Obviously it worked normally (when executing application) but
	 * DESIGN-mode in instantine-GWT plugin blowed up (DAMN!)
	 * @author michal
	 *
	 */
	static class StaticHelperClass{
		static String width;
		static void setWidth(String s){
			width = s;			
		}
		/**
		 * Just pass the label name and textBox reference and the method
		 * create horizontal panel with it 
		 * @param labelName
		 * @param textBox - should be already initialized (member of the class)
		 * @return
		 */
		static HorizontalPanel generateLabeledTextBoxPanel(String labelName, TextBox textBox){
			HorizontalPanel horizontalPane = new HorizontalPanel();
			Label l = new Label(labelName);
			l.setWidth(width);
			horizontalPane.add(l);
			horizontalPane.add(textBox);		
			return horizontalPane;
		}		
	}
	
	
	/**
	 * Generates a set of horizontal panels with labels and textboxes.
	 * All it is connected with content of Problem-bean	 * 
	 * @param panel - panel to which it adds this hPanels
	 */
	VerticalPanel generatePropertiesFieldsPanel() {
		VerticalPanel panel = new VerticalPanel();
		StaticHelperClass.setWidth("200");
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Produkt:", _productTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Imie zglaszajacego:", _firstNameTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Nazwisko zglaszajacego:", _surnameTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Telefon zglaszajacego:", _phoneTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Waga zglaszajacego:", _ratioTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Data zgloszenia:", _dateTextBox));
		return panel;
	}
		
	
	VerticalPanel generateAssignmentFieldsPanel() {
		VerticalPanel panel = new VerticalPanel();
		StaticHelperClass.setWidth("200");
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Serwisant:", _servicemanTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Projektant:", _designerTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Programista:", _programmerTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Tester:", _testerTextBox));
		return panel;
	}
	
	
	public void updateOfProblemList(List<Problem> problemList){
		_listBox.clear();
//		_listBox.addItem("SSS");
		_listBox.addItem("SSS");

		blankAllFields();
		
	}
	
	
	void fillForTest(){
		List<Problem> list = new ArrayList<Problem>();
		Problem p = new Problem();
//		p.setDataZgloszenia(Calendar.getInstance().getTime());
		p.setImieZglaszajacego("IMIE");
		p.setNazwiskoZglaszajacego("NAZWISKO");
		updateOfProblemList(null); 
	}
}
