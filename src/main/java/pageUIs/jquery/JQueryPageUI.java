package pageUIs.jquery;

public class JQueryPageUI {
	public static final String INPUT_CELL ="xpath=//tr[contains(@id,'Row_%s')]/td/input[contains(@name,'%s')]";
	
	//Data Grid
	public static final String HEADER_TEXTBOX = "xpath=//div[text()='%s']/../following-sibling::input";
	public static final String ROW_VALUE = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']/..";
	public static final String ACTION_ICON_BY_COUNTRY_NAME="xpath=//td[text()='%s']/preceding-sibling::td/button[contains(@class,'%s')]";
	public static final String PAGE_NUMBER_LINK = "xpath=//a[text()='%s']";
	public static final String ACTIVE_PAGE_NUMBER_LINK = "xpath=//a[text()='%s' and contains(@class, 'active')]";
	
	//Upload
	public static final String UPLOAD_FILE_BUTTON = "xpath=//input[@type='file']";
	public static final String START_BUTTON = "xpath=//span[text()='Start']";
	public static final String FILE_NAME_UPLOADED = "xpath=//p[text()='%s']";
	

}