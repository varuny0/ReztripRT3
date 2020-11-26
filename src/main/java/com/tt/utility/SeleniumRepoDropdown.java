package com.tt.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SeleniumRepoDropdown {

	
	/**
	 * @author somasish
	 * @param locator
	 * @param value
	 * Method to Select a value from a dropdown
	 */
	public static boolean selectDropDownValue(WebElement element, String value) {
		try {

			if (element != null) {
				Select selectBox = new Select(element);
				selectBox.selectByValue(value);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	public static boolean selectDropDownText(WebElement element, String value) {
		try {

			if (element != null) {
				Select selectBox = new Select(element);
				selectBox.selectByVisibleText(value);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	
	
	public static boolean selectDropDrownByIndex(String locator, int Index) {
		try {

			if (locator != null) {
			
				WebElement DropdownElement = SeleniumRepo.findElement(locator);
				Select SelectIndex = new Select(DropdownElement);
				SelectIndex.selectByIndex(Index);
			}
			return false;
		} catch (Exception e) {
			System.out
					.println(" Error occured while selecting the option in the select box *"
							+ locator + " ***" + e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * This method is for selecting items present in a selection multi list box  
	 * @author DM
	 * @param element
	 * @param options
	 */
	public static void selectMultiListbox(WebElement element, String options[] ){
		
		try {

			if (element != null) {
				Select selectBox = new Select(element);
				
				//Create a for loop that will loop through all the options in the sting 
				
				for(int i= 0; i<options.length; i++){
					System.out.println("currency:  " + options[i] );
						selectBox.selectByVisibleText(options[i]) ;
				
				}
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
