package main.possibleinstance;

import main.CopyFileParent;
import main.Utilities;

/**
 * createCopyInstanceFactoryで対応できなかったファイルについてのクラス
 */
public class CopyUnknown extends CopyFileParent {

	/**
	 * コピーするファイル名を作成し、ファイルをコピー
	 *
	 *@param orgFileName オリジナルファイル名
	 */
	@Override
	public void createCopyFile(String orgFileName) {
		// 新しいファイルの名前を作成
		String newFileName = orgFileName + Utilities.ADD_TO_ORG_NAME;
		// ファイルをコピー
		makeFile(orgFileName, newFileName);

	}

}
