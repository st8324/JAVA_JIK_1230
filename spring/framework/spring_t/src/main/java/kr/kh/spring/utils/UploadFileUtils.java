package kr.kh.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	/***
	 * 파일을 업로드하는 메소드
	 * @param uploadPath 업로드할 경로
	 * @param originalName 실제 파일명
	 * @param fileData 업로드할 파일의 실제 데이터
	 * @return 업로드된경로와 uuid가 포함된 파일명
	 * @throws Exception
	 */
    public static String uploadFile(String uploadPath, String originalName, byte[]
            fileData)throws Exception{
    	
        UUID uid = UUID.randomUUID();
        String savedName = uid.toString() +"_" + originalName;
        //날짜를 이용하여 폴더를 생성해서 관리 => 2025-03-26 => 2025폴더 > 03폴더 > 26폴더를 생성하여 경로를 리턴
        String savedPath = calcPath(uploadPath);
        //서버에서 업로드 경로와 날짜 경로를 이용하여 빈 파일을 생성
        File target = new File(uploadPath + savedPath, savedName);
        //업로드할 파일 데이터를 이용하여 복사를 진행
        FileCopyUtils.copy(fileData, target);
        //날짜폴더와 업로드된 파일명이 있는 문자열을 가져옴. \\대신 /로 변환해서 가져옴
        String uploadFileName = getFileName(savedPath, savedName);
        return uploadFileName;
    }

    private static String calcPath(String uploadPath) {
    	//현재 시간을 켈린더 객체로 가져옴
        Calendar cal = Calendar.getInstance();

        //년을 추출해서 앞에 구분자를 추가. \\2025
        //File.separator : 폴더와 폴더 사이를 구분하는 문자열
        String yearPath = File.separator+cal.get(Calendar.YEAR);
        //년과월을 추출해서 앞에 구분자를 추가. \\2025\\03
        String monthPath = yearPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
        // \\2025\\03\\26
        String datePath = monthPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
        
        makeDir(uploadPath, yearPath, monthPath, datePath);

        return datePath;

    }
    /**
     * uploadPath안에 paths 폴더들이 없으면 생성하는 메소드
     * @param uploadPath 폴더들을 만들어준 경로
     * @param paths 만들 폴더명
     */
    private static void makeDir(String uploadPath, String... paths) {
    	//일폴더가 있으면 년,월,일폴더를 만들 필요가 없음
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
    	// \\2025\\03\\26\\uuid_a.jpg
        String iconName = path + File.separator + fileName;
        // /2025/03/26/uuid_a.jpg
        return iconName.replace(File.separatorChar, '/');
    }
    public static void deleteFile(String uploadPath, String fi_name) {
    	// /2025/03/26/uuid_a.jpg => \\2025\\03\\26\\uuid_a.jpg
		fi_name = fi_name.replace('/', File.separatorChar);
		File file = new File(uploadPath + fi_name);
		//파일이 존재하면 파일을 삭제
		if(file.exists()) {
			file.delete();
		}
	}
}