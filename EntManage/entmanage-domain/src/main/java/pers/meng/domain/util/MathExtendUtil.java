package pers.meng.domain.util;

import java.math.BigDecimal;

/**
 * 浮点数精确计算工具类
 *
 */
public class MathExtendUtil {
	
	//默认除法运算精度
	private static final int DEFAULT_DIV_SCALE = 10;
	
	 /**
	  * 精确的加法运算。
	  *@param v1 被加数
	  *@param v2 加数
	  *@return 两个参数的和
	  */
	  public static double add(double v1, double v2){
	      BigDecimal b1 = new BigDecimal(Double.toString(v1));
	      BigDecimal b2 = new BigDecimal(Double.toString(v2));
	      return b1.add(b2).doubleValue();
	  }
	  /**
	   * 精确的加法运算
	   *@param v1 被加数
	   *@param v2 加数
	   *@return 两个参数数学加和，以字符串格式返回
	   */
	  public static String add(String v1, String v2){
	      BigDecimal b1 = new BigDecimal(v1);
	      BigDecimal b2 = new BigDecimal(v2);
	      return b1.add(b2).toString();
	  }
	 
	 /**
	  * 精确的减法运算。
	  *@param v1 被减数
	  *@param v2 加数
	  *@return 两个参数的差
	  */
	  public static double subtract(double v1, double v2){
	      BigDecimal b1 = new BigDecimal(Double.toString(v1));
	      BigDecimal b2 = new BigDecimal(Double.toString(v2));
	      return b1.subtract(b2).doubleValue();
	  }
	
	  /**
	   * 精确的减法运算
	   *@param v1 被减数
	   *@param v2 减数
	   *@return 两个参数数学差，以字符串格式返回
	   */
	  public static String subtract(String v1, String v2){
	      BigDecimal b1 = new BigDecimal(v1);
	      BigDecimal b2 = new BigDecimal(v2);
	      return b1.subtract(b2).toString();
	  }

	  /**
	   * 提供精确的乘法运算。
	   *@param v1 被乘数
	   *@param v2 乘数
	   *@return 两个参数的积
	   */
	   public static double multiply(double v1, double v2){
	       BigDecimal b1 = new BigDecimal(Double.toString(v1));
	       BigDecimal b2 = new BigDecimal(Double.toString(v2));
	       return b1.multiply(b2).doubleValue();
	   }
	  
	   /**
	    * 提供精确的乘法运算
	    *@param v1 被乘数
	    *@param v2 乘数
	    *@return 两个参数的数学积，以字符串格式返回
	    */
	   public static String multiply(String v1, String v2){
	       BigDecimal b1 = new BigDecimal(v1);
	       BigDecimal b2 = new BigDecimal(v2);
	       return b1.multiply(b2).toString();
	   }
	
	/**
	  * （相对）精确的除法运算，当发生除不尽的情况时，精确到
	  * 小数点以后10位，以后的数字四舍五入,舍入模式采用ROUND_HALF_EVEN
	  *@param v1 被除数
	  *@param v2 除数
	  *@return 两个参数的商
	  */
	  public static double divide(double v1, double v2){
	      return divide(v1, v2, DEFAULT_DIV_SCALE);
	  }
	 
	  /**
	   * （相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	   * 定精度，以后的数字四舍五入。舍入模式采用ROUND_HALF_EVEN
	   *@param v1 被除数
	   *@param v2 除数
	   *@param scale 表示需要精确到小数点以后几位。
	   *@return 两个参数的商
	   */
	  public static double divide(double v1,double v2, int scale){
	      return divide(v1, v2, scale, BigDecimal.ROUND_HALF_EVEN);
	  }
	 
