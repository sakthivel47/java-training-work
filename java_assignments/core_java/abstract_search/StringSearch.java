package assignments;

public class StringSearch extends AbstractSearch {

	@Override
	public boolean search(Object[] obj_list, Object obj) {
		for(Object object: obj_list) {
			if(object.equals(obj)) {
				return true;
			}
		}
		return false;
	}
	
}
