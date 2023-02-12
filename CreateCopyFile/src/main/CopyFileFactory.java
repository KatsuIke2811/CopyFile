package main;

import java.io.File;

import main.possibleinstance.CopyPng;
import main.possibleinstance.CopyTxt;
import main.possibleinstance.CopyUnknown;

/**
 * コピーするファイルに適したInstanceを生成するFactoryクラス
 */
public class CopyFileFactory {

	/**
	 * 拡張子をを抽出
	 * 使用するクラスを切り分ける
	 *
	 * @param targetFile オリジナルのファイル
	 * @return ファイルの拡張子に応じたInstance
	 */
	public static CopyFileParent createCopyInstanceFactory(File targetFile) {
		CopyFileParent copyFile = null;
		// 入力された内容を確認して切り分け
		String fileName = targetFile.getName();
		String extention = fileName.substring(fileName.lastIndexOf("."));

		if (extention.equals(CopyTxt.TXT_EXTENSION)) {
			// Txtファイルをコピーするクラス
			copyFile = new CopyTxt();
		} else if (extention.equals(CopyPng.PNG_EXTENSION)) {
			// Pngファイルをコピーするクラス
			copyFile = new CopyPng();
		} else {
			// 上記条件に当てはまらないクラス
			copyFile = new CopyUnknown();
		}
		return copyFile;
	}
}
