import java.io.IOException;



public class FTPServer {

	private static String fileDir="F://server-directory/";

	/**
	 * 入口
	 * @param args
	 */
	public static void main(String[] args) {
		IPManger.init();
		
		try {
			//参考FTP的模型,启动两个线程,一个数据传输,一个命令传输
			new Thread(new ControlLinkHandler(25060)).start();
			new Thread(new DataLinkHandler(25061)).start();

		} catch (IOException e) {
			throw new IllegalStateException("初始化FTP服务器失败" + e);
		}

	}

	public static String getFileFullPath(String fileName){
		return fileDir+fileName;
	}
	
}
