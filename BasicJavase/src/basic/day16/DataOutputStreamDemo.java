package basic.day16;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class DataOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		String file = "data.dat";
		FileOutputStream out = new FileOutputStream(file);
		/*
		 * ����λ��������<<���ܽ���������ߵ�������������ƶ��������Ҳ�ָ���� λ�����ڵ�λ��0����
		 * ���з��š�����λ��������>>���򽫲�������ߵ�������������ƶ��������Ҳ�ָ����λ����
		 * ���з��š�����λ������ʹ���ˡ�������չ����������Ϊ�������ڸ�λ�� �� 0��������Ϊ�������ڸ�λ���� 1 Java
		 * ��������һ�֡��޷��š�����λ��������>>>�� ���� ʹ���ˡ�����չ�����������������ڸ�λ���� 0����һ�������� C �� C++û�еġ�
		 */
		int n = -3;
		out.write(n >>> 24);
		out.write(n >>> 16);
		out.write(n >>> 8);
		out.write(n);
		out.close();
		IOUtils_1.print(file);

		// �Ա�ʹ�ã�DataOutputStream.���ϱ��Ǹ���������
		file = "data2.dat";
		out = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(out);// �����Ĳ���
		dos.writeInt(-3);
		dos.close();
		IOUtils_1.print(file);
	}
}
