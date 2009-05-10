package com.dendrytdev.org.client.problemOverview;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;

public class ProblemOverview extends Composite {
	TextBox _produktTextBox;
	TextBox _firstNameTextBox;
	TextBox _surnameTextBox;
	TextBox _phoneTextBox;
	TextBox _ratioTextBox;
	TextBox _dateTextBox;

	public ProblemOverview() {
		_produktTextBox = new TextBox();
		_firstNameTextBox = new TextBox();
		_surnameTextBox = new TextBox();
		_phoneTextBox = new TextBox();
		_ratioTextBox = new TextBox();
		_dateTextBox = new TextBox();
		
		{
			HorizontalPanel horizontalPanel = new HorizontalPanel();
			initWidget(horizontalPanel);
			{
				VerticalPanel verticalPanel = new VerticalPanel();
				horizontalPanel.add(verticalPanel);
				verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				{
					
					AbsolutePanel absolutePanel = new AbsolutePanel();
					verticalPanel.add(absolutePanel);
					absolutePanel.setSize("200", "320");
					ListBox listBox = new ListBox();
					absolutePanel.add(listBox);
					listBox.setSize("200", "300");
					listBox.setVisibleItemCount(5);
					
					HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
					verticalPanel.add(horizontalPanel_1);
					horizontalPanel_1.setWidth("200");
					
					Label label = new Label("Wyszukaj:");
					horizontalPanel_1.add(label);
					SuggestBox suggestBox = new SuggestBox();
					horizontalPanel_1.add(suggestBox);
					suggestBox.setWidth("120");
				}
			}
			{
				VerticalPanel verticalPanel = new VerticalPanel();
				horizontalPanel.add(verticalPanel);
				verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				
				addProblemPropertiesFields(verticalPanel);
			}
		}
	}

	
	
	static void addProblemPropertyField(VerticalPanel panel, String labelName, TextBox textBox){
		HorizontalPanel horizontalPane = new HorizontalPanel();
		horizontalPane.add(new Label(labelName));
		horizontalPane.add(textBox);		
		panel.add(horizontalPane);
	}

	class C{
		String labelName;
		TextBox textBox;
		public C(String s, TextBox t){
			labelName = s;
			textBox = t;
		}
	}
	
	static void addProblemPropertyField(VerticalPanel panel, C c){
		addProblemPropertyField(panel, c.labelName, c.textBox);
	}
	
	void addProblemPropertiesFields(VerticalPanel panel) {
		C[] cArr = new C[6];
		cArr[0] = new C("Produkt:", _produktTextBox);
		cArr[1] = new C("Imie zglaszajacego:", _firstNameTextBox);
		cArr[2] = new C("Nazwisko zglaszajacego:", _surnameTextBox);
		cArr[3] = new C("Telefon zglaszajacego:", _phoneTextBox);
		cArr[4] = new C("Waga zglaszajacego:", _ratioTextBox);
		cArr[5] = new C("Data zgloszenia:", _dateTextBox);
		
		// this is not working even i this fucking clear way KURWA!!!
		// fucked buged designer plugin
		addProblemPropertyField(panel, cArr[0]);
		
//		addProblemPropertyField(panel, "Produkt:", _produktTextBox);
//		addProblemPropertyField(panel, "Imie zglaszajacego:", _firstNameTextBox);
//		addProblemPropertyField(panel, "Nazwisko zglaszajacego:", _surnameTextBox);
//		addProblemPropertyField(panel, "Telefon zglaszajacego:", _phoneTextBox);
//		addProblemPropertyField(panel, "Waga zglaszajacego:", _ratioTextBox);
//		addProblemPropertyField(panel, "Data zgloszenia:", _dateTextBox);
	}
	
	

}
