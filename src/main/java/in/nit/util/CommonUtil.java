package in.nit.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class CommonUtil {
	public static Map<Integer, String> convert(List<Object[]> list){
		Map<Integer, String> map=new HashedMap<>();
		for(Object[] arr:list) {
			map.put(Integer.valueOf(arr[0].toString()), arr[1].toString());
		}
		return map;
	}

}
