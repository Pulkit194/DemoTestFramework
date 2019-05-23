package com.testFramework.locators;

public class Locators {

	// ================================================== Locators for Menu
	public enum Menu {
		INPUTFORM("//*[@class='dropdown-toggle' and contains(text(), 'Input Forms')]"), 
		DATEPICKER("//*[@class='dropdown-toggle' and contains(text(), 'Date pickers')]"), 
		TABLE("//*[@class='dropdown-toggle' and contains(text(), 'Table')]"),
		ALERTSMODALS("//li[@class='dropdown']/a[contains(text(), 'Alerts & Modal')]");
		public String value;

		private Menu(String value) {
			this.value = value;
		}

	}

	// =================================================== Locators for Input
	// Form->DropdownOptions
	public enum InputForm {
		SELECTDROPDOWN("//*[@class='dropdown-menu']//a[contains(text(),'Select Dropdown List' )]");

		public String value;

		private InputForm(String value) {
			this.value = value;
		}
	}

	// ================================================= Locators for
	// InputForm->DropdownOptions->Lists
	public enum SelectListDemo {
		SELECTLISTDEMO("//*[@id='select-demo']"),
		DAYSSELECTED("//*[@class='selected-value']");
		
		public String value;

		private SelectListDemo(String value) {
			this.value = value;
		}

	}

	public enum SelectMultipleList {
		SELECTMULTIPLELIST("//*[@name='States']"),
		GETALLSELECTED("//button[@type='button' and contains(text(),'Get All Selected')]"),
		OPTIONSSELECTED("//p[@class='getall-selected' and contains(text(),'Options selected are :')]");
		
		public String value;

		private SelectMultipleList(String value) {
			this.value = value;
		}

	}
	
	public enum alertModalsDropdown{
		JAVASCRIPTALERTS("//*[@class='dropdown-menu']/li/a[contains(text(), 'Javascript Alerts')]"),
		ALERTBOX("//*[@class='panel-body']/p[contains(text(), 'alert box:')]/following-sibling::button[@class='btn btn-default']"),		
		JAVASCRIPTCONFIRMMECLICKME("//*[@class='panel-body']/b[contains(text(), 'confirm box:')]/following-sibling::button[@class='btn btn-default btn-lg']"),
		JAVASCRIPTSENDKEYS("//*[@class='panel-body']/b[contains(text(), 'prompt box.')]/following-sibling::button[@class='btn btn-default btn-lg']"),
		BOOTSTRAPMODALS("//*[@class='dropdown-menu']//a[contains(text(),'Bootstrap Modals' )]"),
		SINGLEMODALLAUNCH("//*[@class='panel-heading' and contains(text(), 'Single Modal Example')]/following-sibling::div/a"),
		CLICKSINGLECLOSE("//*[@id='myModal0']//a[contains(text(),'Close')]");
		public String value;

		private alertModalsDropdown(String value) {
			this.value = value;
		}

	}
	

}
