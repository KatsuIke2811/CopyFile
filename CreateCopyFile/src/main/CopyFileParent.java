package main;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ファイルの形式に合わせた具象クラスに継承させる親クラス
 */
public abstract class CopyFileParent {
	/**
	 * ファイルをコピーするメソッド
	 *
	 * @param orgFileName 絶対パス オリジナルのファイル名
	 */
	public abstract void createCopyFile(String orgFileName);

	/**
	 * ファイル名から拡張子を取り除いた名前を返す
	 * @param orgFileName ファイル名
	 * @return 拡張子を除いたファイル名
	 */
	public String getPreffix(String orgFileName) {
	    if (orgFileName == null)
	        return null;
	    int point = orgFileName.lastIndexOf(".");
	    if (point != -1) {
	        return orgFileName.substring(0, point);
	    }
	    return orgFileName;
	}

	/**
	 * ファイルをコピー
	 *
	 * @param orgFileName オリジナルのファイル名
	 * @param newFileName コピーファイル名
	 */
	public void makeFile(String orgFileName, String newFileName) {
		Path orgFile = Paths.get(orgFileName);
		Path newFile = Paths.get(newFileName);
	    try{
	        Files.copy(orgFile, newFile);
	        System.out.println("file copy success");
	    }catch (FileAlreadyExistsException e) {
	    	System.out.println("filename already exists. file copy another name");
	    	// 一度作成したコピーファイル名を改めて修正し、別のファイル名でファイルを作成
	    	createCopyFile(newFileName);
	    }catch(IOException e){
	    	  System.out.println("unknown copy failed : " + e);
	    }
	}
}