	  /**
	   * （相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	   * 定精度，以后的数字四舍五入。舍入模式采用用户指定舍入模式
	   *@param v1 被除数
	   *@param v2 除数
	   *@param scale 表示需要精确到小数点以后几位
	   *@param round_mode 表示用户指定的舍入模式
	   *@return 两个参数的商
	   */
	  public static double divide(double v1,double v2,int scale, int round_mode){
	          if(scale< 0){
	              throw new IllegalArgumentException("The scale must be a positive integer orzero");
	          }
	          BigDecimal b1 = new BigDecimal(Double.toString(v1));
	          BigDecimal b2 = new BigDecimal(Double.toString(v2));
	          return b1.divide(b2, scale, round_mode).doubleValue();
	  }
	 //10.3.44.20    
	  /**
	   * （相对）精确的除法运算，当发生除不尽的情况时，精确到
	   * 小数点以后10位，以后的数字四舍五入,舍入模式采用ROUND_HALF_EVEN
	   *@param v1 被除数
	   *@param v2 除数
	   *@return 两个参数的商，以字符串格式返回
	   */
	  public static String divide(String v1, String v2){
	      return divide(v1, v2, DEFAULT_DIV_SCALE);
	  }
	 
	  /**
	   * （相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	   * 定精度，以后的数字四舍五入。舍入模式采用ROUND_HALF_EVEN
	   *@param v1 被除数
	   *@param v2 除数
	   *@param scale 表示需要精确到小数点以后几位
	   *@return 两个参数的商，以字符串格式返回
	   */
	  public static String divide(String v1, String v2, int scale)
	  {
	      return divide(v1, v2, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_EVEN);
	  }
	 
	  /**
	   * （相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	   * 定精度，以后的数字四舍五入。舍入模式采用用户指定舍入模式
	   *@param v1 被除数
	   *@param v2 除数
	   *@param scale 表示需要精确到小数点以后几位
	   *@param round_mode 表示用户指定的舍入模式
	   *@return 两个参数的商，以字符串格式返回
	   */
	  public static String divide(String v1, String v2, int scale, int round_mode){
	      if(scale< 0){
	          throw new IllegalArgumentException("The scale must be a positive integer orzero");
	      }
	      BigDecimal b1 = new BigDecimal(v1);
	      BigDecimal b2 = new BigDecimal(v2);
	      return b1.divide(b2, scale, round_mode).toString();
	  }
	 
	  /**
	   * 提供精确的小数位四舍五入处理,舍入模式采用ROUND_HALF_EVEN
	   *@param v 需要四舍五入的数字
	   *@param scale 小数点后保留几位
	   *@return 四舍五入后的结果
	   */
	  public static double round(double v,int scale){
	      return round(v, scale, BigDecimal.ROUND_HALF_EVEN);
	  }
	  /**
	   * 提供精确的小数位四舍五入处理,舍入模式采用用户指定模式
	   *@param v 需要四舍五入的数字
	   *@param scale 小数点后保留几位
	   *@param round_mode 指定的舍入模式
	   *@return 四舍五入后的结果
	   */
	  public static double round(double v, int scale, int round_mode){
	     if(scale<0){
	         throw new IllegalArgumentException("The scale must be a positive integer orzero");
	     }
	     BigDecimal b = new BigDecimal(Double.toString(v));
	     return b.setScale(scale, round_mode).doubleValue();
	  }
	 
	  /**
	   * 提供精确的小数位四舍五入处理,舍入模式采用ROUND_HALF_EVEN
	   *@param v 需要四舍五入的数字
	   *@param scale 小数点后保留几位
	   *@return 四舍五入后的结果，以字符串格式返回
	   */
	  public static String round(String v, int scale){
	    return round(v, scale, BigDecimal.ROUND_HALF_EVEN);
	  }
	  /**
	   * 提供精确的小数位四舍五入处理,舍入模式采用用户指定模式
	   *@param v 需要四舍五入的数字
	   *@param scale 小数点后保留几位
	   *@param round_mode 指定的舍入模式
	   *@return 四舍五入后的结果，以字符串格式返回
	   */
	  public static String round(String v, int scale, int round_mode){
	     if(scale<0){
	         throw new IllegalArgumentException("The scale must be a positive integer orzero");
	     }
	     BigDecimal b = new BigDecimal(v);
	     return b.setScale(scale, round_mode).toString();
	  }

}
