package com.softserve.edu.opencart.tools;

public interface IFileReader extends IExternalReader {

    String FILE_NOT_FOUND_EXCEPTION = "File %s could not be found";
    String FILE_NOT_READ_EXCEPTION = "File %s could not be read";
    String FILE_NOT_CLOSE_EXCEPTION = "File %s could not be closed";
    String PATH_SEPARATOR = "/";

    String getFilename();

    String getPath();

}
