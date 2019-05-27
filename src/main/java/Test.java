import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeGenWrapper;
import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeOptions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author yanggt
 * @date 19-5-27
 */
public class Test {
    public static void main(String[] args) {
        String logo = "logo.jpg";

        int size = 500;
        try {
            BufferedImage img = QrCodeGenWrapper.of("just for fun")
                    .setW(size)
                    .setH(size)
//                    .setDetectImg("detect.png")
                    .setDrawPreColor(0xff008e59)
//                    .setDrawPreColor(0xff002fa7)
                    .setErrorCorrection(com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.M)
                    .setLogoStyle(QrCodeOptions.LogoStyle.ROUND)
                    .setLogoBgColor(Color.LIGHT_GRAY)
                    .setLogo(logo)
                    .setLogoRate(10)
                    .setDrawStyle(QrCodeOptions.DrawStyle.CIRCLE)
                    .setDrawEnableScale(true)
                    .setBgImg("/home/ht061/ygt/code/zxingdemo/src/main/resources/bg.png")
                    .asBufferedImage();
            ImageIO.write(img, "png", new File("src/main/resources/style.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.google.zxing.WriterException e) {
            e.printStackTrace();
        }
    }
}
