import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/**
 * PinYin4J
 * Created by ZaneLove on 2015/3/10.
 */
public class PinYin4J {

    public static void main(String[] args) {
        /**
         * 单个汉字转换成全拼简单演示
         */
        //'单' 输出 dan1 chan2 shan4 后面的数字代表第几声
        String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray('单');
        for(int i = 0;i < pinyinArray.length;i++) {
            System.out.println(pinyinArray[i]);
        }

        //'黄' 可以输出“huang”、“huang2”、“huáng”，下面的代码就是输出“huáng”
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        String[] pinyinArray1 = null;
        try {
            pinyinArray1 = PinyinHelper.toHanyuPinyinStringArray('黄',format);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }

        for (int i = 0; i < pinyinArray1.length; i++) {
            System.out.println(pinyinArray1[i]);
        }

        /**
         * 一段文字(汉字、阿拉伯数字、英文、标点符号等等)转换成全拼简单演示
         */
        PinYinUtil hanyu = new PinYinUtil();
        // 中英文混合的一段文字
        String str = "是放大镜看附件是款金额，口的境况时。经sdfsdfs典款S！SSDDjksjkdjjdks将的罚款的减肥93##！552@#￥";
        String strPinyin = hanyu.getStringPinYin(str);
        System.out.println(strPinyin);
    }
}
