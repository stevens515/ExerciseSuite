1���ϴ���ɺ�Ҫ�ǵ�ɾ����ʱ�ļ�
	fileitem.delete();
	
2�������ϴ��ļ����ֵ
	ServletFileUpload.setFileSizeMax(1024*1024);
	Ȼ�󲶻�FileUploadBase.FileSizeLimitExceededException�쳣�����û��Ѻ���ʾ

3���ϴ��ļ���������
	ServletFileUpload.setHeaderEncoding("UTF-8");

4���ϴ����ݵ�����
	FileItem.getString("UTF-8")

5�������ϴ��ļ�������
	
	
6��Ϊ��֤�������İ�ȫ���ϴ��ļ��ı���Ҫ��ֹ���ֱ�ӷ��ʵ�

7��Ϊ��ֹ�ļ����ǵ����󣬷�����ҪΪÿһ���ϴ��ļ�����һ��Ψһ���ļ�����UUID��

8���ϴ��ļ�Ҫ��ɢ�洢

9������ͨ���������ļ��������������ļ��ϴ��Ľ���
	upload.setProgressListener(new ProgressListener(){

				public void update(long bytesRead, long contentLength, int items) {

					System.out.println("��ǰ�ļ���С�ǣ�" + contentLength + "����ǰ���ϴ���" + bytesRead);
					
				}
				
	});
	
10��



