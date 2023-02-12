package main.possibleinstance;

import main.CopyFileParent;
import main.Utilities;

/**
 * Txtコピークラス
 */
public class CopyTxt extends CopyFileParent {
	public static final String TXT_EXTENSION = ".txt";

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
		String newFileName = newNameNotExistExtension + Utilities.ADD_TO_ORG_NAME + TXT_EXTENSION;

		// ファイルをコピー
		makeFile(orgFileName, newFileName);
	}


}
