/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

/**
 *
 * @@author Kaye
 */
public class Barcode {

    public static void generateBarcode(String fileName, long productID) throws IOException {

        Code128Bean barcodeGenerator = new Code128Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                300, // dpi
                BufferedImage.TYPE_BYTE_BINARY,
                false,
                0);
//        long salt = 1002232212143L;
        Long barcodeText = productID;
        barcodeGenerator.generateBarcode(canvas, String.valueOf(barcodeText));
        canvas.finish();
        File barcodeFile = new File("barcodes/" + fileName + ".png");
        ImageIO.write(canvas.getBufferedImage(), "png", barcodeFile);
        System.out.println("Barcode created successfully as " + fileName + ".png in barcodes folder");
    }
}
