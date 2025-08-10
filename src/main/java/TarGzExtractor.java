import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TarGzExtractor {
    public static void main(String[] args) {
        String tarGzFilePath = "ethminer-0.18.0-cuda-8-linux-x86_64.tar.gz"; // 압축 해제할 파일 경로
        String destDirPath = "."; // 압축 해제될 디렉토리 경로

        File destDir = new File(destDirPath);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        try (FileInputStream fis = new FileInputStream(tarGzFilePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             GzipCompressorInputStream gis = new GzipCompressorInputStream(bis);
             TarArchiveInputStream tais = new TarArchiveInputStream(gis)) {

            TarArchiveEntry entry;
            while ((entry = (TarArchiveEntry) tais.getNextEntry()) != null) {
                File outputFile = new File(destDir, entry.getName());
                if (entry.isDirectory()) {
                    outputFile.mkdirs();
                } else {
                    try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = tais.read(buffer)) != -1) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
            }
            System.out.println("파일 압축 해제 완료.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
