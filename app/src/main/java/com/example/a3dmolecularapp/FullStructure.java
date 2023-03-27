package com.example.a3dmolecularapp;

public class FullStructure {

    private String id;
    private String model_nums;
    private String encoding;
    private Boolean copy_all_categories;
    private String data_source;
    private String transform;
    private Boolean download;
    private String filename;

    public String getId() {
        return id;
    }

    public String getModel_nums() {
        return model_nums;
    }

    public String getEncoding() {
        return encoding;
    }

    public Boolean getCopy_all_categories() {
        return copy_all_categories;
    }

    public String getData_source() {
        return data_source;
    }

    public String getTransform() {
        return transform;
    }

    public Boolean getDownload() {
        return download;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return "FullStructure{" +
                "id='" + id + '\'' +
                ", model_nums='" + model_nums + '\'' +
                ", encoding='" + encoding + '\'' +
                ", copy_all_categories=" + copy_all_categories +
                ", data_source='" + data_source + '\'' +
                ", transform='" + transform + '\'' +
                ", download=" + download +
                ", filename='" + filename + '\'' +
                '}';
    }
}
