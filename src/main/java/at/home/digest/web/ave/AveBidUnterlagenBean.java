package at.home.digest.web.ave;
import java.io.Serializable;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;

@Named("aveBidUnterlagenBean")
@javax.faces.view.ViewScoped
public class AveBidUnterlagenBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean confirmationDocumentsGiven;
	
	private FacesMessage errorMessageOnDocumentConfirmation;
	
	public boolean isConfirmationDocumentsGiven() {
		return confirmationDocumentsGiven;
	}

	public void setConfirmationDocumentsGiven(boolean confirmationDocumentsGiven) {
		this.confirmationDocumentsGiven = confirmationDocumentsGiven;
		
	}

	public String weiterBid() {
		if (!confirmationDocumentsGiven) {
			String errorMessage = "Please confirm documents for the real estate";
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			this.errorMessageOnDocumentConfirmation = message;
			return null;
		}

		return null;
	}	
	
	public FacesMessage getErrorMessageOnDocumentConfirmation() {
		return errorMessageOnDocumentConfirmation;
	}

	public void onCloseErrorMsgPanel(CloseEvent event) {
		this.errorMessageOnDocumentConfirmation = null;
	}
}
