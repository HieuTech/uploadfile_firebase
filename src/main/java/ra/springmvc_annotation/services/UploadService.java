package ra.springmvc_annotation.services;


import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadService {

    @Autowired
    private ServletContext servletContext;
    //tiem bean vao
    //quy trinh
    //upload tu máy lên trên thư mục tạo ở server, sau đó mới upload lên firebase
    @Autowired
    private Storage storage;
    public String uploadFile(MultipartFile file){
        String bucketName = "e-commerce-cake.appspot.com";
        //upload file len server
        String uploadPath = servletContext.getRealPath("/upload");
        File fileUpload = new File(uploadPath);
        if (!fileUpload.exists()){
            fileUpload.mkdirs();
        }
        String localFilePath = uploadPath + File.separator + file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(localFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return uploadFileToFirebaseStorage(storage,localFilePath,bucketName);
    }
    private String uploadFileToFirebaseStorage(Storage storage, String localFilePath, String bucketName) {
        Path localPath = Paths.get(localFilePath);
        String fileName = localPath.getFileName().toString();

        BlobId blobId = BlobId.of(bucketName, fileName);// tạo định danh file upload thông qua kho lưu
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        // Thiết lập quyền truy cập công cộng- lấy ra đường dẫn công khai
        List<Acl> acls = new ArrayList<>();
        acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
        blobInfo = blobInfo.toBuilder().setAcl(acls).build() ;// thêm quyền vào cấu hình file upload
        try {
            Blob blob = storage.create(blobInfo, Files.readAllBytes(localPath));
            return blob.getMediaLink();//lấy về đường dẫn vừa upload online +
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
