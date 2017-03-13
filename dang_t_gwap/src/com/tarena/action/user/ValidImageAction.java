package com.tarena.action.user;

/**
 * ����register_form.jsp����֤��
 * 
 * @author soft01
 * 
 */
public class ValidImageAction extends ImageAction {
	private static final long serialVersionUID = 4032029373319826486L;
	// �����ȡ�û��������֤��
	private String code;
	// ������֤���Ƿ����
	private boolean ok = false;

	public String execute() {
		// ��session�ж�ȡ��֤��
		String scode = (String) session.get("code");
		// ����û������code�ʹ�session�ж�ȡ��scode��ͬ,�򷵻�true
		if (code.equalsIgnoreCase(scode)) {
			ok = true;
		} else {
			// �����ͬ������false
			ok = false;
		}
		// ����ajax�����json�����ֵ
		return "success";
	}

	// getter and setter
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}

}
