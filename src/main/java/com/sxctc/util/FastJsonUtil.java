package com.sxctc.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * ClassName:FastJsonUtil</br>
 * Function: JSON工具类，只支持fastjson</br>
 * 
 * @author liuzc</br>
 * @version 1.0</br>
 * @Date 2017年6月19日 下午12:44:38</br>
 *
 */
public class FastJsonUtil {
	/**
	 * 验证JSONObject 对象是否为空
	 * 
	 * @param JSONObject
	 *            JSONObject对象
	 * @return
	 */
	public static boolean isEmpty(JSONObject JSONObject) {
		// 判断json是否为空
		if (JSONObject == null || JSONObject.size() == 0 ||  JSONObject.isEmpty()) {
			return true;
		}

		return false;
	}

	/**
	 * 验证JSONArray对象是否为空
	 * 
	 * @param JSONArray
	 *            JSONArray对象
	 * @return
	 */
	public static boolean isEmpty(JSONArray JSONArray) {
		// 判断json是否为空
		if (JSONArray == null || JSONArray.size() == 0 ||  JSONArray.isEmpty() ) {
			return true;
		}

		return false;
	}

	/**
	 * 验证JSONObject 对象是否不为空
	 * 
	 * @param JSONObject
	 *            JSONObject对象
	 * @return
	 */
	public static boolean isNotEmpty(JSONObject JSONObject) {
		// 判断json是否为空
		if (JSONObject.size() == 0 || JSONObject == null || JSONObject.isEmpty()) {
			return false;
		}

		return true;
	}

	/**
	 * 验证JSONArray对象是否不为空
	 * 
	 * @param JSONArray
	 *            JSONArray对象
	 * @return
	 */
	public static boolean isNotEmpty(JSONArray JSONArray) {
		// 判断json是否为空
		if (JSONArray.size() == 0 || JSONArray == null || JSONArray.isEmpty() || JSONArray.size() == 0) {
			return false;
		}

		return true;
	}

	/**
	 * 验证该值是否为空
	 * 
	 * @param JSONObject
	 *            JSONObject对象
	 * @param key
	 *            键
	 * @return
	 */
	public static boolean isValueEmpty(JSONObject JSONObject, String key) {
		// 判断该值是否为空
		if (JSONObject.size()==0 || JSONObject.getString(key) == null || JSONObject.getString(key).isEmpty() || StringUtils.isBlank(JSONObject.getString(key))) {
			return true;
		}

		return false;
	}

	/**
	 * 验证该值是否为空
	 * 
	 * @param JSONObject
	 *            JSONObject对象
	 * @param key
	 *            键
	 * @return
	 */
	public static boolean isValueNotEmpty(JSONObject JSONObject, String key) {
		// 判断该值是否为空
		if (JSONObject.size()==0 || JSONObject.getString(key) == null || JSONObject.getString(key).isEmpty() || StringUtils.isBlank(JSONObject.getString(key))) {
			return false;
		}

		return true;
	}
	
	/**
	 * 按照JSONArray中的对象的某个字段进行排序(采用fastJson)
	 * 
	 * @param jsonArrStr
	 *            json数组字符串
	 * 
	 * @return
	 */
	public static String jsonArraySort(String jsonArrStr, final String keyName) {
		// 转成JSON数组
		JSONArray jsonArr = JSON.parseArray(jsonArrStr);
		
		// 最后排序后的数组
		JSONArray sortedJsonArray = new JSONArray();
		
		// 初始化
		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		
		// 将要排序的值取出
		for (int i = 0; i < jsonArr.size(); i++) {
			jsonValues.add(jsonArr.getJSONObject(i));
		}
		
		// 重写排序方法
		Collections.sort(jsonValues, new Comparator<JSONObject>() {
			
			// 你传进来的你想要排序的key值
			private final String KEY_NAME = keyName;

			// 对比方法
			@Override
			public int compare(JSONObject a, JSONObject b) {
				String valA = new String();
				String valB = new String();
				try {
					// 这里是a、b需要处理的业务，需要根据你的规则进行修改。
					valA = a.getString(KEY_NAME);
					//valA = aStr.replaceAll("-", "");
					valB = b.getString(KEY_NAME);
					//valB = bStr.replaceAll("-", "");
				} catch (JSONException e) {
					// do something
				}
				
				// 返回比较结果
				return -valA.compareTo(valB);
			}
		});
		
		// 遍历输出最终结果
		for (int i = 0; i < jsonArr.size(); i++) {
			sortedJsonArray.add(jsonValues.get(i));
		}
		
		// 返回结果集
		return sortedJsonArray.toString();
	}
}
