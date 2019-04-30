/**
 * 
 */
package FileBuffer;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

/**
 * 测试用例
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>succez</p>
 * @author 刘永卓
 * @createdate 2019年4月30日
 */
public class FileBufferTests {
	FileBuffer file=new FileBuffer();
	@Test
	public void test1() {
		File fobj=new File("D:\\a.txt");
		byte[] FileByte=null;
		byte[] test={65,65,65};
		FileByte=file.file2buf(fobj);
		assertTrue(Arrays.equals(test,FileByte));
	}
	@Test
	public void test2() {
		File fobj=new File("D:\\ab.txt");
		byte[] FileByte=file.file2buf(fobj);
		assertNull(FileByte);
	}
}
