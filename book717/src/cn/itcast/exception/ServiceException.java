package cn.itcast.exception;
/**
 * 	ҵ����쳣
 * @author soft01
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {
	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
