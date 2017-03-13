package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	/**
	 * 	���ļ� ��ͨ�� �������
	 * @param in		���ļ��������У���Ӳ��->����  
	 * @param out		�����е�����ȡ�������ӳ��� ->�ļ� 
	 */
	public static void in2Out(InputStream in,OutputStream out){
		try{
			int len = 0;
			byte buffer[] = new byte[1024];
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(in!=null){
				try{
					in.close();
				}catch(IOException e){}
				if(out!=null){
					try{
						out.close();
					}catch(IOException e){}
				}
			}
		}
	}
	public static void in2Out2(InputStream in,OutputStream out){
		try{
			int len=0;
			byte buffer[] = new byte[1024];
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			if(in!=null)
				try{
					in.close();
				}catch(IOException e){}
		}
	}
}
