package com.example.coron.service;

import com.example.coron.util.Utils;
import com.example.coron.exception.BadRequestException;
import com.example.coron.exception.NotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileService {
    // Path folder de upload file
    private final Path rootDir = Paths.get("uploads");

    public FileService() {
        createFolder(rootDir.toString());
    }
    // Tao folder trong truong hop chua ton tai
    public void createFolder(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public String uploadFile(String object,String sku, MultipartFile file) {
        // Tao folder tuong ung voi userId
        Path productDir = Paths.get("uploads").resolve(object);
        createFolder(productDir.toString());
        productDir= Paths.get("uploads",object).resolve(sku);
        createFolder(productDir.toString());
        // Validate file
        validateFile(file);

        // Tao ra file path tuong ung voi file upload
        String generateFileId = String.valueOf(Instant.now().getEpochSecond());
        File fileServer = new File(productDir+"/"+ generateFileId);

        try{
            // Su dung buffer de luu du lieu tu file

            FileOutputStream fileOutputStream= new FileOutputStream(fileServer);

            BufferedOutputStream stream = new BufferedOutputStream(fileOutputStream );

            stream.write(file.getBytes());
            stream.close();

            return "api/v1/products/"+sku+"/files/"+ generateFileId;
        } catch (Exception e) {
            throw new RuntimeException("loi khi upload file");
        }
    }

    public void validateFile(MultipartFile file) {
        // KIem tra ten file
        String fileName = file.getOriginalFilename();
        if (fileName==null || fileName.equals("")){
            throw new BadRequestException("Ten file ko dc de trong");
        }

        // image01.png ->png
        // image02.jpg ->jpg
        // Kiem tra extension
        String fileExtension = Utils.getFileExtension(fileName);
        if (!Utils.checkFileExtension(fileExtension)){
            throw new BadRequestException("File ko hop le");
        }
        //Kiem tra size file (vd toi da 2MB)
        double sizeFile = (double) file.getSize() / 1_000_000L;
        if (sizeFile >2) {
            throw new BadRequestException("File ko vuot qua 2MB");
        }

    }

    // Xem File
    public byte[] readFile(String object,String sku, String fileId){
        // Lay ra duong dan file tuong ung
        Path userPath = rootDir.resolve(object).resolve(sku);

        // Kiem tra duong dan co ton tai hay ko
        if (!Files.exists(userPath)){
            throw new NotFoundException("Ko the doc file"+fileId);
        }

        try {
            // Lay ra duong dan tuong ung voi id va fileId
            Path file = userPath.resolve(fileId);

            Resource resource = new UrlResource(file.toUri());

            if (resource.exists()|| resource.isReadable()){
                InputStream stream = resource.getInputStream();
                byte[] bytes = StreamUtils.copyToByteArray(stream);

                stream.close();
                return bytes;
            } else {
                throw new RuntimeException("Khong the doc file"+fileId);
            }
        } catch (Exception e) {
            throw new RuntimeException("Kong the doc file" + fileId);
        }
    }

    public List<String> getFiles(String object, String sku) {
        // Lay ra duong dan file tuong ung
        Path userPath = rootDir.resolve(object).resolve(sku);

        // Kiem tra duong dan co ton tai hay ko
        if (!Files.exists(userPath)){
            return new ArrayList<>();
        }

        // Lay ra danh sach file tuogn ung user-id
        List<File> files = List.of(userPath.toFile().listFiles());

        // Lay ra danh sach filePAth
        List<String> filesPath = files.stream()
                .map(File::getName)
                .sorted(Comparator.reverseOrder())
                .map(file -> "api/v1/"+object+"/"+sku+"/files/"+file)
                .toList();

        return filesPath;

    }

    public void deleteFile(String object, String sku, String fileId) {
        // Lay ra duong dan file tuong ung
        Path userPath = rootDir.resolve(object).resolve(sku);

        // Kiem tra duong dan co ton tai hay ko
        if (!Files.exists(userPath)){
            throw new NotFoundException("File"+sku+"Ko ton tai");
        }

        // Lay ra duong dan tuong ung voi id va fileId
        Path file = userPath.resolve(fileId);
        if (!file.toFile().exists()){
            throw new NotFoundException("File"+sku+"Ko ton tai");
        }

        //Xoa file.
        file.toFile().delete();
    }
}
