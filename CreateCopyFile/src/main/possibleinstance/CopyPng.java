package main.possibleinstance;

import main.CopyFileParent;
import main.Utilities;

/**
 * Pngコピークラス
 */
public class CopyPng extends CopyFileParent {
	public static final String PNG_EXTENSION = ".png";

	/**
	 * コピーするファイル名を作成し、ファイルをコピー
	 *
	 *@param orgFileName オリジナルファイル名
	 */
	@Override
	public void createCopyFile(String orgFileName) {

		// 新しいファイルの名前を作成
		// 一度拡張子部分を外す
		String newNameNotExistExtension = getPreffix(orgFileName);
		// ファイル名の後ろに文字列を加えて、拡張子を再度つける
		String newFileName = newNameNotExistExtension + Utilities.ADD_TO_ORG_NAME + PNG_EXTENSION;
		// ファイルをコピー
		makeFile(orgFileName, newFileName);
	}

}
