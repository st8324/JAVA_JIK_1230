package kr.kh.shoppingmall.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	//지정 폴더에 년/월/일 폴더를 생성 후 파일을 업로드
	public static String uploadFile(String uploadPath, String originalName, byte[]
				fileData)throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() +"_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		String uploadFileName = getFileName(savedPath, savedName);
		return uploadFileName;
	}

	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();

		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator
				+ new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator
				+ new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);

		return datePath;

	}
	private static void makeDir(String uploadPath, String... paths) {
		if(new File(uploadPath + paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	private static String getFileName(String path, String fileName)
			throws Exception{
		String iconName = path + File.separator + fileName;
		return iconName.replace(File.separatorChar, '/');
	}
	public static void deleteFile(String uploadPath, String fi_name) {
		fi_name = fi_name.replace('/', File.separatorChar);
		File file = new File(uploadPath + fi_name);
		//파일이 존재하면 파일을 삭제
		if(file.exists()) {
				file.delete();
		}
	}
	//지정 폴더에 폴더들을 추가하여 파일을 업로드
	public static String uploadFile(String uploadPath, String originalName, byte[]
			fileData, String ... paths)throws Exception{
		String savedPath = calcPath(uploadPath, paths);
		File target = new File(uploadPath + savedPath, originalName);
		FileCopyUtils.copy(fileData, target);
		String uploadFileName = getFileName(savedPath, originalName);
		return uploadFileName;
	}
	/**
	 * uploadPath안에 paths폴더들을 생성하여 생성된 최하위 폴더 경로를 반환하는 메소드
	 * @param uploadPath 폴더가 생성될 위치
	 * @param paths 생성할 폴더들로 앞의 폴더가 상위 폴더
	 * @return 생성된 최 하위 폴더
	 */
	private static String calcPath(String uploadPath, String... paths) {
		makeDir(uploadPath, paths);
		return paths[paths.length-1];
	}
}