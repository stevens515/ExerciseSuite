package cn.itcast.exception;
/**
 *		���ݲ���쳣 
 */
@SuppressWarnings("serial")
public class ServletException extends RuntimeException {
	public ServletException(final String message) {
		super(message);
	}

	public ServletException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
