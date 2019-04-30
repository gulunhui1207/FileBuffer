package FileBuffer;
/**
 * 读取文件内容，然后将内容以byte[]形式输出
 * 
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>succez</p>
 * @author 刘永卓
 * @createdate 2019年4月30日
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileBuffer {
	/**
	 * 通过FileInputStream读取文件里面的内容，然后将读取的内
	 * 容存在ByteArrayOutputStream，使用这个的原因是因为不
	 * 知道共有多少个字节，使用缓冲区能够很好地，避免出现溢出问题。
	 *
	 * @param fobj
	 * @return 
	 */
	public static byte[] file2buf(File fobj) {
		byte[] fileByte=null;
		try {
			FileInputStream fis = new FileInputStream(fobj);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[100];
			int len = -1;
			while((len = fis.read(b)) != -1) {
			    bos.write(b, 0, len);
			}
			fileByte = bos.toByteArray();
			fis.close();  
            bos.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("文件不存在");
			return null;
		}catch (IOException e) {  
            //e.printStackTrace();  
			System.out.println("文件读取错误");
            return null;
        }  
		return fileByte;
	}
	
	public static void main(String[] args) {
		File fobj=new File("D:\\a.txt");
		byte[] FileByte=null;
		FileByte=file2buf(fobj);
		if(FileByte!=null)
		for(int i=0;i<FileByte.length;i++){
			System.out.println(FileByte[i]);
		}
	}
}
