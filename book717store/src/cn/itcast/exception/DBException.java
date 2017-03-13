package cn.itcast.exception;

/**
 * RuntimeException����ʱ������ʾ�ڽ�����
 * Exception����ʱ���ڽ�������ʾ��������Ҫ��ʾ�ڽ�����ʱ��Ҫ�̳�Exception
 * ���ݿ���쳣 �̳д�Exception���쳣ʱ�������ڷ�����throws��
 * ����̳���RuntimeException�Ͳ��ã��������ǳ���RuntimeException
 */
@SuppressWarnings("serial")
public class DBException extends RuntimeException {
	public DBException(String message) {
		super(message);
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}
}
