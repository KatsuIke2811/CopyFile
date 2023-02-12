package main;

import java.io.File;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// キーボード入力の値を受け取る
		// 受け取りたいのはコピーするFileの絶対PATH
		System.out.println("コピーしたいファイルの絶対パスを入力して下さい");
		Scanner scanner = new Scanner(System.in);
		// 標準入力を取得
		String line = scanner.nextLine();
		// scannerを閉じる
		scanner.close();

		// 入力された絶対パスが正しいのか確認
		File targetFile = new File(line);
		// ファイルが作られなければファイルが存在しないので処理しない
		if (targetFile == null || !targetFile.exists()) {
			System.out.println("you missed input PATH");
			return;
		}

		// 拡張子を確認して、Instanceを生成
		CopyFileParent copyFile = CopyFileFactory.createCopyInstanceFactory(targetFile);
		// 具象クラスでコピー処理
		copyFile.createCopyFile(line);

	}

}
