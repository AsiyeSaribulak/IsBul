package IsBul.proje.Core.utilities;

public class ErrorResult extends Result{
	   public ErrorResult() {
	        super("error");
	    }

	    public ErrorResult(String message) {
	        super("error", message);
	    }
}
