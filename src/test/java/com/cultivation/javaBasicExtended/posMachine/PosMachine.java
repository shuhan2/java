package com.cultivation.javaBasicExtended.posMachine;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;
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
        int readCode;

        if ((readCode = reader.read()) != -1){
            stringBuilder.append(readCode);
        }
        String string = stringBuilder.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Product> results = objectMapper.readValue(string,
                new TypeReference<Map<String, Product>>() {} );
        // --end-->
    }

    public String printReceipt(String barcodeContent) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start
        String line = System.lineSeparator();
        String dottedLine = "------------------------------------------------------------";
        String price = "Price: ";
        StringBuilder receipts = new StringBuilder("Receipts");
        if (barcodeContent == null || barcodeContent.equals("[]")) {
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