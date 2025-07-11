public class ImageUpload {
    private final String UPLOAD_DIR;

    public ImageUpload() {
        this.UPLOAD_DIR = "uploads"; // Relative folder
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public boolean uploadFile(MultipartFile file) {
        try {
            Files.copy(
                file.getInputStream(),
                Paths.get(UPLOAD_DIR, file.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING
            );
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
