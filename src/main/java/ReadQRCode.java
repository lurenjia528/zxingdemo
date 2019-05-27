
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

/**
 * @author luren
 * @date 2018/7/5
 */
public class ReadQRCode {
    public static void main(String[] args) {
        com.google.zxing.MultiFormatReader formatReader = new com.google.zxing.MultiFormatReader();

        File file = new File("./img.png");
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);

            com.google.zxing.BinaryBitmap binaryBitmap = new com.google.zxing.BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

            HashMap hints = new HashMap();
            hints.put(com.google.zxing.EncodeHintType.CHARACTER_SET, "utf-8");

            com.google.zxing.Result decode = formatReader.decode(binaryBitmap, hints);
            System.out.println("解析结果：" + decode.toString());
            System.out.println("二维码格式：" + decode.getBarcodeFormat());
            System.out.println("二维码文本内容：" + decode.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
