package com.softserve.edu.opencart.tools;

import java.util.List;

public interface IExternalReader {

    List<List<String>> getAllCells();

    List<List<String>> getAllCells(String path);

}
