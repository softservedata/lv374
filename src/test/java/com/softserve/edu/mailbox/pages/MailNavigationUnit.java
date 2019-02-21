package com.softserve.edu.mailbox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.mailbox.pages.boxes.AttachedLettersPage;
import com.softserve.edu.mailbox.pages.boxes.DeletedLettersPage;
import com.softserve.edu.mailbox.pages.boxes.DraftLettersPage;
import com.softserve.edu.mailbox.pages.boxes.IncomesLettersPage;
import com.softserve.edu.mailbox.pages.boxes.MarkedLettersPage;
import com.softserve.edu.mailbox.pages.boxes.SentLettersPage;
import com.softserve.edu.mailbox.pages.boxes.SpamLettersPage;
import com.softserve.edu.mailbox.pages.boxes.UnreadLettersPage;

public abstract class MailNavigationUnit extends MailHeadUnit {

	private WebElement incommingMessages;
	private WebElement draftMessages;
	private WebElement sentMessages;
	private WebElement spamMessages;
	private WebElement deletedMessages;
	private WebElement unreadMessages;
	private WebElement markedMessages;
	private WebElement attachedMessages;

	public MailNavigationUnit(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		incommingMessages = driver.findElement(By.xpath("//a[@title='Вхідні']"));
		draftMessages = driver.findElement(By.xpath("//a[@title='Чернетки']"));
		sentMessages = driver.findElement(By.xpath("//a[@title='Надіслані']"));
		spamMessages = driver.findElement(By.xpath("//a[@title='Спам']"));
		deletedMessages = driver.findElement(By.xpath("//a[@title='Видалені']"));
		unreadMessages = driver.findElement(By.xpath("//a[@title='Непрочитані']"));
		markedMessages = driver.findElement(By.xpath("//a[@title='Відмічені']"));
		attachedMessages = driver.findElement(By.xpath("//span[text()='Вкладення']"));
	}

	// page object

	// incomming massages
	public WebElement getIncommingMessages() {
		return incommingMessages;
	}

	public String getIncommingMessagesText() {
		return getIncommingMessages().getText();
	}

	public void clickIncommingMessages() {
		getIncommingMessages().click();
	}

	// draft messages

	public WebElement getDraftMessages() {
		return draftMessages;
	}

	public String getDraftMessagesText() {
		return getDraftMessages().getText();
	}

	public void clickDraftMessages() {
		getDraftMessages().click();
	}

	// sent messages

	public WebElement getSentMessages() {
		return sentMessages;
	}

	public String getSentMessagesText() {
		return getSentMessages().getText();
	}

	public void clickSentMessages() {
		getSentMessages().click();
	}

	// spam messages

	public WebElement getSpamMessages() {
		return spamMessages;
	}

	public String getSpamMessagesText() {
		return getSpamMessages().getText();
	}

	public void clickSpamMessages() {
		getSpamMessages().click();
	}
	// deleted messages

	public WebElement getDeletedMessages() {
		return deletedMessages;
	}

	public String getDeletedMessagesText() {
		return getDeletedMessages().getText();
	}

	public void clickDeletedMessages() {
		getDeletedMessages().click();
	}

	// unread messages

	public WebElement getUnreadMessages() {
		return unreadMessages;
	}

	public String getUnreadMessagesText() {
		return getUnreadMessages().getText();
	}

	public void clickUnreadMessages() {
		getUnreadMessages().click();
	}

	// marked messages

	public WebElement getMarkedMessages() {
		return markedMessages;
	}

	public String getMarkedMessagesText() {
		return getMarkedMessages().getText();
	}

	public void clickMarkedMessages() {
		getMarkedMessages().click();
	}

	// attached messages

	public WebElement getAttachedMessages() {
		return attachedMessages;
	}

	public String getAttachedMessagesText() {
		return getAttachedMessages().getText();
	}

	public void clickAttachedMessages() {
		getAttachedMessages().click();
	}

	// functional

	// business logic

	public IncomesLettersPage openIncomesLettersPage() {
		clickIncommingMessages();
		return new IncomesLettersPage(driver);
	}

	public AttachedLettersPage openAttachedLetterPage() {
		clickAttachedMessages();
		return new AttachedLettersPage(driver);
	}

	public DeletedLettersPage openDeletedLettersPage() {
		clickDeletedMessages();
		return new DeletedLettersPage(driver);
	}

	public DraftLettersPage openDraftLettersPage() {
		clickDraftMessages();
		return new DraftLettersPage(driver);
	}

	public MarkedLettersPage openMarkedLettersPage() {
		clickMarkedMessages();
		return new MarkedLettersPage(driver);
	}

	public SentLettersPage openSentLettersPage() {
		clickSentMessages();
		return new SentLettersPage(driver);
	}

	public SpamLettersPage openSpamLettersPage() {
		clickSpamMessages();
		return new SpamLettersPage(driver);
	}

	public UnreadLettersPage openUnreadLettersPage() {
		clickUnreadMessages();
		return new UnreadLettersPage(driver);
	}

}
