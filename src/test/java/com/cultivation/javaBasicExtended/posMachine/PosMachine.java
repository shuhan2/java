package com.cultivation.javaBasicExtended.posMachine;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

@SuppressWarnings({"WeakerAccess", "unused", "RedundantThrows"})
public class PosMachine {
    public void readDataSource(Reader reader) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start
        if (reader == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();

        reader.read();
        // --end-->
    }

    public String printReceipt(String barcodeContent) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start
        String line = System.lineSeparator();
        String dottedLine = "------------------------------------------------------------";
        String price = "Price: ";
        StringBuilder receipts = new StringBuilder("Receipts");
        if (barcodeContent == null || barcodeContent == "[]") {
            return receipts.append(line).append(dottedLine).append(line).append(dottedLine).append(line).
                    append("Price: ").append(0).append(line).toString();
        }
        else if (barcodeContent.length() > 0){
            return receipts.append(line).append(dottedLine).append(line).append(dottedLine).append(line).append(this).
                    append("Price: ").append(this).append(line).toString();

        }
        else{
            return receipts.append(line).append(dottedLine).append(line).append(dottedLine).append(line).
                    append("Price: ").append(barcodeContent).append(line).toString();

        }
        // --end-->
    }
}

@SuppressWarnings("unused")
class Product {
    private String id;
    private String name;
    private Integer price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;

        Product other = (Product) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}