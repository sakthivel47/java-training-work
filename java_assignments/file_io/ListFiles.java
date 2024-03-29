package problemone;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFiles {
	public static void main(String[] args) {
		
		try {
			List<String> files_list = new ArrayList<String>();
			boolean check = false;
			File[] files = new File(args[0]).listFiles();
			
			if(files == null) {
				System.out.println("No such directory present!");
			} else {

				for(File file : files) {
					if(file.isFile()) {
						files_list.add(file.getName());
						check = true;
					}
				}
				if(!check) {
					System.out.println("No files in this directory");
				}
			}
			boolean checkNoFile = false;
			for(String filename: files_list) {
				String ext = filename.substring(filename.indexOf('.')+1, filename.length());
				if(ext.equals(args[1])) {
					System.out.println(filename);
					checkNoFile = true;
				}
			}
			if(!checkNoFile) {
				System.out.println("No files of that given extension");
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("No arguments given as input\nArguments usage: path extension");
		}
		
	}
}
