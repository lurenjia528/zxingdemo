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
//                    .setDetectImg("/home/ht061/gocode/src/github.com/lurenjia528/zxingdemo/src/main/resources/detect.png") // 设置定位图标(角落图标)
                    .setDrawPreColor(0xff0000ff)
//                    .setDrawBgColor(0x00000000)
//                    .setDetectOutColor(0xff00FF00)
//                    .setDetectInColor(0x00000000)
//                    .setDrawPreColor(0xff008e59)
//                    .setDrawPreColor(0xff002fa7)
                    .setErrorCorrection(com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.M)
                    .setLogoStyle(QrCodeOptions.LogoStyle.ROUND)
                    .setLogoBgColor(Color.LIGHT_GRAY)
                    .setLogo(logo)
                    .setLogoRate(10)
                    .setDrawStyle(QrCodeOptions.DrawStyle.CIRCLE)
                    .setDrawEnableScale(true)

                    .setBgImg("/home/ht061/gocode/src/github.com/lurenjia528/zxingdemo/src/main/resources/bg.png")
                    .setBgOpacity(0.8f) // 透明度
                    .asBufferedImage();
            ImageIO.write(img, "png", new File("src/main/resources/style.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.google.zxing.WriterException e) {
            e.printStackTrace();
        }
    }
}
